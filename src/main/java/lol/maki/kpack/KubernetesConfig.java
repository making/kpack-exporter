package lol.maki.kpack;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.kpack.models.V1alpha2ClusterBuilder;
import io.kpack.models.V1alpha2ClusterBuilderList;
import io.kpack.models.V1alpha2ClusterBuilderStatus;
import io.kpack.models.V1alpha2ClusterBuilderStatusConditions;
import io.kpack.models.V1alpha2Image;
import io.kpack.models.V1alpha2ImageList;
import io.kpack.models.V1alpha2ImageStatus;
import io.kpack.models.V1alpha2ImageStatusConditions;
import io.kubernetes.client.extended.controller.Controller;
import io.kubernetes.client.extended.controller.builder.ControllerBuilder;
import io.kubernetes.client.extended.controller.builder.DefaultControllerBuilder;
import io.kubernetes.client.informer.SharedIndexInformer;
import io.kubernetes.client.informer.SharedInformerFactory;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.util.generic.GenericKubernetesApi;
import io.micrometer.core.instrument.MeterRegistry;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class KubernetesConfig {

	@Bean
	public GenericKubernetesApi<V1alpha2Image, V1alpha2ImageList> imageApi(ApiClient apiClient) {
		return new GenericKubernetesApi<>(V1alpha2Image.class, V1alpha2ImageList.class, "kpack.io", "v1alpha2",
				"images", apiClient);
	}

	@Bean
	public GenericKubernetesApi<V1alpha2ClusterBuilder, V1alpha2ClusterBuilderList> clusterBuilderApi(
			ApiClient apiClient) {
		return new GenericKubernetesApi<>(V1alpha2ClusterBuilder.class, V1alpha2ClusterBuilderList.class, "kpack.io",
				"v1alpha2", "clusterbuilders", apiClient);
	}

	@Bean(destroyMethod = "shutdown")
	public Controller imageController(SharedInformerFactory sharedInformerFactory,
			GenericKubernetesApi<V1alpha2Image, V1alpha2ImageList> api, MeterRegistry meterRegistry) {
		final SharedIndexInformer<V1alpha2Image> sharedIndexInformer = sharedInformerFactory.sharedIndexInformerFor(api,
				V1alpha2Image.class, 0);
		final KpackReconciler<V1alpha2Image, V1alpha2ImageStatus, V1alpha2ImageStatusConditions> reconciler = new KpackReconciler<>(
				V1alpha2Image.class, sharedIndexInformer, meterRegistry, V1alpha2Image::getStatus,
				V1alpha2ImageStatus::getConditions, V1alpha2ImageStatusConditions::getType,
				V1alpha2ImageStatusConditions::getStatus);
		final DefaultControllerBuilder builder = ControllerBuilder.defaultBuilder(sharedInformerFactory)
			.watch(queue -> ControllerBuilder.controllerWatchBuilder(V1alpha2Image.class, queue)
				.withResyncPeriod(Duration.ofSeconds(1))
				.build())
			.withWorkerCount(1);
		return builder.withReconciler(reconciler) //
			.withReadyFunc(sharedIndexInformer::hasSynced)
			.withName("image-controller")
			.build();
	}

	@Bean(destroyMethod = "shutdown")
	public Controller clusterBuilderController(SharedInformerFactory sharedInformerFactory,
			GenericKubernetesApi<V1alpha2ClusterBuilder, V1alpha2ClusterBuilderList> api, MeterRegistry meterRegistry) {
		final SharedIndexInformer<V1alpha2ClusterBuilder> sharedIndexInformer = sharedInformerFactory
			.sharedIndexInformerFor(api, V1alpha2ClusterBuilder.class, 0);
		final KpackReconciler<V1alpha2ClusterBuilder, V1alpha2ClusterBuilderStatus, V1alpha2ClusterBuilderStatusConditions> reconciler = new KpackReconciler<>(
				V1alpha2ClusterBuilder.class, sharedIndexInformer, meterRegistry, V1alpha2ClusterBuilder::getStatus,
				V1alpha2ClusterBuilderStatus::getConditions, V1alpha2ClusterBuilderStatusConditions::getType,
				V1alpha2ClusterBuilderStatusConditions::getStatus);
		final DefaultControllerBuilder builder = ControllerBuilder.defaultBuilder(sharedInformerFactory)
			.watch(queue -> ControllerBuilder.controllerWatchBuilder(V1alpha2ClusterBuilder.class, queue)
				.withResyncPeriod(Duration.ofSeconds(1))
				.build())
			.withWorkerCount(1);
		return builder.withReconciler(reconciler) //
			.withReadyFunc(sharedIndexInformer::hasSynced)
			.withName("cluster-builder-controller")
			.build();
	}

	@Bean
	public ApplicationRunner runner(SharedInformerFactory sharedInformerFactory, List<Controller> controllers) {
		final ExecutorService executorService = Executors.newCachedThreadPool();
		sharedInformerFactory.startAllRegisteredInformers();
		return args -> controllers.forEach(controller -> executorService.execute(controller::run));
	}

}
