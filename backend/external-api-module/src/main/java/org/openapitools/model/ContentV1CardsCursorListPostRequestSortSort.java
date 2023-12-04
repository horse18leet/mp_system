package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ContentV1CardsCursorListPostRequestSortSort
 */

@JsonTypeName("_content_v1_cards_cursor_list_post_request_sort_sort")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1CardsCursorListPostRequestSortSort {

  @JsonProperty("sortColumn")
  private String sortColumn;

  @JsonProperty("ascending")
  private Boolean ascending;

  public ContentV1CardsCursorListPostRequestSortSort sortColumn(String sortColumn) {
    this.sortColumn = sortColumn;
    return this;
  }

  /**
   * Поле, по которому будет сортироваться список КТ (пока поддерживается только updateAt).
   * @return sortColumn
  */
  
  @Schema(name = "sortColumn", example = "updateAt", description = "Поле, по которому будет сортироваться список КТ (пока поддерживается только updateAt).", required = false)
  public String getSortColumn() {
    return sortColumn;
  }

  public void setSortColumn(String sortColumn) {
    this.sortColumn = sortColumn;
  }

  public ContentV1CardsCursorListPostRequestSortSort ascending(Boolean ascending) {
    this.ascending = ascending;
    return this;
  }

  /**
   * Тип сортировки.
   * @return ascending
  */
  
  @Schema(name = "ascending", example = "false", description = "Тип сортировки.", required = false)
  public Boolean getAscending() {
    return ascending;
  }

  public void setAscending(Boolean ascending) {
    this.ascending = ascending;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsCursorListPostRequestSortSort contentV1CardsCursorListPostRequestSortSort = (ContentV1CardsCursorListPostRequestSortSort) o;
    return Objects.equals(this.sortColumn, contentV1CardsCursorListPostRequestSortSort.sortColumn) &&
        Objects.equals(this.ascending, contentV1CardsCursorListPostRequestSortSort.ascending);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sortColumn, ascending);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsCursorListPostRequestSortSort {\n");
    sb.append("    sortColumn: ").append(toIndentedString(sortColumn)).append("\n");
    sb.append("    ascending: ").append(toIndentedString(ascending)).append("\n");
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

