package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ContentV1CardsUpdatePostRequestInnerSizesInner
 */

@JsonTypeName("_content_v1_cards_update_post_request_inner_sizes_inner")
public class ContentV1CardsUpdatePostRequestInnerSizesInner {

  @JsonProperty("techSize")
  private String techSize;

  @JsonProperty("chrtID")
  private Integer chrtID;

  @JsonProperty("wbSize")
  private String wbSize;

  @JsonProperty("skus")
  @Valid
  private List<String> skus = new ArrayList<>();

  public ContentV1CardsUpdatePostRequestInnerSizesInner techSize(String techSize) {
    this.techSize = techSize;
    return this;
  }

  /**
   * Размер товара (пример S, M, L, XL, 42, 42-43)
   * @return techSize
  */
  
  @Schema(name = "techSize", example = "40-41", description = "Размер товара (пример S, M, L, XL, 42, 42-43)", required = false)
  public String getTechSize() {
    return techSize;
  }

  public void setTechSize(String techSize) {
    this.techSize = techSize;
  }

  public ContentV1CardsUpdatePostRequestInnerSizesInner chrtID(Integer chrtID) {
    this.chrtID = chrtID;
    return this;
  }

  /**
   * Числовой идентификатор размера для данной номенклатуры Wildberries<br> Обязателен к заполнению для существующих размеров.<br> Для добавляемых размеров не указывается. 
   * @return chrtID
  */
  @NotNull
  @Schema(name = "chrtID", example = "116108635", description = "Числовой идентификатор размера для данной номенклатуры Wildberries<br> Обязателен к заполнению для существующих размеров.<br> Для добавляемых размеров не указывается. ", required = true)
  public Integer getChrtID() {
    return chrtID;
  }

  public void setChrtID(Integer chrtID) {
    this.chrtID = chrtID;
  }

  public ContentV1CardsUpdatePostRequestInnerSizesInner wbSize(String wbSize) {
    this.wbSize = wbSize;
    return this;
  }

  /**
   * Российский размер товара
   * @return wbSize
  */
  
  @Schema(name = "wbSize", example = "40-41", description = "Российский размер товара", required = false)
  public String getWbSize() {
    return wbSize;
  }

  public void setWbSize(String wbSize) {
    this.wbSize = wbSize;
  }

  public ContentV1CardsUpdatePostRequestInnerSizesInner skus(List<String> skus) {
    this.skus = skus;
    return this;
  }

  public ContentV1CardsUpdatePostRequestInnerSizesInner addSkusItem(String skusItem) {
    this.skus.add(skusItem);
    return this;
  }

  /**
   * Массив баркодов, строковых идентификаторов размеров товара (их можно сгенерировать с помощью API, см. раздел \"Просмотр\")
   * @return skus
  */
  @NotNull 
  @Schema(name = "skus", description = "Массив баркодов, строковых идентификаторов размеров товара (их можно сгенерировать с помощью API, см. раздел \"Просмотр\")", required = true)
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
    ContentV1CardsUpdatePostRequestInnerSizesInner contentV1CardsUpdatePostRequestInnerSizesInner = (ContentV1CardsUpdatePostRequestInnerSizesInner) o;
    return Objects.equals(this.techSize, contentV1CardsUpdatePostRequestInnerSizesInner.techSize) &&
        Objects.equals(this.chrtID, contentV1CardsUpdatePostRequestInnerSizesInner.chrtID) &&
        Objects.equals(this.wbSize, contentV1CardsUpdatePostRequestInnerSizesInner.wbSize) &&
        Objects.equals(this.skus, contentV1CardsUpdatePostRequestInnerSizesInner.skus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(techSize, chrtID, wbSize, skus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsUpdatePostRequestInnerSizesInner {\n");
    sb.append("    techSize: ").append(toIndentedString(techSize)).append("\n");
    sb.append("    chrtID: ").append(toIndentedString(chrtID)).append("\n");
    sb.append("    wbSize: ").append(toIndentedString(wbSize)).append("\n");
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

