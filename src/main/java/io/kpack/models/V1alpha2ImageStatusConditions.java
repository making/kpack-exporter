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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * V1alpha2ImageStatusConditions
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
		date = "2023-03-27T06:32:24.214Z[Etc/UTC]")
public class V1alpha2ImageStatusConditions {

	public static final String SERIALIZED_NAME_LAST_TRANSITION_TIME = "lastTransitionTime";

	@SerializedName(SERIALIZED_NAME_LAST_TRANSITION_TIME)
	private String lastTransitionTime;

	public static final String SERIALIZED_NAME_STATUS = "status";

	@SerializedName(SERIALIZED_NAME_STATUS)
	private String status;

	public static final String SERIALIZED_NAME_TYPE = "type";

	@SerializedName(SERIALIZED_NAME_TYPE)
	private String type;

	public V1alpha2ImageStatusConditions lastTransitionTime(String lastTransitionTime) {

		this.lastTransitionTime = lastTransitionTime;
		return this;
	}

	/**
	 * Get lastTransitionTime
	 * @return lastTransitionTime
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getLastTransitionTime() {
		return lastTransitionTime;
	}

	public void setLastTransitionTime(String lastTransitionTime) {
		this.lastTransitionTime = lastTransitionTime;
	}

	public V1alpha2ImageStatusConditions status(String status) {

		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * @return status
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public V1alpha2ImageStatusConditions type(String type) {

		this.type = type;
		return this;
	}

	/**
	 * Get type
	 * @return type
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		V1alpha2ImageStatusConditions v1alpha2ImageStatusConditions = (V1alpha2ImageStatusConditions) o;
		return Objects.equals(this.lastTransitionTime, v1alpha2ImageStatusConditions.lastTransitionTime)
				&& Objects.equals(this.status, v1alpha2ImageStatusConditions.status)
				&& Objects.equals(this.type, v1alpha2ImageStatusConditions.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lastTransitionTime, status, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class V1alpha2ImageStatusConditions {\n");
		sb.append("    lastTransitionTime: ").append(toIndentedString(lastTransitionTime)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
