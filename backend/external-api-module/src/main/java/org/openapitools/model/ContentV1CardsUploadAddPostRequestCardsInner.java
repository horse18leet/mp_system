package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.ContentV1CardsUploadAddPostRequestCardsInnerSizesInner;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ContentV1CardsUploadAddPostRequestCardsInner
 */

@JsonTypeName("_content_v1_cards_upload_add_post_request_cards_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1CardsUploadAddPostRequestCardsInner {

  @JsonProperty("vendorCode")
  private String vendorCode;

  @JsonProperty("characteristics")
  @Valid
  private List<Object> characteristics = null;

  @JsonProperty("sizes")
  @Valid
  private List<ContentV1CardsUploadAddPostRequestCardsInnerSizesInner> sizes = null;

  public ContentV1CardsUploadAddPostRequestCardsInner vendorCode(String vendorCode) {
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

  public ContentV1CardsUploadAddPostRequestCardsInner characteristics(List<Object> characteristics) {
    this.characteristics = characteristics;
    return this;
  }

  public ContentV1CardsUploadAddPostRequestCardsInner addCharacteristicsItem(Object characteristicsItem) {
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

  public ContentV1CardsUploadAddPostRequestCardsInner sizes(List<ContentV1CardsUploadAddPostRequestCardsInnerSizesInner> sizes) {
    this.sizes = sizes;
    return this;
  }

  public ContentV1CardsUploadAddPostRequestCardsInner addSizesItem(ContentV1CardsUploadAddPostRequestCardsInnerSizesInner sizesItem) {
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
  public List<ContentV1CardsUploadAddPostRequestCardsInnerSizesInner> getSizes() {
    return sizes;
  }

  public void setSizes(List<ContentV1CardsUploadAddPostRequestCardsInnerSizesInner> sizes) {
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
    ContentV1CardsUploadAddPostRequestCardsInner contentV1CardsUploadAddPostRequestCardsInner = (ContentV1CardsUploadAddPostRequestCardsInner) o;
    return Objects.equals(this.vendorCode, contentV1CardsUploadAddPostRequestCardsInner.vendorCode) &&
        Objects.equals(this.characteristics, contentV1CardsUploadAddPostRequestCardsInner.characteristics) &&
        Objects.equals(this.sizes, contentV1CardsUploadAddPostRequestCardsInner.sizes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vendorCode, characteristics, sizes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsUploadAddPostRequestCardsInner {\n");
    sb.append("    vendorCode: ").append(toIndentedString(vendorCode)).append("\n");
    sb.append("    characteristics: ").append(toIndentedString(characteristics)).append("\n");
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

