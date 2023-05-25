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

package com.vmware.tanzu.stacksoperator.stacks.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.vmware.tanzu.stacksoperator.stacks.models.V1alpha1CustomStackSpecSourceRegistryImagesBuild;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * V1alpha1CustomStackSpecSourceRegistryImages
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
		date = "2023-05-25T02:55:10.964Z[Etc/UTC]")
public class V1alpha1CustomStackSpecSourceRegistryImages {

	public static final String SERIALIZED_NAME_BUILD = "build";

	@SerializedName(SERIALIZED_NAME_BUILD)
	private V1alpha1CustomStackSpecSourceRegistryImagesBuild build;

	public static final String SERIALIZED_NAME_RUN = "run";

	@SerializedName(SERIALIZED_NAME_RUN)
	private V1alpha1CustomStackSpecSourceRegistryImagesBuild run;

	public V1alpha1CustomStackSpecSourceRegistryImages build(V1alpha1CustomStackSpecSourceRegistryImagesBuild build) {

		this.build = build;
		return this;
	}

	/**
	 * Get build
	 * @return build
	 **/
	@ApiModelProperty(required = true, value = "")

	public V1alpha1CustomStackSpecSourceRegistryImagesBuild getBuild() {
		return build;
	}

	public void setBuild(V1alpha1CustomStackSpecSourceRegistryImagesBuild build) {
		this.build = build;
	}

	public V1alpha1CustomStackSpecSourceRegistryImages run(V1alpha1CustomStackSpecSourceRegistryImagesBuild run) {

		this.run = run;
		return this;
	}

	/**
	 * Get run
	 * @return run
	 **/
	@ApiModelProperty(required = true, value = "")

	public V1alpha1CustomStackSpecSourceRegistryImagesBuild getRun() {
		return run;
	}

	public void setRun(V1alpha1CustomStackSpecSourceRegistryImagesBuild run) {
		this.run = run;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		V1alpha1CustomStackSpecSourceRegistryImages v1alpha1CustomStackSpecSourceRegistryImages = (V1alpha1CustomStackSpecSourceRegistryImages) o;
		return Objects.equals(this.build, v1alpha1CustomStackSpecSourceRegistryImages.build)
				&& Objects.equals(this.run, v1alpha1CustomStackSpecSourceRegistryImages.run);
	}

	@Override
	public int hashCode() {
		return Objects.hash(build, run);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class V1alpha1CustomStackSpecSourceRegistryImages {\n");
		sb.append("    build: ").append(toIndentedString(build)).append("\n");
		sb.append("    run: ").append(toIndentedString(run)).append("\n");
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
