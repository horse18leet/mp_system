package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.ContentV1CardsCursorListPost200ResponseDataCardsInner;
import org.openapitools.model.ContentV1CardsCursorListPost200ResponseDataCursor;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ContentV1CardsCursorListPost200ResponseData
 */

@JsonTypeName("_content_v1_cards_cursor_list_post_200_response_data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1CardsCursorListPost200ResponseData {

  @JsonProperty("cards")
  @Valid
  private List<ContentV1CardsCursorListPost200ResponseDataCardsInner> cards = null;

  @JsonProperty("cursor")
  private ContentV1CardsCursorListPost200ResponseDataCursor cursor;

  public ContentV1CardsCursorListPost200ResponseData cards(List<ContentV1CardsCursorListPost200ResponseDataCardsInner> cards) {
    this.cards = cards;
    return this;
  }

  public ContentV1CardsCursorListPost200ResponseData addCardsItem(ContentV1CardsCursorListPost200ResponseDataCardsInner cardsItem) {
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
  public List<ContentV1CardsCursorListPost200ResponseDataCardsInner> getCards() {
    return cards;
  }

  public void setCards(List<ContentV1CardsCursorListPost200ResponseDataCardsInner> cards) {
    this.cards = cards;
  }

  public ContentV1CardsCursorListPost200ResponseData cursor(ContentV1CardsCursorListPost200ResponseDataCursor cursor) {
    this.cursor = cursor;
    return this;
  }

  /**
   * Get cursor
   * @return cursor
  */
  @Valid 
  @Schema(name = "cursor", required = false)
  public ContentV1CardsCursorListPost200ResponseDataCursor getCursor() {
    return cursor;
  }

  public void setCursor(ContentV1CardsCursorListPost200ResponseDataCursor cursor) {
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
    ContentV1CardsCursorListPost200ResponseData contentV1CardsCursorListPost200ResponseData = (ContentV1CardsCursorListPost200ResponseData) o;
    return Objects.equals(this.cards, contentV1CardsCursorListPost200ResponseData.cards) &&
        Objects.equals(this.cursor, contentV1CardsCursorListPost200ResponseData.cursor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cards, cursor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsCursorListPost200ResponseData {\n");
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

