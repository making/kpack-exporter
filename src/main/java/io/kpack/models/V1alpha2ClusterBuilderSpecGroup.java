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
 * V1alpha2ClusterBuilderSpecGroup
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
		date = "2023-03-27T06:34:57.887Z[Etc/UTC]")
public class V1alpha2ClusterBuilderSpecGroup {

	public static final String SERIALIZED_NAME_ID = "id";

	@SerializedName(SERIALIZED_NAME_ID)
	private String id;

	public V1alpha2ClusterBuilderSpecGroup id(String id) {

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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		V1alpha2ClusterBuilderSpecGroup v1alpha2ClusterBuilderSpecGroup = (V1alpha2ClusterBuilderSpecGroup) o;
		return Objects.equals(this.id, v1alpha2ClusterBuilderSpecGroup.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class V1alpha2ClusterBuilderSpecGroup {\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
