package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ContentV1CardsTrashListPost200ResponseDataCardsInner
 */

@JsonTypeName("_content_v1_cards_trash_list_post_200_response_data_cards_inner")
public class ContentV1CardsTrashListPost200ResponseDataCardsInner {

  @JsonProperty("nmID")
  private Integer nmID;

  @JsonProperty("objectID")
  private Integer objectID;

  @JsonProperty("vendorCode")
  private String vendorCode;

  @JsonProperty("object")
  private String _object;

  @JsonProperty("brand")
  private String brand;

  @JsonProperty("updateAt")
  private String updateAt;

  @JsonProperty("colors")
  @Valid
  private List<String> colors = null;

  @JsonProperty("mediaFiles")
  @Valid
  private List<String> mediaFiles = null;

  @JsonProperty("sizes")
  @Valid
  private List<ContentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner> sizes = null;

  public ContentV1CardsTrashListPost200ResponseDataCardsInner nmID(Integer nmID) {
    this.nmID = nmID;
    return this;
  }

  /**
   * Артикул WB
   * @return nmID
  */
  
  @Schema(name = "nmID", description = "Артикул WB", required = false)
  public Integer getNmID() {
    return nmID;
  }

  public void setNmID(Integer nmID) {
    this.nmID = nmID;
  }

  public ContentV1CardsTrashListPost200ResponseDataCardsInner objectID(Integer objectID) {
    this.objectID = objectID;
    return this;
  }

  /**
   * Идентификатор предмета
   * @return objectID
  */
  
  @Schema(name = "objectID", description = "Идентификатор предмета", required = false)
  public Integer getObjectID() {
    return objectID;
  }

  public void setObjectID(Integer objectID) {
    this.objectID = objectID;
  }

  public ContentV1CardsTrashListPost200ResponseDataCardsInner vendorCode(String vendorCode) {
    this.vendorCode = vendorCode;
    return this;
  }

  /**
   * Артикул продавца
   * @return vendorCode
  */
  
  @Schema(name = "vendorCode", description = "Артикул продавца", required = false)
  public String getVendorCode() {
    return vendorCode;
  }

  public void setVendorCode(String vendorCode) {
    this.vendorCode = vendorCode;
  }

  public ContentV1CardsTrashListPost200ResponseDataCardsInner _object(String _object) {
    this._object = _object;
    return this;
  }

  /**
   * Категория для который создавалось КТ с данной НМ
   * @return _object
  */
  
  @Schema(name = "object", description = "Категория для который создавалось КТ с данной НМ", required = false)
  public String getObject() {
    return _object;
  }

  public void setObject(String _object) {
    this._object = _object;
  }

  public ContentV1CardsTrashListPost200ResponseDataCardsInner brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * Брэнд
   * @return brand
  */
  
  @Schema(name = "brand", description = "Брэнд", required = false)
  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public ContentV1CardsTrashListPost200ResponseDataCardsInner updateAt(String updateAt) {
    this.updateAt = updateAt;
    return this;
  }

  /**
   * Дата обновления
   * @return updateAt
  */
  
  @Schema(name = "updateAt", description = "Дата обновления", required = false)
  public String getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(String updateAt) {
    this.updateAt = updateAt;
  }

  public ContentV1CardsTrashListPost200ResponseDataCardsInner colors(List<String> colors) {
    this.colors = colors;
    return this;
  }

  public ContentV1CardsTrashListPost200ResponseDataCardsInner addColorsItem(String colorsItem) {
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

  public ContentV1CardsTrashListPost200ResponseDataCardsInner mediaFiles(List<String> mediaFiles) {
    this.mediaFiles = mediaFiles;
    return this;
  }

  public ContentV1CardsTrashListPost200ResponseDataCardsInner addMediaFilesItem(String mediaFilesItem) {
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

  public ContentV1CardsTrashListPost200ResponseDataCardsInner sizes(List<ContentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner> sizes) {
    this.sizes = sizes;
    return this;
  }

  public ContentV1CardsTrashListPost200ResponseDataCardsInner addSizesItem(ContentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner sizesItem) {
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
  public List<ContentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner> getSizes() {
    return sizes;
  }

  public void setSizes(List<ContentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner> sizes) {
    this.sizes = sizes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsTrashListPost200ResponseDataCardsInner contentV1CardsTrashListPost200ResponseDataCardsInner = (ContentV1CardsTrashListPost200ResponseDataCardsInner) o;
    return Objects.equals(this.nmID, contentV1CardsTrashListPost200ResponseDataCardsInner.nmID) &&
        Objects.equals(this.objectID, contentV1CardsTrashListPost200ResponseDataCardsInner.objectID) &&
        Objects.equals(this.vendorCode, contentV1CardsTrashListPost200ResponseDataCardsInner.vendorCode) &&
        Objects.equals(this._object, contentV1CardsTrashListPost200ResponseDataCardsInner._object) &&
        Objects.equals(this.brand, contentV1CardsTrashListPost200ResponseDataCardsInner.brand) &&
        Objects.equals(this.updateAt, contentV1CardsTrashListPost200ResponseDataCardsInner.updateAt) &&
        Objects.equals(this.colors, contentV1CardsTrashListPost200ResponseDataCardsInner.colors) &&
        Objects.equals(this.mediaFiles, contentV1CardsTrashListPost200ResponseDataCardsInner.mediaFiles) &&
        Objects.equals(this.sizes, contentV1CardsTrashListPost200ResponseDataCardsInner.sizes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nmID, objectID, vendorCode, _object, brand, updateAt, colors, mediaFiles, sizes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsTrashListPost200ResponseDataCardsInner {\n");
    sb.append("    nmID: ").append(toIndentedString(nmID)).append("\n");
    sb.append("    objectID: ").append(toIndentedString(objectID)).append("\n");
    sb.append("    vendorCode: ").append(toIndentedString(vendorCode)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    updateAt: ").append(toIndentedString(updateAt)).append("\n");
    sb.append("    colors: ").append(toIndentedString(colors)).append("\n");
    sb.append("    mediaFiles: ").append(toIndentedString(mediaFiles)).append("\n");
    sb.append("    sizes: ").append(toIndentedString(sizes)).append("\n");
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

