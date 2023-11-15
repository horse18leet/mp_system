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
 * ResponseCardCreateAdditionalErrorsOneOf
 */

@JsonTypeName("responseCardCreate_additionalErrors_oneOf")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ResponseCardCreateAdditionalErrorsOneOf implements ResponseCardCreateAdditionalErrors {

  @JsonProperty("string")
  private String string;

  public ResponseCardCreateAdditionalErrorsOneOf string(String string) {
    this.string = string;
    return this;
  }

  /**
   * Get string
   * @return string
  */
  
  @Schema(name = "string", required = false)
  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseCardCreateAdditionalErrorsOneOf responseCardCreateAdditionalErrorsOneOf = (ResponseCardCreateAdditionalErrorsOneOf) o;
    return Objects.equals(this.string, responseCardCreateAdditionalErrorsOneOf.string);
  }

  @Override
  public int hashCode() {
    return Objects.hash(string);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseCardCreateAdditionalErrorsOneOf {\n");
    sb.append("    string: ").append(toIndentedString(string)).append("\n");
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

