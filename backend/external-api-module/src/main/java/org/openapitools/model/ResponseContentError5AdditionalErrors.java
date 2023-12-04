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
 * Дополнительные ошибки
 */

@Schema(name = "responseContentError5_additionalErrors", description = "Дополнительные ошибки")
@JsonTypeName("responseContentError5_additionalErrors")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
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

