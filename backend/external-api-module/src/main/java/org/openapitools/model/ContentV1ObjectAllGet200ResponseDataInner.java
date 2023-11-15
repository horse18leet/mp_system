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
 * ContentV1ObjectAllGet200ResponseDataInner
 */

@JsonTypeName("_content_v1_object_all_get_200_response_data_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1ObjectAllGet200ResponseDataInner {

  @JsonProperty("objectID")
  private Integer objectID;

  @JsonProperty("parentID")
  private Integer parentID;

  @JsonProperty("objectName")
  private String objectName;

  @JsonProperty("parentName")
  private String parentName;

  @JsonProperty("isVisible")
  private Boolean isVisible;

  public ContentV1ObjectAllGet200ResponseDataInner objectID(Integer objectID) {
    this.objectID = objectID;
    return this;
  }

  /**
   * Идентификатор предмета
   * @return objectID
  */
  
  @Schema(name = "objectID", example = "2560", description = "Идентификатор предмета", required = false)
  public Integer getObjectID() {
    return objectID;
  }

  public void setObjectID(Integer objectID) {
    this.objectID = objectID;
  }

  public ContentV1ObjectAllGet200ResponseDataInner parentID(Integer parentID) {
    this.parentID = parentID;
    return this;
  }

  /**
   * Идентификатор родительской категории
   * @return parentID
  */
  
  @Schema(name = "parentID", example = "479", description = "Идентификатор родительской категории", required = false)
  public Integer getParentID() {
    return parentID;
  }

  public void setParentID(Integer parentID) {
    this.parentID = parentID;
  }

  public ContentV1ObjectAllGet200ResponseDataInner objectName(String objectName) {
    this.objectName = objectName;
    return this;
  }

  /**
   * Название категории
   * @return objectName
  */
  
  @Schema(name = "objectName", example = "3D очки", description = "Название категории", required = false)
  public String getObjectName() {
    return objectName;
  }

  public void setObjectName(String objectName) {
    this.objectName = objectName;
  }

  public ContentV1ObjectAllGet200ResponseDataInner parentName(String parentName) {
    this.parentName = parentName;
    return this;
  }

  /**
   * Название родительской категории
   * @return parentName
  */
  
  @Schema(name = "parentName", example = "Электроника", description = "Название родительской категории", required = false)
  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public ContentV1ObjectAllGet200ResponseDataInner isVisible(Boolean isVisible) {
    this.isVisible = isVisible;
    return this;
  }

  /**
   * Виден на сайте
   * @return isVisible
  */
  
  @Schema(name = "isVisible", example = "true", description = "Виден на сайте", required = false)
  public Boolean getIsVisible() {
    return isVisible;
  }

  public void setIsVisible(Boolean isVisible) {
    this.isVisible = isVisible;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1ObjectAllGet200ResponseDataInner contentV1ObjectAllGet200ResponseDataInner = (ContentV1ObjectAllGet200ResponseDataInner) o;
    return Objects.equals(this.objectID, contentV1ObjectAllGet200ResponseDataInner.objectID) &&
        Objects.equals(this.parentID, contentV1ObjectAllGet200ResponseDataInner.parentID) &&
        Objects.equals(this.objectName, contentV1ObjectAllGet200ResponseDataInner.objectName) &&
        Objects.equals(this.parentName, contentV1ObjectAllGet200ResponseDataInner.parentName) &&
        Objects.equals(this.isVisible, contentV1ObjectAllGet200ResponseDataInner.isVisible);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectID, parentID, objectName, parentName, isVisible);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1ObjectAllGet200ResponseDataInner {\n");
    sb.append("    objectID: ").append(toIndentedString(objectID)).append("\n");
    sb.append("    parentID: ").append(toIndentedString(parentID)).append("\n");
    sb.append("    objectName: ").append(toIndentedString(objectName)).append("\n");
    sb.append("    parentName: ").append(toIndentedString(parentName)).append("\n");
    sb.append("    isVisible: ").append(toIndentedString(isVisible)).append("\n");
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

