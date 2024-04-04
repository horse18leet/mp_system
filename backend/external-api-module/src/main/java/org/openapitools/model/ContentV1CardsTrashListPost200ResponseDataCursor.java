package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * ContentV1CardsTrashListPost200ResponseDataCursor
 */

@JsonTypeName("_content_v1_cards_trash_list_post_200_response_data_cursor")
public class ContentV1CardsTrashListPost200ResponseDataCursor {

  @JsonProperty("offset")
  private Integer offset;

  @JsonProperty("limit")
  private Integer limit;

  public ContentV1CardsTrashListPost200ResponseDataCursor offset(Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Смещение относительно первой РК
   * @return offset
  */
  
  @Schema(name = "offset", description = "Смещение относительно первой РК", required = false)
  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public ContentV1CardsTrashListPost200ResponseDataCursor limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Кол-во запрашиваемых КТ
   * @return limit
  */
  
  @Schema(name = "limit", description = "Кол-во запрашиваемых КТ", required = false)
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
    ContentV1CardsTrashListPost200ResponseDataCursor contentV1CardsTrashListPost200ResponseDataCursor = (ContentV1CardsTrashListPost200ResponseDataCursor) o;
    return Objects.equals(this.offset, contentV1CardsTrashListPost200ResponseDataCursor.offset) &&
        Objects.equals(this.limit, contentV1CardsTrashListPost200ResponseDataCursor.limit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offset, limit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsTrashListPost200ResponseDataCursor {\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
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

