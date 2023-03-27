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
import io.kpack.models.V1alpha2ClusterStoreSpecSources;
import io.kpack.models.V1alpha2ClusterStoreStatusBuildpackage;
import io.kpack.models.V1alpha2ClusterStoreStatusStacks;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * V1alpha2ClusterStoreStatusBuildpacks
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
		date = "2023-03-27T10:29:18.594Z[Etc/UTC]")
public class V1alpha2ClusterStoreStatusBuildpacks {

	public static final String SERIALIZED_NAME_API = "api";

	@SerializedName(SERIALIZED_NAME_API)
	private String api;

	public static final String SERIALIZED_NAME_BUILDPACKAGE = "buildpackage";

	@SerializedName(SERIALIZED_NAME_BUILDPACKAGE)
	private V1alpha2ClusterStoreStatusBuildpackage buildpackage;

	public static final String SERIALIZED_NAME_DIFF_ID = "diffId";

	@SerializedName(SERIALIZED_NAME_DIFF_ID)
	private String diffId;

	public static final String SERIALIZED_NAME_DIGEST = "digest";

	@SerializedName(SERIALIZED_NAME_DIGEST)
	private String digest;

	public static final String SERIALIZED_NAME_HOMEPAGE = "homepage";

	@SerializedName(SERIALIZED_NAME_HOMEPAGE)
	private String homepage;

	public static final String SERIALIZED_NAME_ID = "id";

	@SerializedName(SERIALIZED_NAME_ID)
	private String id;

	public static final String SERIALIZED_NAME_SIZE = "size";

	@SerializedName(SERIALIZED_NAME_SIZE)
	private Integer size;

	public static final String SERIALIZED_NAME_STACKS = "stacks";

	@SerializedName(SERIALIZED_NAME_STACKS)
	private List<V1alpha2ClusterStoreStatusStacks> stacks = null;

	public static final String SERIALIZED_NAME_STORE_IMAGE = "storeImage";

	@SerializedName(SERIALIZED_NAME_STORE_IMAGE)
	private V1alpha2ClusterStoreSpecSources storeImage;

	public static final String SERIALIZED_NAME_VERSION = "version";

	@SerializedName(SERIALIZED_NAME_VERSION)
	private String version;

	public V1alpha2ClusterStoreStatusBuildpacks api(String api) {

		this.api = api;
		return this;
	}

	/**
	 * Get api
	 * @return api
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public V1alpha2ClusterStoreStatusBuildpacks buildpackage(V1alpha2ClusterStoreStatusBuildpackage buildpackage) {

		this.buildpackage = buildpackage;
		return this;
	}

	/**
	 * Get buildpackage
	 * @return buildpackage
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public V1alpha2ClusterStoreStatusBuildpackage getBuildpackage() {
		return buildpackage;
	}

	public void setBuildpackage(V1alpha2ClusterStoreStatusBuildpackage buildpackage) {
		this.buildpackage = buildpackage;
	}

	public V1alpha2ClusterStoreStatusBuildpacks diffId(String diffId) {

		this.diffId = diffId;
		return this;
	}

	/**
	 * Get diffId
	 * @return diffId
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getDiffId() {
		return diffId;
	}

	public void setDiffId(String diffId) {
		this.diffId = diffId;
	}

	public V1alpha2ClusterStoreStatusBuildpacks digest(String digest) {

		this.digest = digest;
		return this;
	}

	/**
	 * Get digest
	 * @return digest
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public V1alpha2ClusterStoreStatusBuildpacks homepage(String homepage) {

		this.homepage = homepage;
		return this;
	}

	/**
	 * Get homepage
	 * @return homepage
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public V1alpha2ClusterStoreStatusBuildpacks id(String id) {

		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * @return id
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public V1alpha2ClusterStoreStatusBuildpacks size(Integer size) {

		this.size = size;
		return this;
	}

	/**
	 * Get size
	 * @return size
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public V1alpha2ClusterStoreStatusBuildpacks stacks(List<V1alpha2ClusterStoreStatusStacks> stacks) {

		this.stacks = stacks;
		return this;
	}

	public V1alpha2ClusterStoreStatusBuildpacks addStacksItem(V1alpha2ClusterStoreStatusStacks stacksItem) {
		if (this.stacks == null) {
			this.stacks = new ArrayList<>();
		}
		this.stacks.add(stacksItem);
		return this;
	}

	/**
	 * Get stacks
	 * @return stacks
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public List<V1alpha2ClusterStoreStatusStacks> getStacks() {
		return stacks;
	}

	public void setStacks(List<V1alpha2ClusterStoreStatusStacks> stacks) {
		this.stacks = stacks;
	}

	public V1alpha2ClusterStoreStatusBuildpacks storeImage(V1alpha2ClusterStoreSpecSources storeImage) {

		this.storeImage = storeImage;
		return this;
	}

	/**
	 * Get storeImage
	 * @return storeImage
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public V1alpha2ClusterStoreSpecSources getStoreImage() {
		return storeImage;
	}

	public void setStoreImage(V1alpha2ClusterStoreSpecSources storeImage) {
		this.storeImage = storeImage;
	}

	public V1alpha2ClusterStoreStatusBuildpacks version(String version) {

		this.version = version;
		return this;
	}

	/**
	 * Get version
	 * @return version
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		V1alpha2ClusterStoreStatusBuildpacks v1alpha2ClusterStoreStatusBuildpacks = (V1alpha2ClusterStoreStatusBuildpacks) o;
		return Objects.equals(this.api, v1alpha2ClusterStoreStatusBuildpacks.api)
				&& Objects.equals(this.buildpackage, v1alpha2ClusterStoreStatusBuildpacks.buildpackage)
				&& Objects.equals(this.diffId, v1alpha2ClusterStoreStatusBuildpacks.diffId)
				&& Objects.equals(this.digest, v1alpha2ClusterStoreStatusBuildpacks.digest)
				&& Objects.equals(this.homepage, v1alpha2ClusterStoreStatusBuildpacks.homepage)
				&& Objects.equals(this.id, v1alpha2ClusterStoreStatusBuildpacks.id)
				&& Objects.equals(this.size, v1alpha2ClusterStoreStatusBuildpacks.size)
				&& Objects.equals(this.stacks, v1alpha2ClusterStoreStatusBuildpacks.stacks)
				&& Objects.equals(this.storeImage, v1alpha2ClusterStoreStatusBuildpacks.storeImage)
				&& Objects.equals(this.version, v1alpha2ClusterStoreStatusBuildpacks.version);
	}

	@Override
	public int hashCode() {
		return Objects.hash(api, buildpackage, diffId, digest, homepage, id, size, stacks, storeImage, version);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class V1alpha2ClusterStoreStatusBuildpacks {\n");
		sb.append("    api: ").append(toIndentedString(api)).append("\n");
		sb.append("    buildpackage: ").append(toIndentedString(buildpackage)).append("\n");
		sb.append("    diffId: ").append(toIndentedString(diffId)).append("\n");
		sb.append("    digest: ").append(toIndentedString(digest)).append("\n");
		sb.append("    homepage: ").append(toIndentedString(homepage)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    size: ").append(toIndentedString(size)).append("\n");
		sb.append("    stacks: ").append(toIndentedString(stacks)).append("\n");
		sb.append("    storeImage: ").append(toIndentedString(storeImage)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
