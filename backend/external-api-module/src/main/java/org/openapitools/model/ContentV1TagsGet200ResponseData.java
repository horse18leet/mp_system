package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ContentV1TagsGet200ResponseData
 */

@JsonTypeName("_content_v1_tags_get_200_response_data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1TagsGet200ResponseData {

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("color")
  private String color;

  @JsonProperty("name")
  private String name;

  public ContentV1TagsGet200ResponseData id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Числовой идентификатор тега
   * @return id
  */
  
  @Schema(name = "id", description = "Числовой идентификатор тега", required = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ContentV1TagsGet200ResponseData color(String color) {
    this.color = color;
    return this;
  }

  /**
   * Цвет тега
   * @return color
  */
  
  @Schema(name = "color", description = "Цвет тега", required = false)
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public ContentV1TagsGet200ResponseData name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Имя тега
   * @return name
  */
  
  @Schema(name = "name", description = "Имя тега", required = false)
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
    ContentV1TagsGet200ResponseData contentV1TagsGet200ResponseData = (ContentV1TagsGet200ResponseData) o;
    return Objects.equals(this.id, contentV1TagsGet200ResponseData.id) &&
        Objects.equals(this.color, contentV1TagsGet200ResponseData.color) &&
        Objects.equals(this.name, contentV1TagsGet200ResponseData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, color, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1TagsGet200ResponseData {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

