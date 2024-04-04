package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ContentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner
 */

@JsonTypeName("_content_v1_cards_trash_list_post_200_response_data_cards_inner_sizes_inner")
public class ContentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner {

  @JsonProperty("skus")
  @Valid
  private List<String> skus = null;

  @JsonProperty("techSize")
  private String techSize;

  @JsonProperty("wbSize")
  private String wbSize;

  @JsonProperty("price")
  private Integer price;

  public ContentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner skus(List<String> skus) {
    this.skus = skus;
    return this;
  }

  public ContentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner addSkusItem(String skusItem) {
    if (this.skus == null) {
      this.skus = new ArrayList<>();
    }
    this.skus.add(skusItem);
    return this;
  }

  /**
   * Массив баркодов, строковых идентификаторов размеров товара (их можно сгенерировать с помощью API, см. Viewer)
   * @return skus
  */
  
  @Schema(name = "skus", description = "Массив баркодов, строковых идентификаторов размеров товара (их можно сгенерировать с помощью API, см. Viewer)", required = false)
  public List<String> getSkus() {
    return skus;
  }

  public void setSkus(List<String> skus) {
    this.skus = skus;
  }

  public ContentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner techSize(String techSize) {
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

  public ContentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner wbSize(String wbSize) {
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

  public ContentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner price(Integer price) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner contentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner = (ContentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner) o;
    return Objects.equals(this.skus, contentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner.skus) &&
        Objects.equals(this.techSize, contentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner.techSize) &&
        Objects.equals(this.wbSize, contentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner.wbSize) &&
        Objects.equals(this.price, contentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(skus, techSize, wbSize, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsTrashListPost200ResponseDataCardsInnerSizesInner {\n");
    sb.append("    skus: ").append(toIndentedString(skus)).append("\n");
    sb.append("    techSize: ").append(toIndentedString(techSize)).append("\n");
    sb.append("    wbSize: ").append(toIndentedString(wbSize)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

