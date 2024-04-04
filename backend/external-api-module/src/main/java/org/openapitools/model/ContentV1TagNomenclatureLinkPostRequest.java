package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ContentV1TagNomenclatureLinkPostRequest
 */

@JsonTypeName("_content_v1_tag_nomenclature_link_post_request")
public class ContentV1TagNomenclatureLinkPostRequest {

  @JsonProperty("nmID")
  private Integer nmID;

  @JsonProperty("tagsIDs")
  @Valid
  private List<Integer> tagsIDs = null;

  public ContentV1TagNomenclatureLinkPostRequest nmID(Integer nmID) {
    this.nmID = nmID;
    return this;
  }

  /**
   * Артикул WB
   * @return nmID
  */
  
  @Schema(name = "nmID", description = "Артикул WB", required = false)
  public Integer getNmID() {
    return nmID;
  }

  public void setNmID(Integer nmID) {
    this.nmID = nmID;
  }

  public ContentV1TagNomenclatureLinkPostRequest tagsIDs(List<Integer> tagsIDs) {
    this.tagsIDs = tagsIDs;
    return this;
  }

  public ContentV1TagNomenclatureLinkPostRequest addTagsIDsItem(Integer tagsIDsItem) {
    if (this.tagsIDs == null) {
      this.tagsIDs = new ArrayList<>();
    }
    this.tagsIDs.add(tagsIDsItem);
    return this;
  }

  /**
   * Массив числовых идентификаторов тегов.<br>   Что бы снять теги с КТ, необходимо передать пустой массив.<br> Чтобы добавить теги к уже имеющимся в КТ, необходимо в запросе передать новые теги и теги, которые уже есть в КТ. 
   * @return tagsIDs
  */
  
  @Schema(name = "tagsIDs", description = "Массив числовых идентификаторов тегов.<br>   Что бы снять теги с КТ, необходимо передать пустой массив.<br> Чтобы добавить теги к уже имеющимся в КТ, необходимо в запросе передать новые теги и теги, которые уже есть в КТ. ", required = false)
  public List<Integer> getTagsIDs() {
    return tagsIDs;
  }

  public void setTagsIDs(List<Integer> tagsIDs) {
    this.tagsIDs = tagsIDs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1TagNomenclatureLinkPostRequest contentV1TagNomenclatureLinkPostRequest = (ContentV1TagNomenclatureLinkPostRequest) o;
    return Objects.equals(this.nmID, contentV1TagNomenclatureLinkPostRequest.nmID) &&
        Objects.equals(this.tagsIDs, contentV1TagNomenclatureLinkPostRequest.tagsIDs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nmID, tagsIDs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1TagNomenclatureLinkPostRequest {\n");
    sb.append("    nmID: ").append(toIndentedString(nmID)).append("\n");
    sb.append("    tagsIDs: ").append(toIndentedString(tagsIDs)).append("\n");
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

