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
 * V1alpha2ClusterStackSpecServiceAccountRef
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
		date = "2023-03-27T10:41:15.597Z[Etc/UTC]")
public class V1alpha2ClusterStackSpecServiceAccountRef {

	public static final String SERIALIZED_NAME_NAME = "name";

	@SerializedName(SERIALIZED_NAME_NAME)
	private String name;

	public static final String SERIALIZED_NAME_NAMESPACE = "namespace";

	@SerializedName(SERIALIZED_NAME_NAMESPACE)
	private String namespace;

	public V1alpha2ClusterStackSpecServiceAccountRef name(String name) {

		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * @return name
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public V1alpha2ClusterStackSpecServiceAccountRef namespace(String namespace) {

		this.namespace = namespace;
		return this;
	}

	/**
	 * Get namespace
	 * @return namespace
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		V1alpha2ClusterStackSpecServiceAccountRef v1alpha2ClusterStackSpecServiceAccountRef = (V1alpha2ClusterStackSpecServiceAccountRef) o;
		return Objects.equals(this.name, v1alpha2ClusterStackSpecServiceAccountRef.name)
				&& Objects.equals(this.namespace, v1alpha2ClusterStackSpecServiceAccountRef.namespace);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, namespace);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class V1alpha2ClusterStackSpecServiceAccountRef {\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
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
