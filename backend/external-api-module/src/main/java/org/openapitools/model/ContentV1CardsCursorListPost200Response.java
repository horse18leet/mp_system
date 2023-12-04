package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.Arrays;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.model.ContentV1CardsCursorListPost200ResponseData;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ContentV1CardsCursorListPost200Response
 */

@JsonTypeName("_content_v1_cards_cursor_list_post_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1CardsCursorListPost200Response {

  @JsonProperty("data")
  private ContentV1CardsCursorListPost200ResponseData data;

  @JsonProperty("error")
  private Boolean error;

  @JsonProperty("errorText")
  private String errorText;

  @JsonProperty("additionalErrors")
  private JsonNullable<String> additionalErrors = JsonNullable.undefined();

  public ContentV1CardsCursorListPost200Response data(ContentV1CardsCursorListPost200ResponseData data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @Valid 
  @Schema(name = "data", required = false)
  public ContentV1CardsCursorListPost200ResponseData getData() {
    return data;
  }

  public void setData(ContentV1CardsCursorListPost200ResponseData data) {
    this.data = data;
  }

  public ContentV1CardsCursorListPost200Response error(Boolean error) {
    this.error = error;
    return this;
  }

  /**
   * Флаг ошибки
   * @return error
  */
  
  @Schema(name = "error", example = "false", description = "Флаг ошибки", required = false)
  public Boolean getError() {
    return error;
  }

  public void setError(Boolean error) {
    this.error = error;
  }

  public ContentV1CardsCursorListPost200Response errorText(String errorText) {
    this.errorText = errorText;
    return this;
  }

  /**
   * Описание ошибки
   * @return errorText
  */
  
  @Schema(name = "errorText", example = "", description = "Описание ошибки", required = false)
  public String getErrorText() {
    return errorText;
  }

  public void setErrorText(String errorText) {
    this.errorText = errorText;
  }

  public ContentV1CardsCursorListPost200Response additionalErrors(String additionalErrors) {
    this.additionalErrors = JsonNullable.of(additionalErrors);
    return this;
  }

  /**
   * Дополнительные ошибки
   * @return additionalErrors
  */
  
  @Schema(name = "additionalErrors", description = "Дополнительные ошибки", required = false)
  public JsonNullable<String> getAdditionalErrors() {
    return additionalErrors;
  }

  public void setAdditionalErrors(JsonNullable<String> additionalErrors) {
    this.additionalErrors = additionalErrors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsCursorListPost200Response contentV1CardsCursorListPost200Response = (ContentV1CardsCursorListPost200Response) o;
    return Objects.equals(this.data, contentV1CardsCursorListPost200Response.data) &&
        Objects.equals(this.error, contentV1CardsCursorListPost200Response.error) &&
        Objects.equals(this.errorText, contentV1CardsCursorListPost200Response.errorText) &&
        Objects.equals(this.additionalErrors, contentV1CardsCursorListPost200Response.additionalErrors);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, error, errorText, additionalErrors);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsCursorListPost200Response {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    errorText: ").append(toIndentedString(errorText)).append("\n");
    sb.append("    additionalErrors: ").append(toIndentedString(additionalErrors)).append("\n");
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

