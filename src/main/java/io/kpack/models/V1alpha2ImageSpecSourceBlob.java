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
import java.math.BigDecimal;

/**
 * V1alpha2ImageSpecSourceBlob
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
		date = "2023-03-27T06:32:24.214Z[Etc/UTC]")
public class V1alpha2ImageSpecSourceBlob {

	public static final String SERIALIZED_NAME_STRIP_COMPONENTS = "stripComponents";

	@SerializedName(SERIALIZED_NAME_STRIP_COMPONENTS)
	private BigDecimal stripComponents;

	public static final String SERIALIZED_NAME_URL = "url";

	@SerializedName(SERIALIZED_NAME_URL)
	private String url;

	public V1alpha2ImageSpecSourceBlob stripComponents(BigDecimal stripComponents) {

		this.stripComponents = stripComponents;
		return this;
	}

	/**
	 * Get stripComponents
	 * @return stripComponents
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public BigDecimal getStripComponents() {
		return stripComponents;
	}

	public void setStripComponents(BigDecimal stripComponents) {
		this.stripComponents = stripComponents;
	}

	public V1alpha2ImageSpecSourceBlob url(String url) {

		this.url = url;
		return this;
	}

	/**
	 * Get url
	 * @return url
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		V1alpha2ImageSpecSourceBlob v1alpha2ImageSpecSourceBlob = (V1alpha2ImageSpecSourceBlob) o;
		return Objects.equals(this.stripComponents, v1alpha2ImageSpecSourceBlob.stripComponents)
				&& Objects.equals(this.url, v1alpha2ImageSpecSourceBlob.url);
	}

	@Override
	public int hashCode() {
		return Objects.hash(stripComponents, url);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class V1alpha2ImageSpecSourceBlob {\n");
		sb.append("    stripComponents: ").append(toIndentedString(stripComponents)).append("\n");
		sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
