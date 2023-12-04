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
 * ContentV1DirectoryColorsGet200ResponseDataInner
 */

@JsonTypeName("_content_v1_directory_colors_get_200_response_data_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1DirectoryColorsGet200ResponseDataInner {

  @JsonProperty("name")
  private String name;

  @JsonProperty("parentName")
  private String parentName;

  public ContentV1DirectoryColorsGet200ResponseDataInner name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Наименование цвета
   * @return name
  */
  
  @Schema(name = "name", example = "персиковый крайола", description = "Наименование цвета", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ContentV1DirectoryColorsGet200ResponseDataInner parentName(String parentName) {
    this.parentName = parentName;
    return this;
  }

  /**
   * Наименование родительского цвета
   * @return parentName
  */
  
  @Schema(name = "parentName", example = "оранжевый", description = "Наименование родительского цвета", required = false)
  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1DirectoryColorsGet200ResponseDataInner contentV1DirectoryColorsGet200ResponseDataInner = (ContentV1DirectoryColorsGet200ResponseDataInner) o;
    return Objects.equals(this.name, contentV1DirectoryColorsGet200ResponseDataInner.name) &&
        Objects.equals(this.parentName, contentV1DirectoryColorsGet200ResponseDataInner.parentName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, parentName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1DirectoryColorsGet200ResponseDataInner {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parentName: ").append(toIndentedString(parentName)).append("\n");
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

