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

package io.kpack.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.kpack.models.V1alpha2BuilderStatusBuilderMetadata;
import io.kpack.models.V1alpha2BuilderStatusConditions;
import io.kpack.models.V1alpha2BuilderStatusOrder;
import io.kpack.models.V1alpha2BuilderStatusStack;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * V1alpha2BuilderStatus
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
		date = "2023-03-27T10:54:11.377Z[Etc/UTC]")
public class V1alpha2BuilderStatus {

	public static final String SERIALIZED_NAME_BUILDER_METADATA = "builderMetadata";

	@SerializedName(SERIALIZED_NAME_BUILDER_METADATA)
	private List<V1alpha2BuilderStatusBuilderMetadata> builderMetadata = null;

	public static final String SERIALIZED_NAME_CONDITIONS = "conditions";

	@SerializedName(SERIALIZED_NAME_CONDITIONS)
	private List<V1alpha2BuilderStatusConditions> conditions = null;

	public static final String SERIALIZED_NAME_LATEST_IMAGE = "latestImage";

	@SerializedName(SERIALIZED_NAME_LATEST_IMAGE)
	private String latestImage;

	public static final String SERIALIZED_NAME_OBSERVED_GENERATION = "observedGeneration";

	@SerializedName(SERIALIZED_NAME_OBSERVED_GENERATION)
	private Integer observedGeneration;

	public static final String SERIALIZED_NAME_OBSERVED_STACK_GENERATION = "observedStackGeneration";

	@SerializedName(SERIALIZED_NAME_OBSERVED_STACK_GENERATION)
	private Integer observedStackGeneration;

	public static final String SERIALIZED_NAME_OBSERVED_STORE_GENERATION = "observedStoreGeneration";

	@SerializedName(SERIALIZED_NAME_OBSERVED_STORE_GENERATION)
	private Integer observedStoreGeneration;

	public static final String SERIALIZED_NAME_ORDER = "order";

	@SerializedName(SERIALIZED_NAME_ORDER)
	private List<V1alpha2BuilderStatusOrder> order = null;

	public static final String SERIALIZED_NAME_OS = "os";

	@SerializedName(SERIALIZED_NAME_OS)
	private String os;

	public static final String SERIALIZED_NAME_STACK = "stack";

	@SerializedName(SERIALIZED_NAME_STACK)
	private V1alpha2BuilderStatusStack stack;

	public V1alpha2BuilderStatus builderMetadata(List<V1alpha2BuilderStatusBuilderMetadata> builderMetadata) {

		this.builderMetadata = builderMetadata;
		return this;
	}

	public V1alpha2BuilderStatus addBuilderMetadataItem(V1alpha2BuilderStatusBuilderMetadata builderMetadataItem) {
		if (this.builderMetadata == null) {
			this.builderMetadata = new ArrayList<>();
		}
		this.builderMetadata.add(builderMetadataItem);
		return this;
	}

	/**
	 * Get builderMetadata
	 * @return builderMetadata
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public List<V1alpha2BuilderStatusBuilderMetadata> getBuilderMetadata() {
		return builderMetadata;
	}

	public void setBuilderMetadata(List<V1alpha2BuilderStatusBuilderMetadata> builderMetadata) {
		this.builderMetadata = builderMetadata;
	}

	public V1alpha2BuilderStatus conditions(List<V1alpha2BuilderStatusConditions> conditions) {

		this.conditions = conditions;
		return this;
	}

	public V1alpha2BuilderStatus addConditionsItem(V1alpha2BuilderStatusConditions conditionsItem) {
		if (this.conditions == null) {
			this.conditions = new ArrayList<>();
		}
		this.conditions.add(conditionsItem);
		return this;
	}

	/**
	 * Get conditions
	 * @return conditions
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public List<V1alpha2BuilderStatusConditions> getConditions() {
		return conditions;
	}

	public void setConditions(List<V1alpha2BuilderStatusConditions> conditions) {
		this.conditions = conditions;
	}

	public V1alpha2BuilderStatus latestImage(String latestImage) {

		this.latestImage = latestImage;
		return this;
	}

	/**
	 * Get latestImage
	 * @return latestImage
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getLatestImage() {
		return latestImage;
	}

	public void setLatestImage(String latestImage) {
		this.latestImage = latestImage;
	}

	public V1alpha2BuilderStatus observedGeneration(Integer observedGeneration) {

		this.observedGeneration = observedGeneration;
		return this;
	}

	/**
	 * Get observedGeneration
	 * @return observedGeneration
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public Integer getObservedGeneration() {
		return observedGeneration;
	}

	public void setObservedGeneration(Integer observedGeneration) {
		this.observedGeneration = observedGeneration;
	}

	public V1alpha2BuilderStatus observedStackGeneration(Integer observedStackGeneration) {

		this.observedStackGeneration = observedStackGeneration;
		return this;
	}

	/**
	 * Get observedStackGeneration
	 * @return observedStackGeneration
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public Integer getObservedStackGeneration() {
		return observedStackGeneration;
	}

	public void setObservedStackGeneration(Integer observedStackGeneration) {
		this.observedStackGeneration = observedStackGeneration;
	}

	public V1alpha2BuilderStatus observedStoreGeneration(Integer observedStoreGeneration) {

		this.observedStoreGeneration = observedStoreGeneration;
		return this;
	}

	/**
	 * Get observedStoreGeneration
	 * @return observedStoreGeneration
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public Integer getObservedStoreGeneration() {
		return observedStoreGeneration;
	}

	public void setObservedStoreGeneration(Integer observedStoreGeneration) {
		this.observedStoreGeneration = observedStoreGeneration;
	}

	public V1alpha2BuilderStatus order(List<V1alpha2BuilderStatusOrder> order) {

		this.order = order;
		return this;
	}

	public V1alpha2BuilderStatus addOrderItem(V1alpha2BuilderStatusOrder orderItem) {
		if (this.order == null) {
			this.order = new ArrayList<>();
		}
		this.order.add(orderItem);
		return this;
	}

	/**
	 * Get order
	 * @return order
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public List<V1alpha2BuilderStatusOrder> getOrder() {
		return order;
	}

	public void setOrder(List<V1alpha2BuilderStatusOrder> order) {
		this.order = order;
	}

	public V1alpha2BuilderStatus os(String os) {

		this.os = os;
		return this;
	}

	/**
	 * Get os
	 * @return os
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public V1alpha2BuilderStatus stack(V1alpha2BuilderStatusStack stack) {

		this.stack = stack;
		return this;
	}

	/**
	 * Get stack
	 * @return stack
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public V1alpha2BuilderStatusStack getStack() {
		return stack;
	}

	public void setStack(V1alpha2BuilderStatusStack stack) {
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
		V1alpha2BuilderStatus v1alpha2BuilderStatus = (V1alpha2BuilderStatus) o;
		return Objects.equals(this.builderMetadata, v1alpha2BuilderStatus.builderMetadata)
				&& Objects.equals(this.conditions, v1alpha2BuilderStatus.conditions)
				&& Objects.equals(this.latestImage, v1alpha2BuilderStatus.latestImage)
				&& Objects.equals(this.observedGeneration, v1alpha2BuilderStatus.observedGeneration)
				&& Objects.equals(this.observedStackGeneration, v1alpha2BuilderStatus.observedStackGeneration)
				&& Objects.equals(this.observedStoreGeneration, v1alpha2BuilderStatus.observedStoreGeneration)
				&& Objects.equals(this.order, v1alpha2BuilderStatus.order)
				&& Objects.equals(this.os, v1alpha2BuilderStatus.os)
				&& Objects.equals(this.stack, v1alpha2BuilderStatus.stack);
	}

	@Override
	public int hashCode() {
		return Objects.hash(builderMetadata, conditions, latestImage, observedGeneration, observedStackGeneration,
				observedStoreGeneration, order, os, stack);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class V1alpha2BuilderStatus {\n");
		sb.append("    builderMetadata: ").append(toIndentedString(builderMetadata)).append("\n");
		sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
		sb.append("    latestImage: ").append(toIndentedString(latestImage)).append("\n");
		sb.append("    observedGeneration: ").append(toIndentedString(observedGeneration)).append("\n");
		sb.append("    observedStackGeneration: ").append(toIndentedString(observedStackGeneration)).append("\n");
		sb.append("    observedStoreGeneration: ").append(toIndentedString(observedStoreGeneration)).append("\n");
		sb.append("    order: ").append(toIndentedString(order)).append("\n");
		sb.append("    os: ").append(toIndentedString(os)).append("\n");
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
