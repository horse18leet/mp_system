package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * Дополнительные ошибки
 */

@Schema(name = "responseBodyContentError400_additionalErrors", description = "Дополнительные ошибки")
@JsonTypeName("responseBodyContentError400_additionalErrors")
public class ResponseBodyContentError400AdditionalErrors {

  @JsonProperty("MoveNmsToTrash")
  private String moveNmsToTrash;

  public ResponseBodyContentError400AdditionalErrors moveNmsToTrash(String moveNmsToTrash) {
    this.moveNmsToTrash = moveNmsToTrash;
    return this;
  }

  /**
   * Get moveNmsToTrash
   * @return moveNmsToTrash
  */
  
  @Schema(name = "MoveNmsToTrash", required = false)
  public String getMoveNmsToTrash() {
    return moveNmsToTrash;
  }

  public void setMoveNmsToTrash(String moveNmsToTrash) {
    this.moveNmsToTrash = moveNmsToTrash;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseBodyContentError400AdditionalErrors responseBodyContentError400AdditionalErrors = (ResponseBodyContentError400AdditionalErrors) o;
    return Objects.equals(this.moveNmsToTrash, responseBodyContentError400AdditionalErrors.moveNmsToTrash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(moveNmsToTrash);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseBodyContentError400AdditionalErrors {\n");
    sb.append("    moveNmsToTrash: ").append(toIndentedString(moveNmsToTrash)).append("\n");
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

