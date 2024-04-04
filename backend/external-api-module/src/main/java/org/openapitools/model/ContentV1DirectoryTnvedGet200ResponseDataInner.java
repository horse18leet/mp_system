package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * ContentV1DirectoryTnvedGet200ResponseDataInner
 */

@JsonTypeName("_content_v1_directory_tnved_get_200_response_data_inner")
public class ContentV1DirectoryTnvedGet200ResponseDataInner {

  @JsonProperty("subjectName")
  private String subjectName;

  @JsonProperty("tnvedName")
  private String tnvedName;

  @JsonProperty("description")
  private String description;

  @JsonProperty("isKiz")
  private Boolean isKiz;

  public ContentV1DirectoryTnvedGet200ResponseDataInner subjectName(String subjectName) {
    this.subjectName = subjectName;
    return this;
  }

  /**
   * Наименование категории
   * @return subjectName
  */
  
  @Schema(name = "subjectName", example = "Блузки", description = "Наименование категории", required = false)
  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public ContentV1DirectoryTnvedGet200ResponseDataInner tnvedName(String tnvedName) {
    this.tnvedName = tnvedName;
    return this;
  }

  /**
   * Код ТНВЭД
   * @return tnvedName
  */
  
  @Schema(name = "tnvedName", example = "4203100001", description = "Код ТНВЭД", required = false)
  public String getTnvedName() {
    return tnvedName;
  }

  public void setTnvedName(String tnvedName) {
    this.tnvedName = tnvedName;
  }

  public ContentV1DirectoryTnvedGet200ResponseDataInner description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Описание кода ТНВЭД
   * @return description
  */
  
  @Schema(name = "description", example = "Предметы одежды из натуральной кожи", description = "Описание кода ТНВЭД", required = false)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ContentV1DirectoryTnvedGet200ResponseDataInner isKiz(Boolean isKiz) {
    this.isKiz = isKiz;
    return this;
  }

  /**
   * КИЗовый ТНВЭД
   * @return isKiz
  */
  
  @Schema(name = "isKiz", example = "true", description = "КИЗовый ТНВЭД", required = false)
  public Boolean getIsKiz() {
    return isKiz;
  }

  public void setIsKiz(Boolean isKiz) {
    this.isKiz = isKiz;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1DirectoryTnvedGet200ResponseDataInner contentV1DirectoryTnvedGet200ResponseDataInner = (ContentV1DirectoryTnvedGet200ResponseDataInner) o;
    return Objects.equals(this.subjectName, contentV1DirectoryTnvedGet200ResponseDataInner.subjectName) &&
        Objects.equals(this.tnvedName, contentV1DirectoryTnvedGet200ResponseDataInner.tnvedName) &&
        Objects.equals(this.description, contentV1DirectoryTnvedGet200ResponseDataInner.description) &&
        Objects.equals(this.isKiz, contentV1DirectoryTnvedGet200ResponseDataInner.isKiz);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subjectName, tnvedName, description, isKiz);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1DirectoryTnvedGet200ResponseDataInner {\n");
    sb.append("    subjectName: ").append(toIndentedString(subjectName)).append("\n");
    sb.append("    tnvedName: ").append(toIndentedString(tnvedName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isKiz: ").append(toIndentedString(isKiz)).append("\n");
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

