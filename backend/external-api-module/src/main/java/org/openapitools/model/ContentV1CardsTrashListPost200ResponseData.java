package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ContentV1CardsTrashListPost200ResponseData
 */

@JsonTypeName("_content_v1_cards_trash_list_post_200_response_data")
public class ContentV1CardsTrashListPost200ResponseData {

  @JsonProperty("cards")
  @Valid
  private List<ContentV1CardsTrashListPost200ResponseDataCardsInner> cards = null;

  @JsonProperty("cursor")
  private ContentV1CardsTrashListPost200ResponseDataCursor cursor;

  public ContentV1CardsTrashListPost200ResponseData cards(List<ContentV1CardsTrashListPost200ResponseDataCardsInner> cards) {
    this.cards = cards;
    return this;
  }

  public ContentV1CardsTrashListPost200ResponseData addCardsItem(ContentV1CardsTrashListPost200ResponseDataCardsInner cardsItem) {
    if (this.cards == null) {
      this.cards = new ArrayList<>();
    }
    this.cards.add(cardsItem);
    return this;
  }

  /**
   * Список запрашиваемых КТ
   * @return cards
  */
  @Valid 
  @Schema(name = "cards", description = "Список запрашиваемых КТ", required = false)
  public List<ContentV1CardsTrashListPost200ResponseDataCardsInner> getCards() {
    return cards;
  }

  public void setCards(List<ContentV1CardsTrashListPost200ResponseDataCardsInner> cards) {
    this.cards = cards;
  }

  public ContentV1CardsTrashListPost200ResponseData cursor(ContentV1CardsTrashListPost200ResponseDataCursor cursor) {
    this.cursor = cursor;
    return this;
  }

  /**
   * Get cursor
   * @return cursor
  */
  @Valid 
  @Schema(name = "cursor", required = false)
  public ContentV1CardsTrashListPost200ResponseDataCursor getCursor() {
    return cursor;
  }

  public void setCursor(ContentV1CardsTrashListPost200ResponseDataCursor cursor) {
    this.cursor = cursor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsTrashListPost200ResponseData contentV1CardsTrashListPost200ResponseData = (ContentV1CardsTrashListPost200ResponseData) o;
    return Objects.equals(this.cards, contentV1CardsTrashListPost200ResponseData.cards) &&
        Objects.equals(this.cursor, contentV1CardsTrashListPost200ResponseData.cursor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cards, cursor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsTrashListPost200ResponseData {\n");
    sb.append("    cards: ").append(toIndentedString(cards)).append("\n");
    sb.append("    cursor: ").append(toIndentedString(cursor)).append("\n");
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

