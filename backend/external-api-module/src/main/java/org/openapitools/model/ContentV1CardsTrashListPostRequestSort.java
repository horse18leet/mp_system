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
 * ContentV1CardsTrashListPostRequestSort
 */

@JsonTypeName("_content_v1_cards_trash_list_post_request_sort")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1CardsTrashListPostRequestSort {

  @JsonProperty("sortColumn")
  private String sortColumn;

  @JsonProperty("ascending")
  private Boolean ascending;

  @JsonProperty("searchValue")
  private String searchValue;

  @JsonProperty("offset")
  private Integer offset;

  @JsonProperty("limit")
  private Integer limit;

  public ContentV1CardsTrashListPostRequestSort sortColumn(String sortColumn) {
    this.sortColumn = sortColumn;
    return this;
  }

  /**
   * Поле, по которому будет сортироваться список КТ (пока что поддерживается только `updateAt`) 
   * @return sortColumn
  */
  
  @Schema(name = "sortColumn", description = "Поле, по которому будет сортироваться список КТ (пока что поддерживается только `updateAt`) ", required = false)
  public String getSortColumn() {
    return sortColumn;
  }

  public void setSortColumn(String sortColumn) {
    this.sortColumn = sortColumn;
  }

  public ContentV1CardsTrashListPostRequestSort ascending(Boolean ascending) {
    this.ascending = ascending;
    return this;
  }

  /**
   * Тип сортировки
   * @return ascending
  */
  
  @Schema(name = "ascending", description = "Тип сортировки", required = false)
  public Boolean getAscending() {
    return ascending;
  }

  public void setAscending(Boolean ascending) {
    this.ascending = ascending;
  }

  public ContentV1CardsTrashListPostRequestSort searchValue(String searchValue) {
    this.searchValue = searchValue;
    return this;
  }

  /**
   * Поле, по которому будет осуществляться поиск: по баркоду(`skus`), артикулу продавца (`vendorCode`), артикулу WB (`nmID`) 
   * @return searchValue
  */
  
  @Schema(name = "searchValue", description = "Поле, по которому будет осуществляться поиск: по баркоду(`skus`), артикулу продавца (`vendorCode`), артикулу WB (`nmID`) ", required = false)
  public String getSearchValue() {
    return searchValue;
  }

  public void setSearchValue(String searchValue) {
    this.searchValue = searchValue;
  }

  public ContentV1CardsTrashListPostRequestSort offset(Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * С какого элемента выдавать данные
   * @return offset
  */
  
  @Schema(name = "offset", description = "С какого элемента выдавать данные", required = false)
  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public ContentV1CardsTrashListPostRequestSort limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Кол-во запрашиваемых КТ (max. 1000)
   * @return limit
  */
  
  @Schema(name = "limit", description = "Кол-во запрашиваемых КТ (max. 1000)", required = false)
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
    ContentV1CardsTrashListPostRequestSort contentV1CardsTrashListPostRequestSort = (ContentV1CardsTrashListPostRequestSort) o;
    return Objects.equals(this.sortColumn, contentV1CardsTrashListPostRequestSort.sortColumn) &&
        Objects.equals(this.ascending, contentV1CardsTrashListPostRequestSort.ascending) &&
        Objects.equals(this.searchValue, contentV1CardsTrashListPostRequestSort.searchValue) &&
        Objects.equals(this.offset, contentV1CardsTrashListPostRequestSort.offset) &&
        Objects.equals(this.limit, contentV1CardsTrashListPostRequestSort.limit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sortColumn, ascending, searchValue, offset, limit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsTrashListPostRequestSort {\n");
    sb.append("    sortColumn: ").append(toIndentedString(sortColumn)).append("\n");
    sb.append("    ascending: ").append(toIndentedString(ascending)).append("\n");
    sb.append("    searchValue: ").append(toIndentedString(searchValue)).append("\n");
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

