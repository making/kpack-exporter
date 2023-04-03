package lol.maki.kpack;

import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdater;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterList;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterSpec;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorBuildImage;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterBuilders;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStacks;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStores;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorGroup;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorOrder;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterStatus;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterStatusConditions;
import io.kpack.models.*;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@ImportRuntimeHints(NativeHints.class)
@Configuration(proxyBeanMethods = false)
@RegisterReflectionForBinding({ V1alpha2Image.class, V1alpha2ImageList.class, V1alpha2ImageSpec.class,
		V1alpha2ImageSpecBuild.class, V1alpha2ImageSpecBuildEnv.class, V1alpha2ImageSpecBuildServices.class,
		V1alpha2ImageSpecCache.class, V1alpha2ImageSpecCacheVolume.class, V1alpha2ImageSpecSource.class,
		V1alpha2ImageSpecSourceBlob.class, V1alpha2ImageSpecSourceGit.class, V1alpha2ImageSpecSourceRegistry.class,
		V1alpha2ImageSpecSourceRegistryImagePullSecrets.class, V1alpha2ImageStatus.class,
		V1alpha2ImageStatusConditions.class, //
		V1alpha2Builder.class, V1alpha2BuilderList.class, V1alpha2BuilderSpec.class, V1alpha2BuilderSpecGroup.class,
		V1alpha2BuilderSpecOrder.class, V1alpha2BuilderSpecStack.class, V1alpha2BuilderStatus.class,
		V1alpha2BuilderStatusBuilderMetadata.class, V1alpha2BuilderStatusConditions.class,
		V1alpha2BuilderStatusGroup.class, V1alpha2BuilderStatusOrder.class, V1alpha2BuilderStatusStack.class, //
		V1alpha2ClusterBuilder.class, V1alpha2ClusterBuilderList.class, V1alpha2ClusterBuilderSpec.class,
		V1alpha2ClusterBuilderSpecGroup.class, V1alpha2ClusterBuilderSpecOrder.class,
		V1alpha2ClusterBuilderSpecServiceAccountRef.class, V1alpha2ClusterBuilderSpecStack.class,
		V1alpha2ClusterBuilderStatus.class, V1alpha2ClusterBuilderStatusBuilderMetadata.class,
		V1alpha2ClusterBuilderStatusConditions.class, V1alpha2ClusterBuilderStatusGroup.class,
		V1alpha2ClusterBuilderStatusOrder.class, V1alpha2ClusterBuilderStatusStack.class, //
		V1alpha2ClusterStore.class, V1alpha2ClusterStoreList.class, V1alpha2ClusterStoreSpec.class,
		V1alpha2ClusterStoreSpecServiceAccountRef.class, V1alpha2ClusterStoreSpecSources.class,
		V1alpha2ClusterStoreStatus.class, V1alpha2ClusterStoreStatusBuildpackage.class,
		V1alpha2ClusterStoreStatusBuildpacks.class, V1alpha2ClusterStoreStatusConditions.class,
		V1alpha2ClusterStoreStatusStacks.class, //
		V1alpha2ClusterStack.class, V1alpha2ClusterStackList.class, V1alpha2ClusterStackSpec.class,
		V1alpha2ClusterStackSpecBuildImage.class, V1alpha2ClusterStackSpecServiceAccountRef.class,
		V1alpha2ClusterStackStatus.class, V1alpha2ClusterStackStatusBuildImage.class,
		V1alpha2ClusterStackStatusConditions.class, //
		V1alpha1TanzuNetDependencyUpdater.class, V1alpha1TanzuNetDependencyUpdaterList.class,
		V1alpha1TanzuNetDependencyUpdaterSpec.class, V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor.class,
		V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorBuildImage.class,
		V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterBuilders.class,
		V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStacks.class,
		V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStores.class,
		V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorGroup.class,
		V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorOrder.class, V1alpha1TanzuNetDependencyUpdaterStatus.class,
		V1alpha1TanzuNetDependencyUpdaterStatusConditions.class, //
})
public class NativeHints implements RuntimeHintsRegistrar {

	@Override
	public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
	}

}
