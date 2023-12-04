package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.CreatingCardInnerInnerSizesInner;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CreatingCardInnerInner
 */

@JsonTypeName("creatingCard_inner_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class CreatingCardInnerInner {

  @JsonProperty("characteristics")
  @Valid
  private List<Object> characteristics = null;

  @JsonProperty("vendorCode")
  private String vendorCode;

  @JsonProperty("sizes")
  @Valid
  private List<CreatingCardInnerInnerSizesInner> sizes = null;

  public CreatingCardInnerInner characteristics(List<Object> characteristics) {
    this.characteristics = characteristics;
    return this;
  }

  public CreatingCardInnerInner addCharacteristicsItem(Object characteristicsItem) {
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

  public CreatingCardInnerInner vendorCode(String vendorCode) {
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

  public CreatingCardInnerInner sizes(List<CreatingCardInnerInnerSizesInner> sizes) {
    this.sizes = sizes;
    return this;
  }

  public CreatingCardInnerInner addSizesItem(CreatingCardInnerInnerSizesInner sizesItem) {
    if (this.sizes == null) {
      this.sizes = new ArrayList<>();
    }
    this.sizes.add(sizesItem);
    return this;
  }

  /**
   * Массив размеров для номенклатуры (для безразмерного товара все равно нужно передавать данный массив без параметров (`wbSize` и `techSize`), но с ценой и баркодом)
   * @return sizes
  */
  @Valid 
  @Schema(name = "sizes", description = "Массив размеров для номенклатуры (для безразмерного товара все равно нужно передавать данный массив без параметров (`wbSize` и `techSize`), но с ценой и баркодом)", required = false)
  public List<CreatingCardInnerInnerSizesInner> getSizes() {
    return sizes;
  }

  public void setSizes(List<CreatingCardInnerInnerSizesInner> sizes) {
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
    CreatingCardInnerInner creatingCardInnerInner = (CreatingCardInnerInner) o;
    return Objects.equals(this.characteristics, creatingCardInnerInner.characteristics) &&
        Objects.equals(this.vendorCode, creatingCardInnerInner.vendorCode) &&
        Objects.equals(this.sizes, creatingCardInnerInner.sizes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(characteristics, vendorCode, sizes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatingCardInnerInner {\n");
    sb.append("    characteristics: ").append(toIndentedString(characteristics)).append("\n");
    sb.append("    vendorCode: ").append(toIndentedString(vendorCode)).append("\n");
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

