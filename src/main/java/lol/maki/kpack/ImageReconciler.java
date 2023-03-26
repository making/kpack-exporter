package lol.maki.kpack;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import io.kpack.models.V1alpha2Image;
import io.kpack.models.V1alpha2ImageStatus;
import io.kpack.models.V1alpha2ImageStatusConditions;
import io.kubernetes.client.extended.controller.reconciler.Reconciler;
import io.kubernetes.client.extended.controller.reconciler.Request;
import io.kubernetes.client.extended.controller.reconciler.Result;
import io.kubernetes.client.informer.SharedIndexInformer;
import io.micrometer.core.instrument.Meter.Id;
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

	private final ConcurrentMap<Key, AtomicInteger> metricsMap = new ConcurrentHashMap<>();

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
		final V1alpha2ImageStatus status = image.getStatus();
		if (status != null) {
			final List<V1alpha2ImageStatusConditions> conditions = status.getConditions();
			if (conditions != null) {
				for (V1alpha2ImageStatusConditions condition : conditions) {
					final String type = condition.getType();
					if (type == null) {
						continue;
					}
					final String metricName = "kpack_image_%s".formatted(StringUtils.upperCamelToSnake(type));
					final String s = condition.getStatus();
					if ("Unknown".equalsIgnoreCase(s)) {
						continue;
					}
					final Key key = new Key(namespace, name, metricName);
					final int value = Boolean.parseBoolean(s) ? 1 : 0;
					AtomicInteger metricsValue = this.metricsMap.get(key);
					if (metricsValue == null) {
						final AtomicInteger newValue = new AtomicInteger(value);
						final AtomicInteger existing = this.metricsMap.putIfAbsent(key, newValue);
						if (existing == null) {
							log.info("Register {}/{} {} {}", namespace, name, type, s);
							this.meterRegistry.gauge(metricName, labels(namespace, name), newValue);
						}
						else {
							metricsValue = existing;
						}
					}
					if (metricsValue != null) {
						if (value != metricsValue.get()) {
							log.info("Update {}/{} {} {}", namespace, name, type, s);
						}
						metricsValue.set(value);
					}
				}
			}
		}
		return new Result(false);
	}

	void removeMetrics(String namespace, String name) {
		final Set<Key> keys = this.metricsMap.keySet()
			.stream()
			.filter(key -> Objects.equals(key.namespace(), namespace) && Objects.equals(key.name(), name))
			.collect(Collectors.toUnmodifiableSet());
		keys.forEach(key -> {
			final Id id = new Id(key.metricName(), key.tags(), null, null, Type.GAUGE);
			this.meterRegistry.remove(id);
			this.metricsMap.remove(key);
		});
	}

	static Tags labels(String namespace, String name) {
		return Tags.of("namespace", namespace, "name", name);
	}

	record Key(String namespace, String name, String metricName) {
		Tags tags() {
			return labels(namespace, name);
		}
	}

}
