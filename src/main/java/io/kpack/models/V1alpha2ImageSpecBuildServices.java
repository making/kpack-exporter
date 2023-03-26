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

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

/**
 * V1alpha2ImageSpecBuildServices
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
		date = "2023-03-26T09:34:39.833Z[Etc/UTC]")
public class V1alpha2ImageSpecBuildServices {

	public static final String SERIALIZED_NAME_KIND = "kind";

	@SerializedName(SERIALIZED_NAME_KIND)
	private String kind;

	public static final String SERIALIZED_NAME_NAME = "name";

	@SerializedName(SERIALIZED_NAME_NAME)
	private String name;

	public V1alpha2ImageSpecBuildServices kind(String kind) {

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

	public V1alpha2ImageSpecBuildServices name(String name) {

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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		V1alpha2ImageSpecBuildServices v1alpha2ImageSpecBuildServices = (V1alpha2ImageSpecBuildServices) o;
		return Objects.equals(this.kind, v1alpha2ImageSpecBuildServices.kind)
				&& Objects.equals(this.name, v1alpha2ImageSpecBuildServices.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(kind, name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class V1alpha2ImageSpecBuildServices {\n");
		sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
