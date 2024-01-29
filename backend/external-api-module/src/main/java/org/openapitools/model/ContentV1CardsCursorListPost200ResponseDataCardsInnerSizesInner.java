package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ContentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner
 */

@JsonTypeName("_content_v1_cards_cursor_list_post_200_response_data_cards_inner_sizes_inner")
public class ContentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner {

  @JsonProperty("techSize")
  private String techSize;

  @JsonProperty("skus")
  @Valid
  private List<String> skus = null;

  @JsonProperty("chrtID")
  private Integer chrtID;

  public ContentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner techSize(String techSize) {
    this.techSize = techSize;
    return this;
  }

  /**
   * Размер товара (пример S, M, L, XL, 42, 42-43)
   * @return techSize
  */
  
  @Schema(name = "techSize", example = "0", description = "Размер товара (пример S, M, L, XL, 42, 42-43)", required = false)
  public String getTechSize() {
    return techSize;
  }

  public void setTechSize(String techSize) {
    this.techSize = techSize;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner skus(List<String> skus) {
    this.skus = skus;
    return this;
  }

  public ContentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner addSkusItem(String skusItem) {
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

  public ContentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner chrtID(Integer chrtID) {
    this.chrtID = chrtID;
    return this;
  }

  /**
   * Числовой идентификатор размера для данной номенклатуры Wildberries
   * @return chrtID
  */
  
  @Schema(name = "chrtID", example = "116108635", description = "Числовой идентификатор размера для данной номенклатуры Wildberries", required = false)
  public Integer getChrtID() {
    return chrtID;
  }

  public void setChrtID(Integer chrtID) {
    this.chrtID = chrtID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner contentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner = (ContentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner) o;
    return Objects.equals(this.techSize, contentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner.techSize) &&
        Objects.equals(this.skus, contentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner.skus) &&
        Objects.equals(this.chrtID, contentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner.chrtID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(techSize, skus, chrtID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsCursorListPost200ResponseDataCardsInnerSizesInner {\n");
    sb.append("    techSize: ").append(toIndentedString(techSize)).append("\n");
    sb.append("    skus: ").append(toIndentedString(skus)).append("\n");
    sb.append("    chrtID: ").append(toIndentedString(chrtID)).append("\n");
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

