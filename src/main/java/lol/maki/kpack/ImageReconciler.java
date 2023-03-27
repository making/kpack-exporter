package lol.maki.kpack;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import io.kpack.models.V1alpha2Image;
import io.kpack.models.V1alpha2ImageStatus;
import io.kpack.models.V1alpha2ImageStatusConditions;
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

import org.springframework.stereotype.Component;

@Component
public class ImageReconciler implements Reconciler {

	private final Logger log = LoggerFactory.getLogger(ImageReconciler.class);

	private final SharedIndexInformer<V1alpha2Image> sharedIndexInformer;

	private final MeterRegistry meterRegistry;

	private final ConcurrentMap<Meter.Id, AtomicInteger> metricsMap = new ConcurrentHashMap<>();

	private static final String METRIC_NAME = "kpack_image_ready";

	public ImageReconciler(SharedIndexInformer<V1alpha2Image> sharedIndexInformer, MeterRegistry meterRegistry) {
		this.sharedIndexInformer = sharedIndexInformer;
		this.meterRegistry = meterRegistry;
	}

	@Override
	public Result reconcile(Request request) {
		final String namespace = request.getNamespace();
		final String name = request.getName();
		final V1alpha2Image image = this.sharedIndexInformer.getIndexer().getByKey("%s/%s".formatted(namespace, name));
		if (image == null) {
			log.info("Remove {}/{}", namespace, name);
			this.removeMetrics(namespace, name);
			return new Result(false);
		}
		final V1alpha2ImageStatus imageStatus = image.getStatus();
		if (imageStatus != null) {
			final List<V1alpha2ImageStatusConditions> conditions = imageStatus.getConditions();
			if (conditions != null) {
				conditions.stream()
					.filter(c -> "Ready".equalsIgnoreCase(c.getType()))
					.filter(c -> !"Unknown".equalsIgnoreCase(c.getStatus()))
					.findAny()
					.ifPresent(condition -> {
						final String status = condition.getStatus();
						final Meter.Id id = id(namespace, name);
						final int value = Boolean.parseBoolean(status) ? 1 : 0;
						AtomicInteger metricsValue = this.metricsMap.get(id);
						if (metricsValue == null) {
							final AtomicInteger newValue = new AtomicInteger(value);
							final AtomicInteger existing = this.metricsMap.putIfAbsent(id, newValue);
							if (existing == null) {
								log.info("Register {}/{} {}", namespace, name, status);
								this.meterRegistry.gauge(METRIC_NAME, tags(namespace, name), newValue);
							}
							else {
								metricsValue = existing;
							}
						}
						if (metricsValue != null) {
							if (value != metricsValue.get()) {
								log.info("Update {}/{} {}", namespace, name, status);
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

	Meter.Id id(String namespace, String name) {
		return new Meter.Id(METRIC_NAME, tags(namespace, name), null, null, Type.GAUGE);
	}

	static Tags tags(String namespace, String name) {
		return Tags.of("namespace", namespace, "name", name);
	}

}
