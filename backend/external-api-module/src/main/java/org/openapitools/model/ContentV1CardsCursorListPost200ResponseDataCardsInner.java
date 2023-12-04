package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.ContentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ContentV1CardsCursorListPost200ResponseDataCardsInner
 */

@JsonTypeName("_content_v1_cards_cursor_list_post_200_response_data_cards_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1CardsCursorListPost200ResponseDataCardsInner {

  @JsonProperty("sizes")
  @Valid
  private List<ContentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner> sizes = null;

  @JsonProperty("mediaFiles")
  @Valid
  private List<String> mediaFiles = null;

  @JsonProperty("colors")
  @Valid
  private List<String> colors = null;

  @JsonProperty("updateAt")
  private String updateAt;

  @JsonProperty("vendorCode")
  private String vendorCode;

  @JsonProperty("brand")
  private String brand;

  @JsonProperty("object")
  private String _object;

  @JsonProperty("nmID")
  private Integer nmID;

  @JsonProperty("imtID")
  private Integer imtID;

  @JsonProperty("objectID")
  private Integer objectID;

  @JsonProperty("isProhibited")
  private Boolean isProhibited;

  @JsonProperty("tags")
  @Valid
  private List<String> tags = null;

  public ContentV1CardsCursorListPost200ResponseDataCardsInner sizes(List<ContentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner> sizes) {
    this.sizes = sizes;
    return this;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInner addSizesItem(ContentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner sizesItem) {
    if (this.sizes == null) {
      this.sizes = new ArrayList<>();
    }
    this.sizes.add(sizesItem);
    return this;
  }

  /**
   * Массив размеров для номенклатуры (для безразмерного товара все равно нужно передавать данный массив с одним элементом и нулевым размером, но с ценой и баркодом) 
   * @return sizes
  */
  @Valid 
  @Schema(name = "sizes", description = "Массив размеров для номенклатуры (для безразмерного товара все равно нужно передавать данный массив с одним элементом и нулевым размером, но с ценой и баркодом) ", required = false)
  public List<ContentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner> getSizes() {
    return sizes;
  }

  public void setSizes(List<ContentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner> sizes) {
    this.sizes = sizes;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInner mediaFiles(List<String> mediaFiles) {
    this.mediaFiles = mediaFiles;
    return this;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInner addMediaFilesItem(String mediaFilesItem) {
    if (this.mediaFiles == null) {
      this.mediaFiles = new ArrayList<>();
    }
    this.mediaFiles.add(mediaFilesItem);
    return this;
  }

  /**
   * Медиафайлы номенклатуры. <br>Фото, URL которого заканчивается на <b>1.jpg</b> является главным в карточке. 
   * @return mediaFiles
  */
  
  @Schema(name = "mediaFiles", description = "Медиафайлы номенклатуры. <br>Фото, URL которого заканчивается на <b>1.jpg</b> является главным в карточке. ", required = false)
  public List<String> getMediaFiles() {
    return mediaFiles;
  }

  public void setMediaFiles(List<String> mediaFiles) {
    this.mediaFiles = mediaFiles;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInner colors(List<String> colors) {
    this.colors = colors;
    return this;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInner addColorsItem(String colorsItem) {
    if (this.colors == null) {
      this.colors = new ArrayList<>();
    }
    this.colors.add(colorsItem);
    return this;
  }

  /**
   * Цвета номенклатуры
   * @return colors
  */
  
  @Schema(name = "colors", description = "Цвета номенклатуры", required = false)
  public List<String> getColors() {
    return colors;
  }

  public void setColors(List<String> colors) {
    this.colors = colors;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInner updateAt(String updateAt) {
    this.updateAt = updateAt;
    return this;
  }

  /**
   * Дата обновления
   * @return updateAt
  */
  
  @Schema(name = "updateAt", example = "2022-08-10T10:16:52Z", description = "Дата обновления", required = false)
  public String getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(String updateAt) {
    this.updateAt = updateAt;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInner vendorCode(String vendorCode) {
    this.vendorCode = vendorCode;
    return this;
  }

  /**
   * Артикул продавца
   * @return vendorCode
  */
  
  @Schema(name = "vendorCode", example = "670000001", description = "Артикул продавца", required = false)
  public String getVendorCode() {
    return vendorCode;
  }

  public void setVendorCode(String vendorCode) {
    this.vendorCode = vendorCode;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInner brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * Брэнд
   * @return brand
  */
  
  @Schema(name = "brand", example = "Шанель", description = "Брэнд", required = false)
  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInner _object(String _object) {
    this._object = _object;
    return this;
  }

  /**
   * Категория для который создавалось КТ с данной НМ
   * @return _object
  */
  
  @Schema(name = "object", example = "Туалетная вода", description = "Категория для который создавалось КТ с данной НМ", required = false)
  public String getObject() {
    return _object;
  }

  public void setObject(String _object) {
    this._object = _object;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInner nmID(Integer nmID) {
    this.nmID = nmID;
    return this;
  }

  /**
   * Артикул WB
   * @return nmID
  */
  
  @Schema(name = "nmID", example = "66964167", description = "Артикул WB", required = false)
  public Integer getNmID() {
    return nmID;
  }

  public void setNmID(Integer nmID) {
    this.nmID = nmID;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInner imtID(Integer imtID) {
    this.imtID = imtID;
    return this;
  }

  /**
   * Идентификатор карточки товара (нужен для группирования НМ в одну КТ)
   * @return imtID
  */
  
  @Schema(name = "imtID", example = "12313123", description = "Идентификатор карточки товара (нужен для группирования НМ в одну КТ)", required = false)
  public Integer getImtID() {
    return imtID;
  }

  public void setImtID(Integer imtID) {
    this.imtID = imtID;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInner objectID(Integer objectID) {
    this.objectID = objectID;
    return this;
  }

  /**
   * Идентификатор предмета
   * @return objectID
  */
  
  @Schema(name = "objectID", example = "96", description = "Идентификатор предмета", required = false)
  public Integer getObjectID() {
    return objectID;
  }

  public void setObjectID(Integer objectID) {
    this.objectID = objectID;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInner isProhibited(Boolean isProhibited) {
    this.isProhibited = isProhibited;
    return this;
  }

  /**
   * `true` - категория карточки запрещена к реализации<br> `false` - категория карточки разрешена к реализации 
   * @return isProhibited
  */
  
  @Schema(name = "isProhibited", example = "false", description = "`true` - категория карточки запрещена к реализации<br> `false` - категория карточки разрешена к реализации ", required = false)
  public Boolean getIsProhibited() {
    return isProhibited;
  }

  public void setIsProhibited(Boolean isProhibited) {
    this.isProhibited = isProhibited;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInner tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInner addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Массив тегов
   * @return tags
  */
  
  @Schema(name = "tags", description = "Массив тегов", required = false)
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsCursorListPost200ResponseDataCardsInner contentV1CardsCursorListPost200ResponseDataCardsInner = (ContentV1CardsCursorListPost200ResponseDataCardsInner) o;
    return Objects.equals(this.sizes, contentV1CardsCursorListPost200ResponseDataCardsInner.sizes) &&
        Objects.equals(this.mediaFiles, contentV1CardsCursorListPost200ResponseDataCardsInner.mediaFiles) &&
        Objects.equals(this.colors, contentV1CardsCursorListPost200ResponseDataCardsInner.colors) &&
        Objects.equals(this.updateAt, contentV1CardsCursorListPost200ResponseDataCardsInner.updateAt) &&
        Objects.equals(this.vendorCode, contentV1CardsCursorListPost200ResponseDataCardsInner.vendorCode) &&
        Objects.equals(this.brand, contentV1CardsCursorListPost200ResponseDataCardsInner.brand) &&
        Objects.equals(this._object, contentV1CardsCursorListPost200ResponseDataCardsInner._object) &&
        Objects.equals(this.nmID, contentV1CardsCursorListPost200ResponseDataCardsInner.nmID) &&
        Objects.equals(this.imtID, contentV1CardsCursorListPost200ResponseDataCardsInner.imtID) &&
        Objects.equals(this.objectID, contentV1CardsCursorListPost200ResponseDataCardsInner.objectID) &&
        Objects.equals(this.isProhibited, contentV1CardsCursorListPost200ResponseDataCardsInner.isProhibited) &&
        Objects.equals(this.tags, contentV1CardsCursorListPost200ResponseDataCardsInner.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sizes, mediaFiles, colors, updateAt, vendorCode, brand, _object, nmID, imtID, objectID, isProhibited, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsCursorListPost200ResponseDataCardsInner {\n");
    sb.append("    sizes: ").append(toIndentedString(sizes)).append("\n");
    sb.append("    mediaFiles: ").append(toIndentedString(mediaFiles)).append("\n");
    sb.append("    colors: ").append(toIndentedString(colors)).append("\n");
    sb.append("    updateAt: ").append(toIndentedString(updateAt)).append("\n");
    sb.append("    vendorCode: ").append(toIndentedString(vendorCode)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    nmID: ").append(toIndentedString(nmID)).append("\n");
    sb.append("    imtID: ").append(toIndentedString(imtID)).append("\n");
    sb.append("    objectID: ").append(toIndentedString(objectID)).append("\n");
    sb.append("    isProhibited: ").append(toIndentedString(isProhibited)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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

