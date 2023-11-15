package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ContentV1CardsErrorListGet200ResponseDataInner
 */

@JsonTypeName("_content_v1_cards_error_list_get_200_response_data_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1CardsErrorListGet200ResponseDataInner {

  @JsonProperty("object")
  private String _object;

  @JsonProperty("vendorCode")
  private String vendorCode;

  @JsonProperty("updateAt")
  private String updateAt;

  @JsonProperty("errors")
  @Valid
  private List<String> errors = null;

  @JsonProperty("objectID")
  private Integer objectID;

  public ContentV1CardsErrorListGet200ResponseDataInner _object(String _object) {
    this._object = _object;
    return this;
  }

  /**
   * Категория для который создавалось КТ с данной НМ
   * @return _object
  */
  
  @Schema(name = "object", example = "Блузки", description = "Категория для который создавалось КТ с данной НМ", required = false)
  public String getObject() {
    return _object;
  }

  public void setObject(String _object) {
    this._object = _object;
  }

  public ContentV1CardsErrorListGet200ResponseDataInner vendorCode(String vendorCode) {
    this.vendorCode = vendorCode;
    return this;
  }

  /**
   * Артикул продавца
   * @return vendorCode
  */
  
  @Schema(name = "vendorCode", example = "6000000001", description = "Артикул продавца", required = false)
  public String getVendorCode() {
    return vendorCode;
  }

  public void setVendorCode(String vendorCode) {
    this.vendorCode = vendorCode;
  }

  public ContentV1CardsErrorListGet200ResponseDataInner updateAt(String updateAt) {
    this.updateAt = updateAt;
    return this;
  }

  /**
   * Дата и время запроса на создание КТ с данным НМ
   * @return updateAt
  */
  
  @Schema(name = "updateAt", example = "2022-06-15T14:37:13Z", description = "Дата и время запроса на создание КТ с данным НМ", required = false)
  public String getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(String updateAt) {
    this.updateAt = updateAt;
  }

  public ContentV1CardsErrorListGet200ResponseDataInner errors(List<String> errors) {
    this.errors = errors;
    return this;
  }

  public ContentV1CardsErrorListGet200ResponseDataInner addErrorsItem(String errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Список ошибок из-за которых не обработался запрос на создание КТ с данным НМ
   * @return errors
  */
  
  @Schema(name = "errors", description = "Список ошибок из-за которых не обработался запрос на создание КТ с данным НМ", required = false)
  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

  public ContentV1CardsErrorListGet200ResponseDataInner objectID(Integer objectID) {
    this.objectID = objectID;
    return this;
  }

  /**
   * Идентификатор предмета
   * @return objectID
  */
  
  @Schema(name = "objectID", example = "41", description = "Идентификатор предмета", required = false)
  public Integer getObjectID() {
    return objectID;
  }

  public void setObjectID(Integer objectID) {
    this.objectID = objectID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsErrorListGet200ResponseDataInner contentV1CardsErrorListGet200ResponseDataInner = (ContentV1CardsErrorListGet200ResponseDataInner) o;
    return Objects.equals(this._object, contentV1CardsErrorListGet200ResponseDataInner._object) &&
        Objects.equals(this.vendorCode, contentV1CardsErrorListGet200ResponseDataInner.vendorCode) &&
        Objects.equals(this.updateAt, contentV1CardsErrorListGet200ResponseDataInner.updateAt) &&
        Objects.equals(this.errors, contentV1CardsErrorListGet200ResponseDataInner.errors) &&
        Objects.equals(this.objectID, contentV1CardsErrorListGet200ResponseDataInner.objectID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_object, vendorCode, updateAt, errors, objectID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsErrorListGet200ResponseDataInner {\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    vendorCode: ").append(toIndentedString(vendorCode)).append("\n");
    sb.append("    updateAt: ").append(toIndentedString(updateAt)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    objectID: ").append(toIndentedString(objectID)).append("\n");
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

