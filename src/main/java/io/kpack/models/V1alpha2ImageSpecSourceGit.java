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
 * V1alpha2ImageSpecSourceGit
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
		date = "2023-03-26T09:34:39.833Z[Etc/UTC]")
public class V1alpha2ImageSpecSourceGit {

	public static final String SERIALIZED_NAME_REVISION = "revision";

	@SerializedName(SERIALIZED_NAME_REVISION)
	private String revision;

	public static final String SERIALIZED_NAME_URL = "url";

	@SerializedName(SERIALIZED_NAME_URL)
	private String url;

	public V1alpha2ImageSpecSourceGit revision(String revision) {

		this.revision = revision;
		return this;
	}

	/**
	 * Get revision
	 * @return revision
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public V1alpha2ImageSpecSourceGit url(String url) {

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
		V1alpha2ImageSpecSourceGit v1alpha2ImageSpecSourceGit = (V1alpha2ImageSpecSourceGit) o;
		return Objects.equals(this.revision, v1alpha2ImageSpecSourceGit.revision)
				&& Objects.equals(this.url, v1alpha2ImageSpecSourceGit.url);
	}

	@Override
	public int hashCode() {
		return Objects.hash(revision, url);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class V1alpha2ImageSpecSourceGit {\n");
		sb.append("    revision: ").append(toIndentedString(revision)).append("\n");
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