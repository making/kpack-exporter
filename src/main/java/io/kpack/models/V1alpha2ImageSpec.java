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
import io.kpack.models.V1alpha2ImageSpecBuild;
import io.kpack.models.V1alpha2ImageSpecBuildServices;
import io.kpack.models.V1alpha2ImageSpecCache;
import io.kpack.models.V1alpha2ImageSpecSource;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * V1alpha2ImageSpec
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
		date = "2023-03-27T06:32:24.214Z[Etc/UTC]")
public class V1alpha2ImageSpec {

	public static final String SERIALIZED_NAME_ADDITIONAL_TAGS = "additionalTags";

	@SerializedName(SERIALIZED_NAME_ADDITIONAL_TAGS)
	private List<String> additionalTags = null;

	public static final String SERIALIZED_NAME_BUILD = "build";

	@SerializedName(SERIALIZED_NAME_BUILD)
	private V1alpha2ImageSpecBuild build;

	public static final String SERIALIZED_NAME_BUILDER = "builder";

	@SerializedName(SERIALIZED_NAME_BUILDER)
	private V1alpha2ImageSpecBuildServices builder;

	public static final String SERIALIZED_NAME_CACHE = "cache";

	@SerializedName(SERIALIZED_NAME_CACHE)
	private V1alpha2ImageSpecCache cache;

	public static final String SERIALIZED_NAME_FAILED_BUILD_HISTORY_LIMIT = "failedBuildHistoryLimit";

	@SerializedName(SERIALIZED_NAME_FAILED_BUILD_HISTORY_LIMIT)
	private Integer failedBuildHistoryLimit;

	public static final String SERIALIZED_NAME_IMAGE_TAGGING_STRATEGY = "imageTaggingStrategy";

	@SerializedName(SERIALIZED_NAME_IMAGE_TAGGING_STRATEGY)
	private String imageTaggingStrategy;

	public static final String SERIALIZED_NAME_SERVICE_ACCOUNT_NAME = "serviceAccountName";

	@SerializedName(SERIALIZED_NAME_SERVICE_ACCOUNT_NAME)
	private String serviceAccountName;

	public static final String SERIALIZED_NAME_SOURCE = "source";

	@SerializedName(SERIALIZED_NAME_SOURCE)
	private V1alpha2ImageSpecSource source;

	public static final String SERIALIZED_NAME_SUCCESS_BUILD_HISTORY_LIMIT = "successBuildHistoryLimit";

	@SerializedName(SERIALIZED_NAME_SUCCESS_BUILD_HISTORY_LIMIT)
	private Integer successBuildHistoryLimit;

	public static final String SERIALIZED_NAME_TAG = "tag";

	@SerializedName(SERIALIZED_NAME_TAG)
	private String tag;

	public V1alpha2ImageSpec additionalTags(List<String> additionalTags) {

		this.additionalTags = additionalTags;
		return this;
	}

	public V1alpha2ImageSpec addAdditionalTagsItem(String additionalTagsItem) {
		if (this.additionalTags == null) {
			this.additionalTags = new ArrayList<>();
		}
		this.additionalTags.add(additionalTagsItem);
		return this;
	}

	/**
	 * Get additionalTags
	 * @return additionalTags
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public List<String> getAdditionalTags() {
		return additionalTags;
	}

	public void setAdditionalTags(List<String> additionalTags) {
		this.additionalTags = additionalTags;
	}

	public V1alpha2ImageSpec build(V1alpha2ImageSpecBuild build) {

		this.build = build;
		return this;
	}

	/**
	 * Get build
	 * @return build
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public V1alpha2ImageSpecBuild getBuild() {
		return build;
	}

	public void setBuild(V1alpha2ImageSpecBuild build) {
		this.build = build;
	}

	public V1alpha2ImageSpec builder(V1alpha2ImageSpecBuildServices builder) {

		this.builder = builder;
		return this;
	}

	/**
	 * Get builder
	 * @return builder
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public V1alpha2ImageSpecBuildServices getBuilder() {
		return builder;
	}

	public void setBuilder(V1alpha2ImageSpecBuildServices builder) {
		this.builder = builder;
	}

	public V1alpha2ImageSpec cache(V1alpha2ImageSpecCache cache) {

		this.cache = cache;
		return this;
	}

	/**
	 * Get cache
	 * @return cache
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public V1alpha2ImageSpecCache getCache() {
		return cache;
	}

	public void setCache(V1alpha2ImageSpecCache cache) {
		this.cache = cache;
	}

	public V1alpha2ImageSpec failedBuildHistoryLimit(Integer failedBuildHistoryLimit) {

		this.failedBuildHistoryLimit = failedBuildHistoryLimit;
		return this;
	}

	/**
	 * Get failedBuildHistoryLimit
	 * @return failedBuildHistoryLimit
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public Integer getFailedBuildHistoryLimit() {
		return failedBuildHistoryLimit;
	}

	public void setFailedBuildHistoryLimit(Integer failedBuildHistoryLimit) {
		this.failedBuildHistoryLimit = failedBuildHistoryLimit;
	}

	public V1alpha2ImageSpec imageTaggingStrategy(String imageTaggingStrategy) {

		this.imageTaggingStrategy = imageTaggingStrategy;
		return this;
	}

	/**
	 * Get imageTaggingStrategy
	 * @return imageTaggingStrategy
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getImageTaggingStrategy() {
		return imageTaggingStrategy;
	}

	public void setImageTaggingStrategy(String imageTaggingStrategy) {
		this.imageTaggingStrategy = imageTaggingStrategy;
	}

	public V1alpha2ImageSpec serviceAccountName(String serviceAccountName) {

		this.serviceAccountName = serviceAccountName;
		return this;
	}

	/**
	 * Get serviceAccountName
	 * @return serviceAccountName
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getServiceAccountName() {
		return serviceAccountName;
	}

	public void setServiceAccountName(String serviceAccountName) {
		this.serviceAccountName = serviceAccountName;
	}

	public V1alpha2ImageSpec source(V1alpha2ImageSpecSource source) {

		this.source = source;
		return this;
	}

	/**
	 * Get source
	 * @return source
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public V1alpha2ImageSpecSource getSource() {
		return source;
	}

	public void setSource(V1alpha2ImageSpecSource source) {
		this.source = source;
	}

	public V1alpha2ImageSpec successBuildHistoryLimit(Integer successBuildHistoryLimit) {

		this.successBuildHistoryLimit = successBuildHistoryLimit;
		return this;
	}

	/**
	 * Get successBuildHistoryLimit
	 * @return successBuildHistoryLimit
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public Integer getSuccessBuildHistoryLimit() {
		return successBuildHistoryLimit;
	}

	public void setSuccessBuildHistoryLimit(Integer successBuildHistoryLimit) {
		this.successBuildHistoryLimit = successBuildHistoryLimit;
	}

	public V1alpha2ImageSpec tag(String tag) {

		this.tag = tag;
		return this;
	}

	/**
	 * Get tag
	 * @return tag
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		V1alpha2ImageSpec v1alpha2ImageSpec = (V1alpha2ImageSpec) o;
		return Objects.equals(this.additionalTags, v1alpha2ImageSpec.additionalTags)
				&& Objects.equals(this.build, v1alpha2ImageSpec.build)
				&& Objects.equals(this.builder, v1alpha2ImageSpec.builder)
				&& Objects.equals(this.cache, v1alpha2ImageSpec.cache)
				&& Objects.equals(this.failedBuildHistoryLimit, v1alpha2ImageSpec.failedBuildHistoryLimit)
				&& Objects.equals(this.imageTaggingStrategy, v1alpha2ImageSpec.imageTaggingStrategy)
				&& Objects.equals(this.serviceAccountName, v1alpha2ImageSpec.serviceAccountName)
				&& Objects.equals(this.source, v1alpha2ImageSpec.source)
				&& Objects.equals(this.successBuildHistoryLimit, v1alpha2ImageSpec.successBuildHistoryLimit)
				&& Objects.equals(this.tag, v1alpha2ImageSpec.tag);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalTags, build, builder, cache, failedBuildHistoryLimit, imageTaggingStrategy,
				serviceAccountName, source, successBuildHistoryLimit, tag);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class V1alpha2ImageSpec {\n");
		sb.append("    additionalTags: ").append(toIndentedString(additionalTags)).append("\n");
		sb.append("    build: ").append(toIndentedString(build)).append("\n");
		sb.append("    builder: ").append(toIndentedString(builder)).append("\n");
		sb.append("    cache: ").append(toIndentedString(cache)).append("\n");
		sb.append("    failedBuildHistoryLimit: ").append(toIndentedString(failedBuildHistoryLimit)).append("\n");
		sb.append("    imageTaggingStrategy: ").append(toIndentedString(imageTaggingStrategy)).append("\n");
		sb.append("    serviceAccountName: ").append(toIndentedString(serviceAccountName)).append("\n");
		sb.append("    source: ").append(toIndentedString(source)).append("\n");
		sb.append("    successBuildHistoryLimit: ").append(toIndentedString(successBuildHistoryLimit)).append("\n");
		sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
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
