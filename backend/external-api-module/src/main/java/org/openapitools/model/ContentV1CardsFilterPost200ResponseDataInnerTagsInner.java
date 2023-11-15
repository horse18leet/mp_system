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
 * ContentV1CardsFilterPost200ResponseDataInnerTagsInner
 */

@JsonTypeName("_content_v1_cards_filter_post_200_response_data_inner_tags_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1CardsFilterPost200ResponseDataInnerTagsInner {

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("color")
  private String color;

  public ContentV1CardsFilterPost200ResponseDataInnerTagsInner id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Идентификатор тега
   * @return id
  */
  
  @Schema(name = "id", description = "Идентификатор тега", required = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ContentV1CardsFilterPost200ResponseDataInnerTagsInner name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название тега
   * @return name
  */
  
  @Schema(name = "name", description = "Название тега", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ContentV1CardsFilterPost200ResponseDataInnerTagsInner color(String color) {
    this.color = color;
    return this;
  }

  /**
   * Цвет тега в формате HEX
   * @return color
  */
  
  @Schema(name = "color", description = "Цвет тега в формате HEX", required = false)
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsFilterPost200ResponseDataInnerTagsInner contentV1CardsFilterPost200ResponseDataInnerTagsInner = (ContentV1CardsFilterPost200ResponseDataInnerTagsInner) o;
    return Objects.equals(this.id, contentV1CardsFilterPost200ResponseDataInnerTagsInner.id) &&
        Objects.equals(this.name, contentV1CardsFilterPost200ResponseDataInnerTagsInner.name) &&
        Objects.equals(this.color, contentV1CardsFilterPost200ResponseDataInnerTagsInner.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, color);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsFilterPost200ResponseDataInnerTagsInner {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
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

