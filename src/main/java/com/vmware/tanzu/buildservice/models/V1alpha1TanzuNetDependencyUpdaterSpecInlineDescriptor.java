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

package com.vmware.tanzu.buildservice.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorBuildImage;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterBuilders;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStacks;
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStores;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
		date = "2023-04-03T05:10:03.423Z[Etc/UTC]")
public class V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor {

	public static final String SERIALIZED_NAME_API_VERSION = "apiVersion";

	@SerializedName(SERIALIZED_NAME_API_VERSION)
	private String apiVersion;

	public static final String SERIALIZED_NAME_CLUSTER_BUILDERS = "clusterBuilders";

	@SerializedName(SERIALIZED_NAME_CLUSTER_BUILDERS)
	private List<V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterBuilders> clusterBuilders = null;

	public static final String SERIALIZED_NAME_CLUSTER_STACKS = "clusterStacks";

	@SerializedName(SERIALIZED_NAME_CLUSTER_STACKS)
	private List<V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStacks> clusterStacks = null;

	public static final String SERIALIZED_NAME_CLUSTER_STORES = "clusterStores";

	@SerializedName(SERIALIZED_NAME_CLUSTER_STORES)
	private List<V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStores> clusterStores = null;

	public static final String SERIALIZED_NAME_DEFAULT_CLUSTER_BUILDER = "defaultClusterBuilder";

	@SerializedName(SERIALIZED_NAME_DEFAULT_CLUSTER_BUILDER)
	private String defaultClusterBuilder;

	public static final String SERIALIZED_NAME_DEFAULT_CLUSTER_STACK = "defaultClusterStack";

	@SerializedName(SERIALIZED_NAME_DEFAULT_CLUSTER_STACK)
	private String defaultClusterStack;

	public static final String SERIALIZED_NAME_KIND = "kind";

	@SerializedName(SERIALIZED_NAME_KIND)
	private String kind;

	public static final String SERIALIZED_NAME_LIFECYCLE = "lifecycle";

	@SerializedName(SERIALIZED_NAME_LIFECYCLE)
	private V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorBuildImage lifecycle;

	public V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor apiVersion(String apiVersion) {

		this.apiVersion = apiVersion;
		return this;
	}

	/**
	 * Get apiVersion
	 * @return apiVersion
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor clusterBuilders(
			List<V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterBuilders> clusterBuilders) {

		this.clusterBuilders = clusterBuilders;
		return this;
	}

	public V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor addClusterBuildersItem(
			V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterBuilders clusterBuildersItem) {
		if (this.clusterBuilders == null) {
			this.clusterBuilders = new ArrayList<>();
		}
		this.clusterBuilders.add(clusterBuildersItem);
		return this;
	}

	/**
	 * Get clusterBuilders
	 * @return clusterBuilders
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public List<V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterBuilders> getClusterBuilders() {
		return clusterBuilders;
	}

	public void setClusterBuilders(
			List<V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterBuilders> clusterBuilders) {
		this.clusterBuilders = clusterBuilders;
	}

	public V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor clusterStacks(
			List<V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStacks> clusterStacks) {

		this.clusterStacks = clusterStacks;
		return this;
	}

	public V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor addClusterStacksItem(
			V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStacks clusterStacksItem) {
		if (this.clusterStacks == null) {
			this.clusterStacks = new ArrayList<>();
		}
		this.clusterStacks.add(clusterStacksItem);
		return this;
	}

	/**
	 * Get clusterStacks
	 * @return clusterStacks
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public List<V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStacks> getClusterStacks() {
		return clusterStacks;
	}

	public void setClusterStacks(
			List<V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStacks> clusterStacks) {
		this.clusterStacks = clusterStacks;
	}

	public V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor clusterStores(
			List<V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStores> clusterStores) {

		this.clusterStores = clusterStores;
		return this;
	}

	public V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor addClusterStoresItem(
			V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStores clusterStoresItem) {
		if (this.clusterStores == null) {
			this.clusterStores = new ArrayList<>();
		}
		this.clusterStores.add(clusterStoresItem);
		return this;
	}

	/**
	 * Get clusterStores
	 * @return clusterStores
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public List<V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStores> getClusterStores() {
		return clusterStores;
	}

	public void setClusterStores(
			List<V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorClusterStores> clusterStores) {
		this.clusterStores = clusterStores;
	}

	public V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor defaultClusterBuilder(String defaultClusterBuilder) {

		this.defaultClusterBuilder = defaultClusterBuilder;
		return this;
	}

	/**
	 * Get defaultClusterBuilder
	 * @return defaultClusterBuilder
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getDefaultClusterBuilder() {
		return defaultClusterBuilder;
	}

	public void setDefaultClusterBuilder(String defaultClusterBuilder) {
		this.defaultClusterBuilder = defaultClusterBuilder;
	}

	public V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor defaultClusterStack(String defaultClusterStack) {

		this.defaultClusterStack = defaultClusterStack;
		return this;
	}

	/**
	 * Get defaultClusterStack
	 * @return defaultClusterStack
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getDefaultClusterStack() {
		return defaultClusterStack;
	}

	public void setDefaultClusterStack(String defaultClusterStack) {
		this.defaultClusterStack = defaultClusterStack;
	}

	public V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor kind(String kind) {

		this.kind = kind;
		return this;
	}

	/**
	 * Get kind
	 * @return kind
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor lifecycle(
			V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorBuildImage lifecycle) {

		this.lifecycle = lifecycle;
		return this;
	}

	/**
	 * Get lifecycle
	 * @return lifecycle
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorBuildImage getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptorBuildImage lifecycle) {
		this.lifecycle = lifecycle;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor v1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor = (V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor) o;
		return Objects.equals(this.apiVersion, v1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor.apiVersion)
				&& Objects.equals(this.clusterBuilders,
						v1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor.clusterBuilders)
				&& Objects.equals(this.clusterStacks,
						v1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor.clusterStacks)
				&& Objects.equals(this.clusterStores,
						v1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor.clusterStores)
				&& Objects.equals(this.defaultClusterBuilder,
						v1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor.defaultClusterBuilder)
				&& Objects.equals(this.defaultClusterStack,
						v1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor.defaultClusterStack)
				&& Objects.equals(this.kind, v1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor.kind)
				&& Objects.equals(this.lifecycle, v1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor.lifecycle);
	}

	@Override
	public int hashCode() {
		return Objects.hash(apiVersion, clusterBuilders, clusterStacks, clusterStores, defaultClusterBuilder,
				defaultClusterStack, kind, lifecycle);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class V1alpha1TanzuNetDependencyUpdaterSpecInlineDescriptor {\n");
		sb.append("    apiVersion: ").append(toIndentedString(apiVersion)).append("\n");
		sb.append("    clusterBuilders: ").append(toIndentedString(clusterBuilders)).append("\n");
		sb.append("    clusterStacks: ").append(toIndentedString(clusterStacks)).append("\n");
		sb.append("    clusterStores: ").append(toIndentedString(clusterStores)).append("\n");
		sb.append("    defaultClusterBuilder: ").append(toIndentedString(defaultClusterBuilder)).append("\n");
		sb.append("    defaultClusterStack: ").append(toIndentedString(defaultClusterStack)).append("\n");
		sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
		sb.append("    lifecycle: ").append(toIndentedString(lifecycle)).append("\n");
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