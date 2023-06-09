package lol.maki.kpack;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdater;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterList;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterStatus;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterStatusConditions;
import com.vmware.tanzu.stacksoperator.stacks.models.V1alpha1CustomStack;
import com.vmware.tanzu.stacksoperator.stacks.models.V1alpha1CustomStackList;
import com.vmware.tanzu.stacksoperator.stacks.models.V1alpha1CustomStackStatus;
import com.vmware.tanzu.stacksoperator.stacks.models.V1alpha1CustomStackStatusConditions;
import io.kpack.models.V1alpha2Builder;
import io.kpack.models.V1alpha2BuilderList;
import io.kpack.models.V1alpha2BuilderStatus;
import io.kpack.models.V1alpha2BuilderStatusConditions;
import io.kpack.models.V1alpha2ClusterBuilder;
import io.kpack.models.V1alpha2ClusterBuilderList;
import io.kpack.models.V1alpha2ClusterBuilderStatus;
import io.kpack.models.V1alpha2ClusterBuilderStatusConditions;
import io.kpack.models.V1alpha2ClusterStack;
import io.kpack.models.V1alpha2ClusterStackList;
import io.kpack.models.V1alpha2ClusterStackStatus;
import io.kpack.models.V1alpha2ClusterStackStatusConditions;
import io.kpack.models.V1alpha2ClusterStore;
import io.kpack.models.V1alpha2ClusterStoreList;
import io.kpack.models.V1alpha2ClusterStoreStatus;
import io.kpack.models.V1alpha2ClusterStoreStatusConditions;
import io.kpack.models.V1alpha2Image;
import io.kpack.models.V1alpha2ImageList;
import io.kpack.models.V1alpha2ImageStatus;
import io.kpack.models.V1alpha2ImageStatusConditions;
import io.kubernetes.client.extended.controller.Controller;
import io.kubernetes.client.extended.controller.builder.ControllerBuilder;
import io.kubernetes.client.informer.SharedIndexInformer;
import io.kubernetes.client.informer.SharedInformerFactory;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.util.generic.GenericKubernetesApi;
import io.micrometer.core.instrument.MeterRegistry;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(BuiltinAlertProps.class)
@EnableAsync
public class KubernetesConfig implements AsyncConfigurer {

	@Bean
	public GenericKubernetesApi<V1alpha2Image, V1alpha2ImageList> imageApi(ApiClient apiClient) {
		return new GenericKubernetesApi<>(V1alpha2Image.class, V1alpha2ImageList.class, "kpack.io", "v1alpha2",
				"images", apiClient);
	}

	@Bean(destroyMethod = "shutdown")
	public Controller imageController(SharedInformerFactory sharedInformerFactory,
			GenericKubernetesApi<V1alpha2Image, V1alpha2ImageList> api, MeterRegistry meterRegistry,
			ApplicationEventPublisher eventPublisher) {
		final SharedIndexInformer<V1alpha2Image> sharedIndexInformer = sharedInformerFactory.sharedIndexInformerFor(api,
				V1alpha2Image.class, 0);
		final KpackReconciler<V1alpha2Image, V1alpha2ImageStatus, V1alpha2ImageStatusConditions> reconciler = new KpackReconciler<>(
				V1alpha2Image.class, "kpack", sharedIndexInformer, meterRegistry, V1alpha2Image::getStatus,
				V1alpha2ImageStatus::getConditions, V1alpha2ImageStatusConditions::getType,
				V1alpha2ImageStatusConditions::getStatus, eventPublisher);
		return ControllerBuilder.defaultBuilder(sharedInformerFactory)
			.watch(queue -> ControllerBuilder.controllerWatchBuilder(V1alpha2Image.class, queue)
				.withResyncPeriod(Duration.ofSeconds(1))
				.build())
			.withWorkerCount(1)
			.withReconciler(reconciler)
			.withReadyFunc(sharedIndexInformer::hasSynced)
			.withName("image-controller")
			.build();
	}

	@Bean
	public GenericKubernetesApi<V1alpha2Builder, V1alpha2BuilderList> builderApi(ApiClient apiClient) {
		return new GenericKubernetesApi<>(V1alpha2Builder.class, V1alpha2BuilderList.class, "kpack.io", "v1alpha2",
				"builders", apiClient);
	}

	@Bean(destroyMethod = "shutdown")
	public Controller builderController(SharedInformerFactory sharedInformerFactory,
			GenericKubernetesApi<V1alpha2Builder, V1alpha2BuilderList> api, MeterRegistry meterRegistry,
			ApplicationEventPublisher eventPublisher) {
		final SharedIndexInformer<V1alpha2Builder> sharedIndexInformer = sharedInformerFactory
			.sharedIndexInformerFor(api, V1alpha2Builder.class, 0);
		final KpackReconciler<V1alpha2Builder, V1alpha2BuilderStatus, V1alpha2BuilderStatusConditions> reconciler = new KpackReconciler<>(
				V1alpha2Builder.class, "kpack", sharedIndexInformer, meterRegistry, V1alpha2Builder::getStatus,
				V1alpha2BuilderStatus::getConditions, V1alpha2BuilderStatusConditions::getType,
				V1alpha2BuilderStatusConditions::getStatus, eventPublisher);
		return ControllerBuilder.defaultBuilder(sharedInformerFactory)
			.watch(queue -> ControllerBuilder.controllerWatchBuilder(V1alpha2Builder.class, queue)
				.withResyncPeriod(Duration.ofSeconds(1))
				.build())
			.withWorkerCount(1)
			.withReconciler(reconciler)
			.withReadyFunc(sharedIndexInformer::hasSynced)
			.withName("builder-controller")
			.build();
	}

	@Bean
	public GenericKubernetesApi<V1alpha2ClusterBuilder, V1alpha2ClusterBuilderList> clusterBuilderApi(
			ApiClient apiClient) {
		return new GenericKubernetesApi<>(V1alpha2ClusterBuilder.class, V1alpha2ClusterBuilderList.class, "kpack.io",
				"v1alpha2", "clusterbuilders", apiClient);
	}

	@Bean(destroyMethod = "shutdown")
	public Controller clusterBuilderController(SharedInformerFactory sharedInformerFactory,
			GenericKubernetesApi<V1alpha2ClusterBuilder, V1alpha2ClusterBuilderList> api, MeterRegistry meterRegistry,
			ApplicationEventPublisher eventPublisher) {
		final SharedIndexInformer<V1alpha2ClusterBuilder> sharedIndexInformer = sharedInformerFactory
			.sharedIndexInformerFor(api, V1alpha2ClusterBuilder.class, 0);
		final KpackReconciler<V1alpha2ClusterBuilder, V1alpha2ClusterBuilderStatus, V1alpha2ClusterBuilderStatusConditions> reconciler = new KpackReconciler<>(
				V1alpha2ClusterBuilder.class, "kpack", sharedIndexInformer, meterRegistry,
				V1alpha2ClusterBuilder::getStatus, V1alpha2ClusterBuilderStatus::getConditions,
				V1alpha2ClusterBuilderStatusConditions::getType, V1alpha2ClusterBuilderStatusConditions::getStatus,
				eventPublisher);
		return ControllerBuilder.defaultBuilder(sharedInformerFactory)
			.watch(queue -> ControllerBuilder.controllerWatchBuilder(V1alpha2ClusterBuilder.class, queue)
				.withResyncPeriod(Duration.ofSeconds(1))
				.build())
			.withWorkerCount(1)
			.withReconciler(reconciler)
			.withReadyFunc(sharedIndexInformer::hasSynced)
			.withName("cluster-builder-controller")
			.build();
	}

	@Bean
	public GenericKubernetesApi<V1alpha2ClusterStore, V1alpha2ClusterStoreList> clusterStoreApi(ApiClient apiClient) {
		return new GenericKubernetesApi<>(V1alpha2ClusterStore.class, V1alpha2ClusterStoreList.class, "kpack.io",
				"v1alpha2", "clusterstores", apiClient);
	}

	@Bean(destroyMethod = "shutdown")
	public Controller clusterStoreController(SharedInformerFactory sharedInformerFactory,
			GenericKubernetesApi<V1alpha2ClusterStore, V1alpha2ClusterStoreList> api, MeterRegistry meterRegistry,
			ApplicationEventPublisher eventPublisher) {
		final SharedIndexInformer<V1alpha2ClusterStore> sharedIndexInformer = sharedInformerFactory
			.sharedIndexInformerFor(api, V1alpha2ClusterStore.class, 0);
		final KpackReconciler<V1alpha2ClusterStore, V1alpha2ClusterStoreStatus, V1alpha2ClusterStoreStatusConditions> reconciler = new KpackReconciler<>(
				V1alpha2ClusterStore.class, "kpack", sharedIndexInformer, meterRegistry,
				V1alpha2ClusterStore::getStatus, V1alpha2ClusterStoreStatus::getConditions,
				V1alpha2ClusterStoreStatusConditions::getType, V1alpha2ClusterStoreStatusConditions::getStatus,
				eventPublisher);
		return ControllerBuilder.defaultBuilder(sharedInformerFactory)
			.watch(queue -> ControllerBuilder.controllerWatchBuilder(V1alpha2ClusterStore.class, queue)
				.withResyncPeriod(Duration.ofSeconds(1))
				.build())
			.withWorkerCount(1)
			.withReconciler(reconciler)
			.withReadyFunc(sharedIndexInformer::hasSynced)
			.withName("cluster-store-controller")
			.build();
	}

	@Bean
	public GenericKubernetesApi<V1alpha2ClusterStack, V1alpha2ClusterStackList> clusterStackApi(ApiClient apiClient) {
		return new GenericKubernetesApi<>(V1alpha2ClusterStack.class, V1alpha2ClusterStackList.class, "kpack.io",
				"v1alpha2", "clusterstacks", apiClient);
	}

	@Bean(destroyMethod = "shutdown")
	public Controller clusterStackController(SharedInformerFactory sharedInformerFactory,
			GenericKubernetesApi<V1alpha2ClusterStack, V1alpha2ClusterStackList> api, MeterRegistry meterRegistry,
			ApplicationEventPublisher eventPublisher) {
		final SharedIndexInformer<V1alpha2ClusterStack> sharedIndexInformer = sharedInformerFactory
			.sharedIndexInformerFor(api, V1alpha2ClusterStack.class, 0);
		final KpackReconciler<V1alpha2ClusterStack, V1alpha2ClusterStackStatus, V1alpha2ClusterStackStatusConditions> reconciler = new KpackReconciler<>(
				V1alpha2ClusterStack.class, "kpack", sharedIndexInformer, meterRegistry,
				V1alpha2ClusterStack::getStatus, V1alpha2ClusterStackStatus::getConditions,
				V1alpha2ClusterStackStatusConditions::getType, V1alpha2ClusterStackStatusConditions::getStatus,
				eventPublisher);
		return ControllerBuilder.defaultBuilder(sharedInformerFactory)
			.watch(queue -> ControllerBuilder.controllerWatchBuilder(V1alpha2ClusterStack.class, queue)
				.withResyncPeriod(Duration.ofSeconds(1))
				.build())
			.withWorkerCount(1)
			.withReconciler(reconciler)
			.withReadyFunc(sharedIndexInformer::hasSynced)
			.withName("cluster-stack-controller")
			.build();
	}

	@Bean
	public GenericKubernetesApi<V1alpha1TanzuNetDependencyUpdater, V1alpha1TanzuNetDependencyUpdaterList> tanzuNetDependencyUpdaterApi(
			ApiClient apiClient) {
		return new GenericKubernetesApi<>(V1alpha1TanzuNetDependencyUpdater.class,
				V1alpha1TanzuNetDependencyUpdaterList.class, "buildservice.tanzu.vmware.com", "v1alpha1",
				"tanzunetdependencyupdaters", apiClient);
	}

	@Bean(destroyMethod = "shutdown")
	public Controller tanzuNetDependencyUpdaterController(SharedInformerFactory sharedInformerFactory,
			GenericKubernetesApi<V1alpha1TanzuNetDependencyUpdater, V1alpha1TanzuNetDependencyUpdaterList> api,
			MeterRegistry meterRegistry, ApplicationEventPublisher eventPublisher) {
		final SharedIndexInformer<V1alpha1TanzuNetDependencyUpdater> sharedIndexInformer = sharedInformerFactory
			.sharedIndexInformerFor(api, V1alpha1TanzuNetDependencyUpdater.class, 0);
		final KpackReconciler<V1alpha1TanzuNetDependencyUpdater, V1alpha1TanzuNetDependencyUpdaterStatus, V1alpha1TanzuNetDependencyUpdaterStatusConditions> reconciler = new KpackReconciler<>(
				V1alpha1TanzuNetDependencyUpdater.class, "buildservice", sharedIndexInformer, meterRegistry,
				V1alpha1TanzuNetDependencyUpdater::getStatus, V1alpha1TanzuNetDependencyUpdaterStatus::getConditions,
				V1alpha1TanzuNetDependencyUpdaterStatusConditions::getType,
				V1alpha1TanzuNetDependencyUpdaterStatusConditions::getStatus, eventPublisher);
		return ControllerBuilder.defaultBuilder(sharedInformerFactory)
			.watch(queue -> ControllerBuilder.controllerWatchBuilder(V1alpha1TanzuNetDependencyUpdater.class, queue)
				.withResyncPeriod(Duration.ofSeconds(1))
				.build())
			.withWorkerCount(1)
			.withReconciler(reconciler)
			.withReadyFunc(sharedIndexInformer::hasSynced)
			.withName("tanzu-net-dependency-updater-controller")
			.build();
	}

	@Bean
	public GenericKubernetesApi<V1alpha1CustomStack, V1alpha1CustomStackList> customStackApi(ApiClient apiClient) {
		return new GenericKubernetesApi<>(V1alpha1CustomStack.class, V1alpha1CustomStackList.class,
				"stacks.stacks-operator.tanzu.vmware.com", "v1alpha1", "customstacks", apiClient);
	}

	@Bean(destroyMethod = "shutdown")
	public Controller customStackController(SharedInformerFactory sharedInformerFactory,
			GenericKubernetesApi<V1alpha1CustomStack, V1alpha1CustomStackList> api, MeterRegistry meterRegistry,
			ApplicationEventPublisher eventPublisher) {
		final SharedIndexInformer<V1alpha1CustomStack> sharedIndexInformer = sharedInformerFactory
			.sharedIndexInformerFor(api, V1alpha1CustomStack.class, 0);
		final KpackReconciler<V1alpha1CustomStack, V1alpha1CustomStackStatus, V1alpha1CustomStackStatusConditions> reconciler = new KpackReconciler<>(
				V1alpha1CustomStack.class, "buildservice", sharedIndexInformer, meterRegistry,
				V1alpha1CustomStack::getStatus, V1alpha1CustomStackStatus::getConditions,
				V1alpha1CustomStackStatusConditions::getType, V1alpha1CustomStackStatusConditions::getStatus,
				eventPublisher);
		return ControllerBuilder.defaultBuilder(sharedInformerFactory)
			.watch(queue -> ControllerBuilder.controllerWatchBuilder(V1alpha1CustomStack.class, queue)
				.withResyncPeriod(Duration.ofSeconds(1))
				.build())
			.withWorkerCount(1)
			.withReconciler(reconciler)
			.withReadyFunc(sharedIndexInformer::hasSynced)
			.withName("custom-stack-controller")
			.build();
	}

	@Bean
	public ApplicationRunner runner(SharedInformerFactory sharedInformerFactory, List<Controller> controllers) {
		final ExecutorService executorService = Executors.newCachedThreadPool();
		sharedInformerFactory.startAllRegisteredInformers();
		return args -> controllers.forEach(controller -> executorService.execute(controller::run));
	}

	@Override
	public Executor getAsyncExecutor() {
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(1);
		executor.setQueueCapacity(32);
		executor.setMaxPoolSize(4);
		executor.setThreadNamePrefix("event-handler-");
		executor.initialize();
		return executor;
	}

}
