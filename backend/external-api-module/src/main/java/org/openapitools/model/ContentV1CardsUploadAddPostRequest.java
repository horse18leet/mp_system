package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.ContentV1CardsUploadAddPostRequestCardsInner;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ContentV1CardsUploadAddPostRequest
 */

@JsonTypeName("_content_v1_cards_upload_add_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1CardsUploadAddPostRequest {

  @JsonProperty("vendorCode")
  private String vendorCode;

  @JsonProperty("cards")
  @Valid
  private List<ContentV1CardsUploadAddPostRequestCardsInner> cards = null;

  public ContentV1CardsUploadAddPostRequest vendorCode(String vendorCode) {
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

  public ContentV1CardsUploadAddPostRequest cards(List<ContentV1CardsUploadAddPostRequestCardsInner> cards) {
    this.cards = cards;
    return this;
  }

  public ContentV1CardsUploadAddPostRequest addCardsItem(ContentV1CardsUploadAddPostRequestCardsInner cardsItem) {
    if (this.cards == null) {
      this.cards = new ArrayList<>();
    }
    this.cards.add(cardsItem);
    return this;
  }

  /**
   * Массив НМ которые хотим добавить к КТ
   * @return cards
  */
  @Valid 
  @Schema(name = "cards", description = "Массив НМ которые хотим добавить к КТ", required = false)
  public List<ContentV1CardsUploadAddPostRequestCardsInner> getCards() {
    return cards;
  }

  public void setCards(List<ContentV1CardsUploadAddPostRequestCardsInner> cards) {
    this.cards = cards;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsUploadAddPostRequest contentV1CardsUploadAddPostRequest = (ContentV1CardsUploadAddPostRequest) o;
    return Objects.equals(this.vendorCode, contentV1CardsUploadAddPostRequest.vendorCode) &&
        Objects.equals(this.cards, contentV1CardsUploadAddPostRequest.cards);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vendorCode, cards);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsUploadAddPostRequest {\n");
    sb.append("    vendorCode: ").append(toIndentedString(vendorCode)).append("\n");
    sb.append("    cards: ").append(toIndentedString(cards)).append("\n");
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

