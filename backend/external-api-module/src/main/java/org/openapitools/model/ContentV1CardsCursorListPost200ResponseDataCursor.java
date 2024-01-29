package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * ContentV1CardsCursorListPost200ResponseDataCursor
 */

@JsonTypeName("_content_v1_cards_cursor_list_post_200_response_data_cursor")
public class ContentV1CardsCursorListPost200ResponseDataCursor {

  @JsonProperty("updatedAt")
  private String updatedAt;

  @JsonProperty("nmID")
  private Integer nmID;

  @JsonProperty("total")
  private Integer total;

  public ContentV1CardsCursorListPost200ResponseDataCursor updatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Дата с которой надо запрашивать следующий список КТ
   * @return updatedAt
  */
  
  @Schema(name = "updatedAt", example = "2022-08-10T10:16:52Z", description = "Дата с которой надо запрашивать следующий список КТ", required = false)
  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public ContentV1CardsCursorListPost200ResponseDataCursor nmID(Integer nmID) {
    this.nmID = nmID;
    return this;
  }

  /**
   * Номер Артикула WB с которой надо запрашивтаь следующий список КТ
   * @return nmID
  */
  
  @Schema(name = "nmID", example = "66964167", description = "Номер Артикула WB с которой надо запрашивтаь следующий список КТ", required = false)
  public Integer getNmID() {
    return nmID;
  }

  public void setNmID(Integer nmID) {
    this.nmID = nmID;
  }

  public ContentV1CardsCursorListPost200ResponseDataCursor total(Integer total) {
    this.total = total;
    return this;
  }

  /**
   * Кол-во возвращенных КТ
   * @return total
  */
  
  @Schema(name = "total", example = "1", description = "Кол-во возвращенных КТ", required = false)
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsCursorListPost200ResponseDataCursor contentV1CardsCursorListPost200ResponseDataCursor = (ContentV1CardsCursorListPost200ResponseDataCursor) o;
    return Objects.equals(this.updatedAt, contentV1CardsCursorListPost200ResponseDataCursor.updatedAt) &&
        Objects.equals(this.nmID, contentV1CardsCursorListPost200ResponseDataCursor.nmID) &&
        Objects.equals(this.total, contentV1CardsCursorListPost200ResponseDataCursor.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(updatedAt, nmID, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsCursorListPost200ResponseDataCursor {\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    nmID: ").append(toIndentedString(nmID)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

