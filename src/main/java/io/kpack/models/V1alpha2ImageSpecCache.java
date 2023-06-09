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
import io.kpack.models.V1alpha2ImageSpecCacheVolume;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * V1alpha2ImageSpecCache
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
		date = "2023-03-27T06:32:24.214Z[Etc/UTC]")
public class V1alpha2ImageSpecCache {

	public static final String SERIALIZED_NAME_VOLUME = "volume";

	@SerializedName(SERIALIZED_NAME_VOLUME)
	private V1alpha2ImageSpecCacheVolume volume;

	public V1alpha2ImageSpecCache volume(V1alpha2ImageSpecCacheVolume volume) {

		this.volume = volume;
		return this;
	}

	/**
	 * Get volume
	 * @return volume
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public V1alpha2ImageSpecCacheVolume getVolume() {
		return volume;
	}

	public void setVolume(V1alpha2ImageSpecCacheVolume volume) {
		this.volume = volume;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		V1alpha2ImageSpecCache v1alpha2ImageSpecCache = (V1alpha2ImageSpecCache) o;
		return Objects.equals(this.volume, v1alpha2ImageSpecCache.volume);
	}

	@Override
	public int hashCode() {
		return Objects.hash(volume);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class V1alpha2ImageSpecCache {\n");
		sb.append("    volume: ").append(toIndentedString(volume)).append("\n");
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
