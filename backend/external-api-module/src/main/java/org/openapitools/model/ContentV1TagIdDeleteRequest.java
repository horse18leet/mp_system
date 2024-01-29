package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * ContentV1TagIdDeleteRequest
 */

@JsonTypeName("_content_v1_tag__id__delete_request")
public class ContentV1TagIdDeleteRequest {

  @JsonProperty("color")
  private String color;

  @JsonProperty("name")
  private String name;

  public ContentV1TagIdDeleteRequest color(String color) {
    this.color = color;
    return this;
  }

  /**
   * Цвет тега
   * @return color
  */
  
  @Schema(name = "color", example = "D1CFD7", description = "Цвет тега", required = false)
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public ContentV1TagIdDeleteRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Имя тега
   * @return name
  */
  
  @Schema(name = "name", example = "Sale", description = "Имя тега", required = false)
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
    ContentV1TagIdDeleteRequest contentV1TagIdDeleteRequest = (ContentV1TagIdDeleteRequest) o;
    return Objects.equals(this.color, contentV1TagIdDeleteRequest.color) &&
        Objects.equals(this.name, contentV1TagIdDeleteRequest.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(color, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1TagIdDeleteRequest {\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

