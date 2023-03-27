package lol.maki.kpack;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.kpack.models.V1alpha2Image;
import io.kpack.models.V1alpha2ImageList;
import io.kubernetes.client.extended.controller.Controller;
import io.kubernetes.client.extended.controller.builder.ControllerBuilder;
import io.kubernetes.client.extended.controller.builder.DefaultControllerBuilder;
import io.kubernetes.client.extended.controller.reconciler.Reconciler;
import io.kubernetes.client.informer.SharedIndexInformer;
import io.kubernetes.client.informer.SharedInformerFactory;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.util.generic.GenericKubernetesApi;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class KubernetesConfig {

	@Bean
	public GenericKubernetesApi<V1alpha2Image, V1alpha2ImageList> ImageApi(ApiClient apiClient) {
		return new GenericKubernetesApi<>(V1alpha2Image.class, V1alpha2ImageList.class, "kpack.io", "v1alpha2",
				"images", apiClient);
	}

	@Bean
	public SharedIndexInformer<V1alpha2Image> sharedIndexInformer(SharedInformerFactory sharedInformerFactory,
			GenericKubernetesApi<V1alpha2Image, V1alpha2ImageList> ImageApi) {
		return sharedInformerFactory.sharedIndexInformerFor(ImageApi, V1alpha2Image.class, 0);
	}

	@Bean(destroyMethod = "shutdown")
	public Controller imageController(SharedInformerFactory sharedInformerFactory, Reconciler reconciler,
			SharedIndexInformer<V1alpha2Image> shareIndexInformer) {
		DefaultControllerBuilder Imageer = ControllerBuilder //
			.defaultBuilder(sharedInformerFactory)//
			.watch(queue -> ControllerBuilder //
				.controllerWatchBuilder(V1alpha2Image.class, queue)//
				.withResyncPeriod(Duration.ofSeconds(1))//
				.build()) //
			.withWorkerCount(2);
		return Imageer//
			.withReconciler(reconciler) //
			.withReadyFunc(shareIndexInformer::hasSynced) // optional: only start once
			// the index is synced
			.withName("image-controller") ///
			.build();
	}

	@Bean
	public ApplicationRunner runner(SharedInformerFactory sharedInformerFactory, Controller controller) {
		final ExecutorService executorService = Executors.newSingleThreadExecutor();
		return args -> executorService.execute(() -> {
			sharedInformerFactory.startAllRegisteredInformers();
			controller.run();
		});
	}

}
