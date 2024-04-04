package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * ContentV1CardsCursorListPostRequestSortCursor
 */

@JsonTypeName("_content_v1_cards_cursor_list_post_request_sort_cursor")
public class ContentV1CardsCursorListPostRequestSortCursor {

  @JsonProperty("updatedAt")
  private String updatedAt;

  @JsonProperty("nmID")
  private Integer nmID;

  @JsonProperty("limit")
  private Integer limit;

  public ContentV1CardsCursorListPostRequestSortCursor updatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Время обновления последней КТ из предыдущего ответа на запрос списка КТ.
   * @return updatedAt
  */
  
  @Schema(name = "updatedAt", example = "2022-09-23T17:41:32Z", description = "Время обновления последней КТ из предыдущего ответа на запрос списка КТ.", required = false)
  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public ContentV1CardsCursorListPostRequestSortCursor nmID(Integer nmID) {
    this.nmID = nmID;
    return this;
  }

  /**
   * Артикул WB последней КТ из предыдущего ответа на запрос списка КТ.
   * @return nmID
  */
  
  @Schema(name = "nmID", example = "66965444", description = "Артикул WB последней КТ из предыдущего ответа на запрос списка КТ.", required = false)
  public Integer getNmID() {
    return nmID;
  }

  public void setNmID(Integer nmID) {
    this.nmID = nmID;
  }

  public ContentV1CardsCursorListPostRequestSortCursor limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Кол-во запрашиваемых КТ.
   * @return limit
  */
  
  @Schema(name = "limit", example = "1000", description = "Кол-во запрашиваемых КТ.", required = false)
  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsCursorListPostRequestSortCursor contentV1CardsCursorListPostRequestSortCursor = (ContentV1CardsCursorListPostRequestSortCursor) o;
    return Objects.equals(this.updatedAt, contentV1CardsCursorListPostRequestSortCursor.updatedAt) &&
        Objects.equals(this.nmID, contentV1CardsCursorListPostRequestSortCursor.nmID) &&
        Objects.equals(this.limit, contentV1CardsCursorListPostRequestSortCursor.limit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(updatedAt, nmID, limit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsCursorListPostRequestSortCursor {\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    nmID: ").append(toIndentedString(nmID)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
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

