package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * ContentV1TagPostRequest
 */

@JsonTypeName("_content_v1_tag_post_request")
public class ContentV1TagPostRequest {

  @JsonProperty("color")
  private String color;

  @JsonProperty("name")
  private String name;

  public ContentV1TagPostRequest color(String color) {
    this.color = color;
    return this;
  }

  /**
   * Цвет тега. <dl> <dt>Доступные цвета:</dt> <dd><code>D1CFD7</code> - серый</dd> <dd><code>FEE0E0</code> - красный</dd> <dd><code>ECDAFF</code> - фиолетовый</dd> <dd><code>E4EAFF</code> - синий</dd> <dd><code>DEF1DD</code> - зеленный</dd> <dd><code>FFECC7</code> - желтый</dd> </dl> 
   * @return color
  */
  
  @Schema(name = "color", example = "D1CFD7", description = "Цвет тега. <dl> <dt>Доступные цвета:</dt> <dd><code>D1CFD7</code> - серый</dd> <dd><code>FEE0E0</code> - красный</dd> <dd><code>ECDAFF</code> - фиолетовый</dd> <dd><code>E4EAFF</code> - синий</dd> <dd><code>DEF1DD</code> - зеленный</dd> <dd><code>FFECC7</code> - желтый</dd> </dl> ", required = false)
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public ContentV1TagPostRequest name(String name) {
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
    ContentV1TagPostRequest contentV1TagPostRequest = (ContentV1TagPostRequest) o;
    return Objects.equals(this.color, contentV1TagPostRequest.color) &&
        Objects.equals(this.name, contentV1TagPostRequest.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(color, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1TagPostRequest {\n");
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

