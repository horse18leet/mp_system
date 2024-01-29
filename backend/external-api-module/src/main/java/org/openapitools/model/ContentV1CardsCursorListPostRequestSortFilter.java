package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ContentV1CardsCursorListPostRequestSortFilter
 */

@JsonTypeName("_content_v1_cards_cursor_list_post_request_sort_filter")
public class ContentV1CardsCursorListPostRequestSortFilter {

  @JsonProperty("textSearch")
  private Integer textSearch;

  @JsonProperty("tagIDs")
  @Valid
  private List<Integer> tagIDs = null;

  @JsonProperty("withPhoto")
  private Integer withPhoto;

  @JsonProperty("allowedCategoriesOnly")
  private Boolean allowedCategoriesOnly;

  public ContentV1CardsCursorListPostRequestSortFilter textSearch(Integer textSearch) {
    this.textSearch = textSearch;
    return this;
  }

  /**
   * Поиск по артикулу WB, артикулу продавца, баркоду
   * @return textSearch
  */
  
  @Schema(name = "textSearch", description = "Поиск по артикулу WB, артикулу продавца, баркоду", required = false)
  public Integer getTextSearch() {
    return textSearch;
  }

  public void setTextSearch(Integer textSearch) {
    this.textSearch = textSearch;
  }

  public ContentV1CardsCursorListPostRequestSortFilter tagIDs(List<Integer> tagIDs) {
    this.tagIDs = tagIDs;
    return this;
  }

  public ContentV1CardsCursorListPostRequestSortFilter addTagIDsItem(Integer tagIDsItem) {
    if (this.tagIDs == null) {
      this.tagIDs = new ArrayList<>();
    }
    this.tagIDs.add(tagIDsItem);
    return this;
  }

  /**
   * Поиск по ID тега.
   * @return tagIDs
  */
  
  @Schema(name = "tagIDs", description = "Поиск по ID тега.", required = false)
  public List<Integer> getTagIDs() {
    return tagIDs;
  }

  public void setTagIDs(List<Integer> tagIDs) {
    this.tagIDs = tagIDs;
  }

  public ContentV1CardsCursorListPostRequestSortFilter withPhoto(Integer withPhoto) {
    this.withPhoto = withPhoto;
    return this;
  }

  /**
   * `-1` - Показать все КТ. <br>`0` - Показать КТ без фото. <br>`1` - Показать КТ с фото. 
   * @return withPhoto
  */
  
  @Schema(name = "withPhoto", example = "-1", description = "`-1` - Показать все КТ. <br>`0` - Показать КТ без фото. <br>`1` - Показать КТ с фото. ", required = false)
  public Integer getWithPhoto() {
    return withPhoto;
  }

  public void setWithPhoto(Integer withPhoto) {
    this.withPhoto = withPhoto;
  }

  public ContentV1CardsCursorListPostRequestSortFilter allowedCategoriesOnly(Boolean allowedCategoriesOnly) {
    this.allowedCategoriesOnly = allowedCategoriesOnly;
    return this;
  }

  /**
   * <code>true</code> - показать КТ только из разрешенных к реализации категорий<br> <code>false</code> - показать КТ из всех категорий 
   * @return allowedCategoriesOnly
  */
  
  @Schema(name = "allowedCategoriesOnly", description = "<code>true</code> - показать КТ только из разрешенных к реализации категорий<br> <code>false</code> - показать КТ из всех категорий ", required = false)
  public Boolean getAllowedCategoriesOnly() {
    return allowedCategoriesOnly;
  }

  public void setAllowedCategoriesOnly(Boolean allowedCategoriesOnly) {
    this.allowedCategoriesOnly = allowedCategoriesOnly;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsCursorListPostRequestSortFilter contentV1CardsCursorListPostRequestSortFilter = (ContentV1CardsCursorListPostRequestSortFilter) o;
    return Objects.equals(this.textSearch, contentV1CardsCursorListPostRequestSortFilter.textSearch) &&
        Objects.equals(this.tagIDs, contentV1CardsCursorListPostRequestSortFilter.tagIDs) &&
        Objects.equals(this.withPhoto, contentV1CardsCursorListPostRequestSortFilter.withPhoto) &&
        Objects.equals(this.allowedCategoriesOnly, contentV1CardsCursorListPostRequestSortFilter.allowedCategoriesOnly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(textSearch, tagIDs, withPhoto, allowedCategoriesOnly);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsCursorListPostRequestSortFilter {\n");
    sb.append("    textSearch: ").append(toIndentedString(textSearch)).append("\n");
    sb.append("    tagIDs: ").append(toIndentedString(tagIDs)).append("\n");
    sb.append("    withPhoto: ").append(toIndentedString(withPhoto)).append("\n");
    sb.append("    allowedCategoriesOnly: ").append(toIndentedString(allowedCategoriesOnly)).append("\n");
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

