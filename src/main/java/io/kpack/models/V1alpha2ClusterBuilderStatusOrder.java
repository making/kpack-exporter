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
import io.kpack.models.V1alpha2ClusterBuilderStatusGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * V1alpha2ClusterBuilderStatusOrder
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
		date = "2023-03-27T06:34:57.887Z[Etc/UTC]")
public class V1alpha2ClusterBuilderStatusOrder {

	public static final String SERIALIZED_NAME_GROUP = "group";

	@SerializedName(SERIALIZED_NAME_GROUP)
	private List<V1alpha2ClusterBuilderStatusGroup> group = null;

	public V1alpha2ClusterBuilderStatusOrder group(List<V1alpha2ClusterBuilderStatusGroup> group) {

		this.group = group;
		return this;
	}

	public V1alpha2ClusterBuilderStatusOrder addGroupItem(V1alpha2ClusterBuilderStatusGroup groupItem) {
		if (this.group == null) {
			this.group = new ArrayList<>();
		}
		this.group.add(groupItem);
		return this;
	}

	/**
	 * Get group
	 * @return group
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public List<V1alpha2ClusterBuilderStatusGroup> getGroup() {
		return group;
	}

	public void setGroup(List<V1alpha2ClusterBuilderStatusGroup> group) {
		this.group = group;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		V1alpha2ClusterBuilderStatusOrder v1alpha2ClusterBuilderStatusOrder = (V1alpha2ClusterBuilderStatusOrder) o;
		return Objects.equals(this.group, v1alpha2ClusterBuilderStatusOrder.group);
	}

	@Override
	public int hashCode() {
		return Objects.hash(group);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class V1alpha2ClusterBuilderStatusOrder {\n");
		sb.append("    group: ").append(toIndentedString(group)).append("\n");
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
