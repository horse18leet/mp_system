package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * ContentV1ObjectParentAllGet200ResponseDataInner
 */

@JsonTypeName("_content_v1_object_parent_all_get_200_response_data_inner")
public class ContentV1ObjectParentAllGet200ResponseDataInner {

  @JsonProperty("name")
  private String name;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("isVisible")
  private Boolean isVisible;

  public ContentV1ObjectParentAllGet200ResponseDataInner name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название категории
   * @return name
  */
  
  @Schema(name = "name", example = "Электроника", description = "Название категории", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ContentV1ObjectParentAllGet200ResponseDataInner id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Идентификатор родительской категории
   * @return id
  */
  
  @Schema(name = "id", example = "479", description = "Идентификатор родительской категории", required = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ContentV1ObjectParentAllGet200ResponseDataInner isVisible(Boolean isVisible) {
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
    ContentV1ObjectParentAllGet200ResponseDataInner contentV1ObjectParentAllGet200ResponseDataInner = (ContentV1ObjectParentAllGet200ResponseDataInner) o;
    return Objects.equals(this.name, contentV1ObjectParentAllGet200ResponseDataInner.name) &&
        Objects.equals(this.id, contentV1ObjectParentAllGet200ResponseDataInner.id) &&
        Objects.equals(this.isVisible, contentV1ObjectParentAllGet200ResponseDataInner.isVisible);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id, isVisible);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1ObjectParentAllGet200ResponseDataInner {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

