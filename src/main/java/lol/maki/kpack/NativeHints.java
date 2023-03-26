package lol.maki.kpack;

import io.kpack.models.V1alpha2Image;
import io.kpack.models.V1alpha2ImageList;
import io.kpack.models.V1alpha2ImageSpec;
import io.kpack.models.V1alpha2ImageSpecBuild;
import io.kpack.models.V1alpha2ImageSpecBuildEnv;
import io.kpack.models.V1alpha2ImageSpecBuildServices;
import io.kpack.models.V1alpha2ImageSpecCache;
import io.kpack.models.V1alpha2ImageSpecCacheVolume;
import io.kpack.models.V1alpha2ImageSpecSource;
import io.kpack.models.V1alpha2ImageSpecSourceBlob;
import io.kpack.models.V1alpha2ImageSpecSourceGit;
import io.kpack.models.V1alpha2ImageSpecSourceRegistry;
import io.kpack.models.V1alpha2ImageSpecSourceRegistryImagePullSecrets;
import io.kpack.models.V1alpha2ImageStatus;
import io.kpack.models.V1alpha2ImageStatusConditions;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@ImportRuntimeHints(NativeHints.class)
@Configuration
@RegisterReflectionForBinding({ V1alpha2Image.class, V1alpha2ImageList.class, V1alpha2ImageSpec.class,
		V1alpha2ImageSpecBuild.class, V1alpha2ImageSpecBuildEnv.class, V1alpha2ImageSpecBuildServices.class,
		V1alpha2ImageSpecCache.class, V1alpha2ImageSpecCacheVolume.class, V1alpha2ImageSpecSource.class,
		V1alpha2ImageSpecSourceBlob.class, V1alpha2ImageSpecSourceGit.class, V1alpha2ImageSpecSourceRegistry.class,
		V1alpha2ImageSpecSourceRegistryImagePullSecrets.class, V1alpha2ImageStatus.class,
		V1alpha2ImageStatusConditions.class })
public class NativeHints implements RuntimeHintsRegistrar {

	@Override
	public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
	}

}
