package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.ContentV1CardsUpdatePostRequestInnerSizesInner;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ContentV1CardsUpdatePostRequestInner
 */

@JsonTypeName("_content_v1_cards_update_post_request_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1CardsUpdatePostRequestInner {

  @JsonProperty("imtID")
  private Integer imtID;

  @JsonProperty("nmID")
  private Integer nmID;

  @JsonProperty("object")
  private String _object;

  @JsonProperty("objectID")
  private Integer objectID;

  @JsonProperty("vendorCode")
  private String vendorCode;

  @JsonProperty("mediaFiles")
  @Valid
  private List<String> mediaFiles = null;

  @JsonProperty("sizes")
  @Valid
  private List<ContentV1CardsUpdatePostRequestInnerSizesInner> sizes = new ArrayList<>();

  @JsonProperty("characteristics")
  @Valid
  private List<Object> characteristics = new ArrayList<>();

  public ContentV1CardsUpdatePostRequestInner imtID(Integer imtID) {
    this.imtID = imtID;
    return this;
  }

  /**
   * Идентификатор карточки товара
   * @return imtID
  */
  
  @Schema(name = "imtID", example = "85792498", description = "Идентификатор карточки товара", required = false)
  public Integer getImtID() {
    return imtID;
  }

  public void setImtID(Integer imtID) {
    this.imtID = imtID;
  }

  public ContentV1CardsUpdatePostRequestInner nmID(Integer nmID) {
    this.nmID = nmID;
    return this;
  }

  /**
   * Артикул WB
   * @return nmID
  */
  @NotNull 
  @Schema(name = "nmID", example = "66964219", description = "Артикул WB", required = true)
  public Integer getNmID() {
    return nmID;
  }

  public void setNmID(Integer nmID) {
    this.nmID = nmID;
  }

  public ContentV1CardsUpdatePostRequestInner _object(String _object) {
    this._object = _object;
    return this;
  }

  /**
   * Предмет
   * @return _object
  */
  
  @Schema(name = "object", example = "Рубашки", description = "Предмет", required = false)
  public String getObject() {
    return _object;
  }

  public void setObject(String _object) {
    this._object = _object;
  }

  public ContentV1CardsUpdatePostRequestInner objectID(Integer objectID) {
    this.objectID = objectID;
    return this;
  }

  /**
   * Идентификатор предмета
   * @return objectID
  */
  
  @Schema(name = "objectID", example = "184", description = "Идентификатор предмета", required = false)
  public Integer getObjectID() {
    return objectID;
  }

  public void setObjectID(Integer objectID) {
    this.objectID = objectID;
  }

  public ContentV1CardsUpdatePostRequestInner vendorCode(String vendorCode) {
    this.vendorCode = vendorCode;
    return this;
  }

  /**
   * Артикул продавца
   * @return vendorCode
  */
  @NotNull 
  @Schema(name = "vendorCode", example = "6000000001", description = "Артикул продавца", required = true)
  public String getVendorCode() {
    return vendorCode;
  }

  public void setVendorCode(String vendorCode) {
    this.vendorCode = vendorCode;
  }

  public ContentV1CardsUpdatePostRequestInner mediaFiles(List<String> mediaFiles) {
    this.mediaFiles = mediaFiles;
    return this;
  }

  public ContentV1CardsUpdatePostRequestInner addMediaFilesItem(String mediaFilesItem) {
    if (this.mediaFiles == null) {
      this.mediaFiles = new ArrayList<>();
    }
    this.mediaFiles.add(mediaFilesItem);
    return this;
  }

  /**
   * Медиафайлы номенклатуры
   * @return mediaFiles
  */
  
  @Schema(name = "mediaFiles", description = "Медиафайлы номенклатуры", required = false)
  public List<String> getMediaFiles() {
    return mediaFiles;
  }

  public void setMediaFiles(List<String> mediaFiles) {
    this.mediaFiles = mediaFiles;
  }

  public ContentV1CardsUpdatePostRequestInner sizes(List<ContentV1CardsUpdatePostRequestInnerSizesInner> sizes) {
    this.sizes = sizes;
    return this;
  }

  public ContentV1CardsUpdatePostRequestInner addSizesItem(ContentV1CardsUpdatePostRequestInnerSizesInner sizesItem) {
    this.sizes.add(sizesItem);
    return this;
  }

  /**
   * Массив размеров для номенклатуры (для безразмерного товара все равно нужно передавать данный массив без параметров (`wbSize` и `techSize`), но с `chrtID` и баркодом)
   * @return sizes
  */
  @NotNull @Valid 
  @Schema(name = "sizes", description = "Массив размеров для номенклатуры (для безразмерного товара все равно нужно передавать данный массив без параметров (`wbSize` и `techSize`), но с `chrtID` и баркодом)", required = true)
  public List<ContentV1CardsUpdatePostRequestInnerSizesInner> getSizes() {
    return sizes;
  }

  public void setSizes(List<ContentV1CardsUpdatePostRequestInnerSizesInner> sizes) {
    this.sizes = sizes;
  }

  public ContentV1CardsUpdatePostRequestInner characteristics(List<Object> characteristics) {
    this.characteristics = characteristics;
    return this;
  }

  public ContentV1CardsUpdatePostRequestInner addCharacteristicsItem(Object characteristicsItem) {
    this.characteristics.add(characteristicsItem);
    return this;
  }

  /**
   * Массив характеристик, индивидуальный для каждой категории
   * @return characteristics
  */
  @NotNull 
  @Schema(name = "characteristics", example = "[{\"ТНВЭД\":[\"6403993600\"]},{\"Пол\":[\"Мужской\"]},{\"Цвет\":[\"зеленый\"]},{\"Предмет\":[\"Блузки\"]}]", description = "Массив характеристик, индивидуальный для каждой категории", required = true)
  public List<Object> getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(List<Object> characteristics) {
    this.characteristics = characteristics;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsUpdatePostRequestInner contentV1CardsUpdatePostRequestInner = (ContentV1CardsUpdatePostRequestInner) o;
    return Objects.equals(this.imtID, contentV1CardsUpdatePostRequestInner.imtID) &&
        Objects.equals(this.nmID, contentV1CardsUpdatePostRequestInner.nmID) &&
        Objects.equals(this._object, contentV1CardsUpdatePostRequestInner._object) &&
        Objects.equals(this.objectID, contentV1CardsUpdatePostRequestInner.objectID) &&
        Objects.equals(this.vendorCode, contentV1CardsUpdatePostRequestInner.vendorCode) &&
        Objects.equals(this.mediaFiles, contentV1CardsUpdatePostRequestInner.mediaFiles) &&
        Objects.equals(this.sizes, contentV1CardsUpdatePostRequestInner.sizes) &&
        Objects.equals(this.characteristics, contentV1CardsUpdatePostRequestInner.characteristics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imtID, nmID, _object, objectID, vendorCode, mediaFiles, sizes, characteristics);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsUpdatePostRequestInner {\n");
    sb.append("    imtID: ").append(toIndentedString(imtID)).append("\n");
    sb.append("    nmID: ").append(toIndentedString(nmID)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    objectID: ").append(toIndentedString(objectID)).append("\n");
    sb.append("    vendorCode: ").append(toIndentedString(vendorCode)).append("\n");
    sb.append("    mediaFiles: ").append(toIndentedString(mediaFiles)).append("\n");
    sb.append("    sizes: ").append(toIndentedString(sizes)).append("\n");
    sb.append("    characteristics: ").append(toIndentedString(characteristics)).append("\n");
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

