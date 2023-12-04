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
 * ContentV1DirectoryCountriesGet200ResponseDataInner
 */

@JsonTypeName("_content_v1_directory_countries_get_200_response_data_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1DirectoryCountriesGet200ResponseDataInner {

  @JsonProperty("name")
  private String name;

  @JsonProperty("fullName")
  private String fullName;

  public ContentV1DirectoryCountriesGet200ResponseDataInner name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Значение характеристики Страны
   * @return name
  */
  
  @Schema(name = "name", example = "Афганистан", description = "Значение характеристики Страны", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ContentV1DirectoryCountriesGet200ResponseDataInner fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * Полное название страны
   * @return fullName
  */
  
  @Schema(name = "fullName", example = "Исламский Эмират Афганистан", description = "Полное название страны", required = false)
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1DirectoryCountriesGet200ResponseDataInner contentV1DirectoryCountriesGet200ResponseDataInner = (ContentV1DirectoryCountriesGet200ResponseDataInner) o;
    return Objects.equals(this.name, contentV1DirectoryCountriesGet200ResponseDataInner.name) &&
        Objects.equals(this.fullName, contentV1DirectoryCountriesGet200ResponseDataInner.fullName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, fullName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1DirectoryCountriesGet200ResponseDataInner {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
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

