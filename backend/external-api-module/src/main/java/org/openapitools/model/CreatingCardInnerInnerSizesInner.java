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
 * CreatingCardInnerInnerSizesInner
 */

@JsonTypeName("creatingCard_inner_inner_sizes_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class CreatingCardInnerInnerSizesInner {

  @JsonProperty("techSize")
  private String techSize;

  @JsonProperty("wbSize")
  private String wbSize;

  @JsonProperty("price")
  private Integer price;

  @JsonProperty("skus")
  @Valid
  private List<String> skus = null;

  public CreatingCardInnerInnerSizesInner techSize(String techSize) {
    this.techSize = techSize;
    return this;
  }

  /**
   * Размер товара (пример S, M, L, XL, 42, 42-43)
   * @return techSize
  */
  
  @Schema(name = "techSize", description = "Размер товара (пример S, M, L, XL, 42, 42-43)", required = false)
  public String getTechSize() {
    return techSize;
  }

  public void setTechSize(String techSize) {
    this.techSize = techSize;
  }

  public CreatingCardInnerInnerSizesInner wbSize(String wbSize) {
    this.wbSize = wbSize;
    return this;
  }

  /**
   * Российский размер товара
   * @return wbSize
  */
  
  @Schema(name = "wbSize", description = "Российский размер товара", required = false)
  public String getWbSize() {
    return wbSize;
  }

  public void setWbSize(String wbSize) {
    this.wbSize = wbSize;
  }

  public CreatingCardInnerInnerSizesInner price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * Цена
   * @return price
  */
  
  @Schema(name = "price", description = "Цена", required = false)
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public CreatingCardInnerInnerSizesInner skus(List<String> skus) {
    this.skus = skus;
    return this;
  }

  public CreatingCardInnerInnerSizesInner addSkusItem(String skusItem) {
    if (this.skus == null) {
      this.skus = new ArrayList<>();
    }
    this.skus.add(skusItem);
    return this;
  }

  /**
   * Массив баркодов, строковых идентификаторов размеров товара (их можно сгенерировать с помощью API, см. раздел \"Просмотр\")
   * @return skus
  */
  
  @Schema(name = "skus", description = "Массив баркодов, строковых идентификаторов размеров товара (их можно сгенерировать с помощью API, см. раздел \"Просмотр\")", required = false)
  public List<String> getSkus() {
    return skus;
  }

  public void setSkus(List<String> skus) {
    this.skus = skus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreatingCardInnerInnerSizesInner creatingCardInnerInnerSizesInner = (CreatingCardInnerInnerSizesInner) o;
    return Objects.equals(this.techSize, creatingCardInnerInnerSizesInner.techSize) &&
        Objects.equals(this.wbSize, creatingCardInnerInnerSizesInner.wbSize) &&
        Objects.equals(this.price, creatingCardInnerInnerSizesInner.price) &&
        Objects.equals(this.skus, creatingCardInnerInnerSizesInner.skus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(techSize, wbSize, price, skus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatingCardInnerInnerSizesInner {\n");
    sb.append("    techSize: ").append(toIndentedString(techSize)).append("\n");
    sb.append("    wbSize: ").append(toIndentedString(wbSize)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    skus: ").append(toIndentedString(skus)).append("\n");
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

