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
import com.vmware.tanzu.buildservice.models.V1alpha1TanzuNetDependencyUpdaterStatusConditions;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * V1alpha1TanzuNetDependencyUpdaterStatus
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
		date = "2023-04-03T05:10:03.423Z[Etc/UTC]")
public class V1alpha1TanzuNetDependencyUpdaterStatus {

	public static final String SERIALIZED_NAME_CONDITIONS = "conditions";

	@SerializedName(SERIALIZED_NAME_CONDITIONS)
	private List<V1alpha1TanzuNetDependencyUpdaterStatusConditions> conditions = null;

	public static final String SERIALIZED_NAME_LATEST_DESCRIPTOR_NAME = "latestDescriptorName";

	@SerializedName(SERIALIZED_NAME_LATEST_DESCRIPTOR_NAME)
	private String latestDescriptorName;

	public static final String SERIALIZED_NAME_LATEST_DESCRIPTOR_VERSION = "latestDescriptorVersion";

	@SerializedName(SERIALIZED_NAME_LATEST_DESCRIPTOR_VERSION)
	private String latestDescriptorVersion;

	public static final String SERIALIZED_NAME_LATEST_INLINE_DESCRIPTOR_DIGEST = "latestInlineDescriptorDigest";

	@SerializedName(SERIALIZED_NAME_LATEST_INLINE_DESCRIPTOR_DIGEST)
	private String latestInlineDescriptorDigest;

	public static final String SERIALIZED_NAME_OBSERVED_GENERATION = "observedGeneration";

	@SerializedName(SERIALIZED_NAME_OBSERVED_GENERATION)
	private Integer observedGeneration;

	public V1alpha1TanzuNetDependencyUpdaterStatus conditions(
			List<V1alpha1TanzuNetDependencyUpdaterStatusConditions> conditions) {

		this.conditions = conditions;
		return this;
	}

	public V1alpha1TanzuNetDependencyUpdaterStatus addConditionsItem(
			V1alpha1TanzuNetDependencyUpdaterStatusConditions conditionsItem) {
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

	public List<V1alpha1TanzuNetDependencyUpdaterStatusConditions> getConditions() {
		return conditions;
	}

	public void setConditions(List<V1alpha1TanzuNetDependencyUpdaterStatusConditions> conditions) {
		this.conditions = conditions;
	}

	public V1alpha1TanzuNetDependencyUpdaterStatus latestDescriptorName(String latestDescriptorName) {

		this.latestDescriptorName = latestDescriptorName;
		return this;
	}

	/**
	 * Get latestDescriptorName
	 * @return latestDescriptorName
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getLatestDescriptorName() {
		return latestDescriptorName;
	}

	public void setLatestDescriptorName(String latestDescriptorName) {
		this.latestDescriptorName = latestDescriptorName;
	}

	public V1alpha1TanzuNetDependencyUpdaterStatus latestDescriptorVersion(String latestDescriptorVersion) {

		this.latestDescriptorVersion = latestDescriptorVersion;
		return this;
	}

	/**
	 * Get latestDescriptorVersion
	 * @return latestDescriptorVersion
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getLatestDescriptorVersion() {
		return latestDescriptorVersion;
	}

	public void setLatestDescriptorVersion(String latestDescriptorVersion) {
		this.latestDescriptorVersion = latestDescriptorVersion;
	}

	public V1alpha1TanzuNetDependencyUpdaterStatus latestInlineDescriptorDigest(String latestInlineDescriptorDigest) {

		this.latestInlineDescriptorDigest = latestInlineDescriptorDigest;
		return this;
	}

	/**
	 * Get latestInlineDescriptorDigest
	 * @return latestInlineDescriptorDigest
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getLatestInlineDescriptorDigest() {
		return latestInlineDescriptorDigest;
	}

	public void setLatestInlineDescriptorDigest(String latestInlineDescriptorDigest) {
		this.latestInlineDescriptorDigest = latestInlineDescriptorDigest;
	}

	public V1alpha1TanzuNetDependencyUpdaterStatus observedGeneration(Integer observedGeneration) {

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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		V1alpha1TanzuNetDependencyUpdaterStatus v1alpha1TanzuNetDependencyUpdaterStatus = (V1alpha1TanzuNetDependencyUpdaterStatus) o;
		return Objects.equals(this.conditions, v1alpha1TanzuNetDependencyUpdaterStatus.conditions)
				&& Objects.equals(this.latestDescriptorName,
						v1alpha1TanzuNetDependencyUpdaterStatus.latestDescriptorName)
				&& Objects.equals(this.latestDescriptorVersion,
						v1alpha1TanzuNetDependencyUpdaterStatus.latestDescriptorVersion)
				&& Objects.equals(this.latestInlineDescriptorDigest,
						v1alpha1TanzuNetDependencyUpdaterStatus.latestInlineDescriptorDigest)
				&& Objects.equals(this.observedGeneration, v1alpha1TanzuNetDependencyUpdaterStatus.observedGeneration);
	}

	@Override
	public int hashCode() {
		return Objects.hash(conditions, latestDescriptorName, latestDescriptorVersion, latestInlineDescriptorDigest,
				observedGeneration);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class V1alpha1TanzuNetDependencyUpdaterStatus {\n");
		sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
		sb.append("    latestDescriptorName: ").append(toIndentedString(latestDescriptorName)).append("\n");
		sb.append("    latestDescriptorVersion: ").append(toIndentedString(latestDescriptorVersion)).append("\n");
		sb.append("    latestInlineDescriptorDigest: ")
			.append(toIndentedString(latestInlineDescriptorDigest))
			.append("\n");
		sb.append("    observedGeneration: ").append(toIndentedString(observedGeneration)).append("\n");
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
