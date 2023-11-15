package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.model.ContentV1CardsCursorListPostRequestSortCursor;
import org.openapitools.model.ContentV1CardsCursorListPostRequestSortFilter;
import org.openapitools.model.ContentV1CardsCursorListPostRequestSortSort;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ContentV1CardsCursorListPostRequestSort
 */

@JsonTypeName("_content_v1_cards_cursor_list_post_request_sort")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1CardsCursorListPostRequestSort {

  @JsonProperty("cursor")
  private ContentV1CardsCursorListPostRequestSortCursor cursor;

  @JsonProperty("filter")
  private ContentV1CardsCursorListPostRequestSortFilter filter;

  @JsonProperty("sort")
  private ContentV1CardsCursorListPostRequestSortSort sort;

  public ContentV1CardsCursorListPostRequestSort cursor(ContentV1CardsCursorListPostRequestSortCursor cursor) {
    this.cursor = cursor;
    return this;
  }

  /**
   * Get cursor
   * @return cursor
  */
  @Valid 
  @Schema(name = "cursor", required = false)
  public ContentV1CardsCursorListPostRequestSortCursor getCursor() {
    return cursor;
  }

  public void setCursor(ContentV1CardsCursorListPostRequestSortCursor cursor) {
    this.cursor = cursor;
  }

  public ContentV1CardsCursorListPostRequestSort filter(ContentV1CardsCursorListPostRequestSortFilter filter) {
    this.filter = filter;
    return this;
  }

  /**
   * Get filter
   * @return filter
  */
  @Valid 
  @Schema(name = "filter", required = false)
  public ContentV1CardsCursorListPostRequestSortFilter getFilter() {
    return filter;
  }

  public void setFilter(ContentV1CardsCursorListPostRequestSortFilter filter) {
    this.filter = filter;
  }

  public ContentV1CardsCursorListPostRequestSort sort(ContentV1CardsCursorListPostRequestSortSort sort) {
    this.sort = sort;
    return this;
  }

  /**
   * Get sort
   * @return sort
  */
  @Valid 
  @Schema(name = "sort", required = false)
  public ContentV1CardsCursorListPostRequestSortSort getSort() {
    return sort;
  }

  public void setSort(ContentV1CardsCursorListPostRequestSortSort sort) {
    this.sort = sort;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsCursorListPostRequestSort contentV1CardsCursorListPostRequestSort = (ContentV1CardsCursorListPostRequestSort) o;
    return Objects.equals(this.cursor, contentV1CardsCursorListPostRequestSort.cursor) &&
        Objects.equals(this.filter, contentV1CardsCursorListPostRequestSort.filter) &&
        Objects.equals(this.sort, contentV1CardsCursorListPostRequestSort.sort);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cursor, filter, sort);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsCursorListPostRequestSort {\n");
    sb.append("    cursor: ").append(toIndentedString(cursor)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
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

