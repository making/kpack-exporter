/*
 * Kubernetes
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1.21.1
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.vmware.tanzu.stacksoperator.stacks.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.vmware.tanzu.stacksoperator.stacks.models.V1alpha1CustomStackSpecSourceRegistryImages;
import com.vmware.tanzu.stacksoperator.stacks.models.V1alpha1CustomStackSpecSourceStack;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * V1alpha1CustomStackSpecSource
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
		date = "2023-05-25T02:55:10.964Z[Etc/UTC]")
public class V1alpha1CustomStackSpecSource {

	public static final String SERIALIZED_NAME_REGISTRY_IMAGES = "registryImages";

	@SerializedName(SERIALIZED_NAME_REGISTRY_IMAGES)
	private V1alpha1CustomStackSpecSourceRegistryImages registryImages;

	public static final String SERIALIZED_NAME_STACK = "stack";

	@SerializedName(SERIALIZED_NAME_STACK)
	private V1alpha1CustomStackSpecSourceStack stack;

	public V1alpha1CustomStackSpecSource registryImages(V1alpha1CustomStackSpecSourceRegistryImages registryImages) {

		this.registryImages = registryImages;
		return this;
	}

	/**
	 * Get registryImages
	 * @return registryImages
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public V1alpha1CustomStackSpecSourceRegistryImages getRegistryImages() {
		return registryImages;
	}

	public void setRegistryImages(V1alpha1CustomStackSpecSourceRegistryImages registryImages) {
		this.registryImages = registryImages;
	}

	public V1alpha1CustomStackSpecSource stack(V1alpha1CustomStackSpecSourceStack stack) {

		this.stack = stack;
		return this;
	}

	/**
	 * Get stack
	 * @return stack
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public V1alpha1CustomStackSpecSourceStack getStack() {
		return stack;
	}

	public void setStack(V1alpha1CustomStackSpecSourceStack stack) {
		this.stack = stack;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		V1alpha1CustomStackSpecSource v1alpha1CustomStackSpecSource = (V1alpha1CustomStackSpecSource) o;
		return Objects.equals(this.registryImages, v1alpha1CustomStackSpecSource.registryImages)
				&& Objects.equals(this.stack, v1alpha1CustomStackSpecSource.stack);
	}

	@Override
	public int hashCode() {
		return Objects.hash(registryImages, stack);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class V1alpha1CustomStackSpecSource {\n");
		sb.append("    registryImages: ").append(toIndentedString(registryImages)).append("\n");
		sb.append("    stack: ").append(toIndentedString(stack)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces (except the
	 * first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
