package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.model.ContentV1CardsCursorListPostRequestSort;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ContentV1CardsCursorListPostRequest
 */

@JsonTypeName("_content_v1_cards_cursor_list_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1CardsCursorListPostRequest {

  @JsonProperty("sort")
  private ContentV1CardsCursorListPostRequestSort sort;

  public ContentV1CardsCursorListPostRequest sort(ContentV1CardsCursorListPostRequestSort sort) {
    this.sort = sort;
    return this;
  }

  /**
   * Get sort
   * @return sort
  */
  @Valid 
  @Schema(name = "sort", required = false)
  public ContentV1CardsCursorListPostRequestSort getSort() {
    return sort;
  }

  public void setSort(ContentV1CardsCursorListPostRequestSort sort) {
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
    ContentV1CardsCursorListPostRequest contentV1CardsCursorListPostRequest = (ContentV1CardsCursorListPostRequest) o;
    return Objects.equals(this.sort, contentV1CardsCursorListPostRequest.sort);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sort);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsCursorListPostRequest {\n");
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

