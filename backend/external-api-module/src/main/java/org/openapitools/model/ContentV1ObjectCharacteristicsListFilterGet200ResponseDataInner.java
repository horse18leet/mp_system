package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner
 */

@JsonTypeName("_content_v1_object_characteristics_list_filter_get_200_response_data_inner")
public class ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner {

  @JsonProperty("objectName")
  private String objectName;

  @JsonProperty("name")
  private String name;

  @JsonProperty("required")
  private Boolean required;

  @JsonProperty("unitName")
  private String unitName;

  @JsonProperty("maxCount")
  private Integer maxCount;

  @JsonProperty("popular")
  private Boolean popular;

  @JsonProperty("charcType")
  private Integer charcType;

  public ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner objectName(String objectName) {
    this.objectName = objectName;
    return this;
  }

  /**
   * Наименование подкатегории
   * @return objectName
  */
  
  @Schema(name = "objectName", example = "Косухи", description = "Наименование подкатегории", required = false)
  public String getObjectName() {
    return objectName;
  }

  public void setObjectName(String objectName) {
    this.objectName = objectName;
  }

  public ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Наименование характеристики
   * @return name
  */
  
  @Schema(name = "name", example = "Особенности модели", description = "Наименование характеристики", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner required(Boolean required) {
    this.required = required;
    return this;
  }

  /**
   * Характеристика обязательна к заполенению
   * @return required
  */
  
  @Schema(name = "required", example = "false", description = "Характеристика обязательна к заполенению", required = false)
  public Boolean getRequired() {
    return required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner unitName(String unitName) {
    this.unitName = unitName;
    return this;
  }

  /**
   * Единица имерения (см, гр и т.д.)
   * @return unitName
  */
  
  @Schema(name = "unitName", example = "", description = "Единица имерения (см, гр и т.д.)", required = false)
  public String getUnitName() {
    return unitName;
  }

  public void setUnitName(String unitName) {
    this.unitName = unitName;
  }

  public ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner maxCount(Integer maxCount) {
    this.maxCount = maxCount;
    return this;
  }

  /**
   * Максимальное кол-во значений которое можно присвоить данной характеристике
   * @return maxCount
  */
  
  @Schema(name = "maxCount", example = "1", description = "Максимальное кол-во значений которое можно присвоить данной характеристике", required = false)
  public Integer getMaxCount() {
    return maxCount;
  }

  public void setMaxCount(Integer maxCount) {
    this.maxCount = maxCount;
  }

  public ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner popular(Boolean popular) {
    this.popular = popular;
    return this;
  }

  /**
   * Характеристика популярна у пользователей
   * @return popular
  */
  
  @Schema(name = "popular", example = "false", description = "Характеристика популярна у пользователей", required = false)
  public Boolean getPopular() {
    return popular;
  }

  public void setPopular(Boolean popular) {
    this.popular = popular;
  }

  public ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner charcType(Integer charcType) {
    this.charcType = charcType;
    return this;
  }

  /**
   * Тип характеристики (1 и 0 - строка или массив строк; 4 - число или массив чисел)
   * @return charcType
  */
  
  @Schema(name = "charcType", example = "1", description = "Тип характеристики (1 и 0 - строка или массив строк; 4 - число или массив чисел)", required = false)
  public Integer getCharcType() {
    return charcType;
  }

  public void setCharcType(Integer charcType) {
    this.charcType = charcType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner contentV1ObjectCharacteristicsListFilterGet200ResponseDataInner = (ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner) o;
    return Objects.equals(this.objectName, contentV1ObjectCharacteristicsListFilterGet200ResponseDataInner.objectName) &&
        Objects.equals(this.name, contentV1ObjectCharacteristicsListFilterGet200ResponseDataInner.name) &&
        Objects.equals(this.required, contentV1ObjectCharacteristicsListFilterGet200ResponseDataInner.required) &&
        Objects.equals(this.unitName, contentV1ObjectCharacteristicsListFilterGet200ResponseDataInner.unitName) &&
        Objects.equals(this.maxCount, contentV1ObjectCharacteristicsListFilterGet200ResponseDataInner.maxCount) &&
        Objects.equals(this.popular, contentV1ObjectCharacteristicsListFilterGet200ResponseDataInner.popular) &&
        Objects.equals(this.charcType, contentV1ObjectCharacteristicsListFilterGet200ResponseDataInner.charcType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectName, name, required, unitName, maxCount, popular, charcType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner {\n");
    sb.append("    objectName: ").append(toIndentedString(objectName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    unitName: ").append(toIndentedString(unitName)).append("\n");
    sb.append("    maxCount: ").append(toIndentedString(maxCount)).append("\n");
    sb.append("    popular: ").append(toIndentedString(popular)).append("\n");
    sb.append("    charcType: ").append(toIndentedString(charcType)).append("\n");
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

