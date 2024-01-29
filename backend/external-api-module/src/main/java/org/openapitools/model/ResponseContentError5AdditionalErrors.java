package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * Дополнительные ошибки
 */

@Schema(name = "responseContentError5_additionalErrors", description = "Дополнительные ошибки")
@JsonTypeName("responseContentError5_additionalErrors")
public class ResponseContentError5AdditionalErrors {

  @JsonProperty("tagID")
  private String tagID;

  public ResponseContentError5AdditionalErrors tagID(String tagID) {
    this.tagID = tagID;
    return this;
  }

  /**
   * Get tagID
   * @return tagID
  */
  
  @Schema(name = "tagID", required = false)
  public String getTagID() {
    return tagID;
  }

  public void setTagID(String tagID) {
    this.tagID = tagID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseContentError5AdditionalErrors responseContentError5AdditionalErrors = (ResponseContentError5AdditionalErrors) o;
    return Objects.equals(this.tagID, responseContentError5AdditionalErrors.tagID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tagID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseContentError5AdditionalErrors {\n");
    sb.append("    tagID: ").append(toIndentedString(tagID)).append("\n");
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

