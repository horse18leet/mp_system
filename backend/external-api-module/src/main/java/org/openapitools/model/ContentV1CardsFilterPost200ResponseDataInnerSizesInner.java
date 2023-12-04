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
 * ContentV1CardsFilterPost200ResponseDataInnerSizesInner
 */

@JsonTypeName("_content_v1_cards_filter_post_200_response_data_inner_sizes_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1CardsFilterPost200ResponseDataInnerSizesInner {

  @JsonProperty("techSize")
  private String techSize;

  @JsonProperty("wbSize")
  private String wbSize;

  @JsonProperty("price")
  private Integer price;

  @JsonProperty("chrtID")
  private Integer chrtID;

  @JsonProperty("skus")
  @Valid
  private List<String> skus = null;

  public ContentV1CardsFilterPost200ResponseDataInnerSizesInner techSize(String techSize) {
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

  public ContentV1CardsFilterPost200ResponseDataInnerSizesInner wbSize(String wbSize) {
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

  public ContentV1CardsFilterPost200ResponseDataInnerSizesInner price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * Цена, `неактивно`, для уточнения цены используйте метод \"Получение информации о ценах\" раздел документации Цены. 
   * @return price
  */
  
  @Schema(name = "price", description = "Цена, `неактивно`, для уточнения цены используйте метод \"Получение информации о ценах\" раздел документации Цены. ", required = false)
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public ContentV1CardsFilterPost200ResponseDataInnerSizesInner chrtID(Integer chrtID) {
    this.chrtID = chrtID;
    return this;
  }

  /**
   * Числовой идентификатор размера для данной номенклатуры Wildberries
   * @return chrtID
  */
  
  @Schema(name = "chrtID", description = "Числовой идентификатор размера для данной номенклатуры Wildberries", required = false)
  public Integer getChrtID() {
    return chrtID;
  }

  public void setChrtID(Integer chrtID) {
    this.chrtID = chrtID;
  }

  public ContentV1CardsFilterPost200ResponseDataInnerSizesInner skus(List<String> skus) {
    this.skus = skus;
    return this;
  }

  public ContentV1CardsFilterPost200ResponseDataInnerSizesInner addSkusItem(String skusItem) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsFilterPost200ResponseDataInnerSizesInner contentV1CardsFilterPost200ResponseDataInnerSizesInner = (ContentV1CardsFilterPost200ResponseDataInnerSizesInner) o;
    return Objects.equals(this.techSize, contentV1CardsFilterPost200ResponseDataInnerSizesInner.techSize) &&
        Objects.equals(this.wbSize, contentV1CardsFilterPost200ResponseDataInnerSizesInner.wbSize) &&
        Objects.equals(this.price, contentV1CardsFilterPost200ResponseDataInnerSizesInner.price) &&
        Objects.equals(this.chrtID, contentV1CardsFilterPost200ResponseDataInnerSizesInner.chrtID) &&
        Objects.equals(this.skus, contentV1CardsFilterPost200ResponseDataInnerSizesInner.skus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(techSize, wbSize, price, chrtID, skus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsFilterPost200ResponseDataInnerSizesInner {\n");
    sb.append("    techSize: ").append(toIndentedString(techSize)).append("\n");
    sb.append("    wbSize: ").append(toIndentedString(wbSize)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    chrtID: ").append(toIndentedString(chrtID)).append("\n");
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

