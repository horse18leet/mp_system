package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.ContentV1CardsFilterPost200ResponseDataInnerDimensions;
import org.openapitools.model.ContentV1CardsFilterPost200ResponseDataInnerSizesInner;
import org.openapitools.model.ContentV1CardsFilterPost200ResponseDataInnerTagsInner;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ContentV1CardsFilterPost200ResponseDataInner
 */

@JsonTypeName("_content_v1_cards_filter_post_200_response_data_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1CardsFilterPost200ResponseDataInner {

  @JsonProperty("imtID")
  private Integer imtID;

  @JsonProperty("object")
  private String _object;

  @JsonProperty("objectID")
  private Integer objectID;

  @JsonProperty("nmID")
  private Integer nmID;

  @JsonProperty("vendorCode")
  private String vendorCode;

  @JsonProperty("isProhibited")
  private Boolean isProhibited;

  @JsonProperty("tags")
  @Valid
  private List<ContentV1CardsFilterPost200ResponseDataInnerTagsInner> tags = null;

  @JsonProperty("mediaFiles")
  @Valid
  private List<String> mediaFiles = null;

  @JsonProperty("dimensions")
  private ContentV1CardsFilterPost200ResponseDataInnerDimensions dimensions;

  @JsonProperty("sizes")
  @Valid
  private List<ContentV1CardsFilterPost200ResponseDataInnerSizesInner> sizes = null;

  @JsonProperty("characteristics")
  @Valid
  private List<Object> characteristics = null;

  public ContentV1CardsFilterPost200ResponseDataInner imtID(Integer imtID) {
    this.imtID = imtID;
    return this;
  }

  /**
   * Идентификатор карточки товара (нужен для группирования НМ в одно КТ)
   * @return imtID
  */
  
  @Schema(name = "imtID", description = "Идентификатор карточки товара (нужен для группирования НМ в одно КТ)", required = false)
  public Integer getImtID() {
    return imtID;
  }

  public void setImtID(Integer imtID) {
    this.imtID = imtID;
  }

  public ContentV1CardsFilterPost200ResponseDataInner _object(String _object) {
    this._object = _object;
    return this;
  }

  /**
   * Предмет
   * @return _object
  */
  
  @Schema(name = "object", description = "Предмет", required = false)
  public String getObject() {
    return _object;
  }

  public void setObject(String _object) {
    this._object = _object;
  }

  public ContentV1CardsFilterPost200ResponseDataInner objectID(Integer objectID) {
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

  public ContentV1CardsFilterPost200ResponseDataInner nmID(Integer nmID) {
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

  public ContentV1CardsFilterPost200ResponseDataInner vendorCode(String vendorCode) {
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

  public ContentV1CardsFilterPost200ResponseDataInner isProhibited(Boolean isProhibited) {
    this.isProhibited = isProhibited;
    return this;
  }

  /**
   * `true` - категория карточки запрещена к реализации<br> `false` категория карточки разрешена к реализации 
   * @return isProhibited
  */
  
  @Schema(name = "isProhibited", description = "`true` - категория карточки запрещена к реализации<br> `false` категория карточки разрешена к реализации ", required = false)
  public Boolean getIsProhibited() {
    return isProhibited;
  }

  public void setIsProhibited(Boolean isProhibited) {
    this.isProhibited = isProhibited;
  }

  public ContentV1CardsFilterPost200ResponseDataInner tags(List<ContentV1CardsFilterPost200ResponseDataInnerTagsInner> tags) {
    this.tags = tags;
    return this;
  }

  public ContentV1CardsFilterPost200ResponseDataInner addTagsItem(ContentV1CardsFilterPost200ResponseDataInnerTagsInner tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Массив с информацией о тегах. Поле будет в ответе при наличии тегов в КТ.
   * @return tags
  */
  @Valid 
  @Schema(name = "tags", description = "Массив с информацией о тегах. Поле будет в ответе при наличии тегов в КТ.", required = false)
  public List<ContentV1CardsFilterPost200ResponseDataInnerTagsInner> getTags() {
    return tags;
  }

  public void setTags(List<ContentV1CardsFilterPost200ResponseDataInnerTagsInner> tags) {
    this.tags = tags;
  }

  public ContentV1CardsFilterPost200ResponseDataInner mediaFiles(List<String> mediaFiles) {
    this.mediaFiles = mediaFiles;
    return this;
  }

  public ContentV1CardsFilterPost200ResponseDataInner addMediaFilesItem(String mediaFilesItem) {
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

  public ContentV1CardsFilterPost200ResponseDataInner dimensions(ContentV1CardsFilterPost200ResponseDataInnerDimensions dimensions) {
    this.dimensions = dimensions;
    return this;
  }

  /**
   * Get dimensions
   * @return dimensions
  */
  @Valid 
  @Schema(name = "dimensions", required = false)
  public ContentV1CardsFilterPost200ResponseDataInnerDimensions getDimensions() {
    return dimensions;
  }

  public void setDimensions(ContentV1CardsFilterPost200ResponseDataInnerDimensions dimensions) {
    this.dimensions = dimensions;
  }

  public ContentV1CardsFilterPost200ResponseDataInner sizes(List<ContentV1CardsFilterPost200ResponseDataInnerSizesInner> sizes) {
    this.sizes = sizes;
    return this;
  }

  public ContentV1CardsFilterPost200ResponseDataInner addSizesItem(ContentV1CardsFilterPost200ResponseDataInnerSizesInner sizesItem) {
    if (this.sizes == null) {
      this.sizes = new ArrayList<>();
    }
    this.sizes.add(sizesItem);
    return this;
  }

  /**
   * Get sizes
   * @return sizes
  */
  @Valid 
  @Schema(name = "sizes", required = false)
  public List<ContentV1CardsFilterPost200ResponseDataInnerSizesInner> getSizes() {
    return sizes;
  }

  public void setSizes(List<ContentV1CardsFilterPost200ResponseDataInnerSizesInner> sizes) {
    this.sizes = sizes;
  }

  public ContentV1CardsFilterPost200ResponseDataInner characteristics(List<Object> characteristics) {
    this.characteristics = characteristics;
    return this;
  }

  public ContentV1CardsFilterPost200ResponseDataInner addCharacteristicsItem(Object characteristicsItem) {
    if (this.characteristics == null) {
      this.characteristics = new ArrayList<>();
    }
    this.characteristics.add(characteristicsItem);
    return this;
  }

  /**
   * Массив характеристик, индивидуальный для каждой категории
   * @return characteristics
  */
  
  @Schema(name = "characteristics", description = "Массив характеристик, индивидуальный для каждой категории", required = false)
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
    ContentV1CardsFilterPost200ResponseDataInner contentV1CardsFilterPost200ResponseDataInner = (ContentV1CardsFilterPost200ResponseDataInner) o;
    return Objects.equals(this.imtID, contentV1CardsFilterPost200ResponseDataInner.imtID) &&
        Objects.equals(this._object, contentV1CardsFilterPost200ResponseDataInner._object) &&
        Objects.equals(this.objectID, contentV1CardsFilterPost200ResponseDataInner.objectID) &&
        Objects.equals(this.nmID, contentV1CardsFilterPost200ResponseDataInner.nmID) &&
        Objects.equals(this.vendorCode, contentV1CardsFilterPost200ResponseDataInner.vendorCode) &&
        Objects.equals(this.isProhibited, contentV1CardsFilterPost200ResponseDataInner.isProhibited) &&
        Objects.equals(this.tags, contentV1CardsFilterPost200ResponseDataInner.tags) &&
        Objects.equals(this.mediaFiles, contentV1CardsFilterPost200ResponseDataInner.mediaFiles) &&
        Objects.equals(this.dimensions, contentV1CardsFilterPost200ResponseDataInner.dimensions) &&
        Objects.equals(this.sizes, contentV1CardsFilterPost200ResponseDataInner.sizes) &&
        Objects.equals(this.characteristics, contentV1CardsFilterPost200ResponseDataInner.characteristics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imtID, _object, objectID, nmID, vendorCode, isProhibited, tags, mediaFiles, dimensions, sizes, characteristics);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsFilterPost200ResponseDataInner {\n");
    sb.append("    imtID: ").append(toIndentedString(imtID)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    objectID: ").append(toIndentedString(objectID)).append("\n");
    sb.append("    nmID: ").append(toIndentedString(nmID)).append("\n");
    sb.append("    vendorCode: ").append(toIndentedString(vendorCode)).append("\n");
    sb.append("    isProhibited: ").append(toIndentedString(isProhibited)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    mediaFiles: ").append(toIndentedString(mediaFiles)).append("\n");
    sb.append("    dimensions: ").append(toIndentedString(dimensions)).append("\n");
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

