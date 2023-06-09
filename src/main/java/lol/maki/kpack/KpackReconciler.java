package lol.maki.kpack;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import io.kubernetes.client.common.KubernetesObject;
import io.kubernetes.client.extended.controller.reconciler.Reconciler;
import io.kubernetes.client.extended.controller.reconciler.Request;
import io.kubernetes.client.extended.controller.reconciler.Result;
import io.kubernetes.client.informer.SharedIndexInformer;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Type;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.util.StringUtils;

public class KpackReconciler<ApiType extends KubernetesObject, ResourceStatus, ResourceCondition>
		implements Reconciler {

	private final Logger log = LoggerFactory.getLogger(KpackReconciler.class);

	private final SharedIndexInformer<ApiType> sharedIndexInformer;

	private final MeterRegistry meterRegistry;

	private final ConcurrentMap<Meter.Id, AtomicInteger> metricsMap = new ConcurrentHashMap<>();

	private final String metricsPrefix;

	private final Function<ApiType, ResourceStatus> getResourceStatus;

	private final Function<ResourceStatus, List<ResourceCondition>> getConditions;

	private final Function<ResourceCondition, String> getType;

	private final Function<ResourceCondition, String> getStatus;

	private final ApplicationEventPublisher eventPublisher;

	private final String kind;

	public KpackReconciler(Class<ApiType> clazz, String metricsPrefix, SharedIndexInformer<ApiType> sharedIndexInformer,
			MeterRegistry meterRegistry, Function<ApiType, ResourceStatus> getResourceStatus,
			Function<ResourceStatus, List<ResourceCondition>> getConditions,
			Function<ResourceCondition, String> getType, Function<ResourceCondition, String> getStatus,
			ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
		this.kind = clazz.getSimpleName().replace("V1alpha1", "").replace("V1alpha2", "");
		this.metricsPrefix = metricsPrefix;
		this.sharedIndexInformer = sharedIndexInformer;
		this.meterRegistry = meterRegistry;
		this.getResourceStatus = getResourceStatus;
		this.getConditions = getConditions;
		this.getType = getType;
		this.getStatus = getStatus;
	}

	@Override
	public Result reconcile(Request request) {
		final String name = request.getName();
		final String namespace = request.getNamespace();
		final String key = namespace != null ? namespace + "/" + name : name;
		final ApiType apiType = this.sharedIndexInformer.getIndexer().getByKey(key);
		if (apiType == null) {
			log.info("Remove {} {}", this.kind, key);
			this.removeMetrics(namespace, name);
			return new Result(false);
		}
		final ResourceStatus resourceStatus = this.getResourceStatus.apply(apiType);
		if (resourceStatus != null) {
			final List<ResourceCondition> conditions = this.getConditions.apply(resourceStatus);
			if (conditions != null) {
				conditions.stream()
					.filter(c -> "Ready".equalsIgnoreCase(this.getType.apply(c)))
					.filter(c -> !"Unknown".equalsIgnoreCase(this.getStatus.apply(c)))
					.findAny()
					.ifPresent(condition -> {
						final String status = this.getStatus.apply(condition);
						final Meter.Id id = id(namespace, name);
						final int value = Boolean.parseBoolean(status) ? 1 : 0;
						AtomicInteger metricsValue = this.metricsMap.get(id);
						if (metricsValue == null) {
							final AtomicInteger newValue = new AtomicInteger(value);
							final AtomicInteger existing = this.metricsMap.putIfAbsent(id, newValue);
							if (existing == null) {
								log.info("Register {} {} {}", this.kind, key, status);
								this.meterRegistry.gauge(this.metricsName(namespace), tags(namespace, name), newValue);
								if (value == 0) {
									this.eventPublisher.publishEvent(
											new StatusChangedEvent(AlertType.FAILURE, this.kind, namespace, name));
								}
							}
							else {
								metricsValue = existing;
							}
						}
						if (metricsValue != null) {
							if (value != metricsValue.get()) {
								log.info("Update {} {} {}", this.kind, key, status);
								if (value == 1) {
									this.eventPublisher.publishEvent(
											new StatusChangedEvent(AlertType.SUCCESS, this.kind, namespace, name));
								}
								else {
									this.eventPublisher.publishEvent(
											new StatusChangedEvent(AlertType.FAILURE, this.kind, namespace, name));
								}
							}
							metricsValue.set(value);
						}
					});
			}
		}
		return new Result(false);
	}

	void removeMetrics(String namespace, String name) {
		final Meter.Id id = id(namespace, name);
		this.meterRegistry.remove(id);
		this.metricsMap.remove(id);
	}

	String metricsName(String namespace) {
		return "%s_%sresource_ready".formatted(metricsPrefix, namespace == null ? "cluster" : "");
	}

	Meter.Id id(String namespace, String name) {
		return new Meter.Id(this.metricsName(namespace), tags(namespace, name), null, null, Type.GAUGE);
	}

	Tags tags(String namespace, String name) {
		if (StringUtils.hasLength(namespace)) {
			return Tags.of("kind", this.kind, "namespace", namespace, "name", name);
		}
		else {
			return Tags.of("kind", this.kind, "name", name);
		}
	}

}
