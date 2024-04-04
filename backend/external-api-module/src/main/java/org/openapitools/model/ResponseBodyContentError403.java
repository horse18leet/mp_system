package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import org.openapitools.jackson.nullable.JsonNullable;

import java.util.Arrays;
import java.util.Objects;

/**
 * ResponseBodyContentError403
 */

@JsonTypeName("responseBodyContentError403")
public class ResponseBodyContentError403 {

  @JsonProperty("data")
  private JsonNullable<Object> data = JsonNullable.undefined();

  @JsonProperty("error")
  private Boolean error;

  @JsonProperty("errorText")
  private String errorText;

  @JsonProperty("additionalErrors")
  private String additionalErrors;

  public ResponseBodyContentError403 data(Object data) {
    this.data = JsonNullable.of(data);
    return this;
  }

  /**
   * Get data
   * @return data
  */
  
  @Schema(name = "data", required = false)
  public JsonNullable<Object> getData() {
    return data;
  }

  public void setData(JsonNullable<Object> data) {
    this.data = data;
  }

  public ResponseBodyContentError403 error(Boolean error) {
    this.error = error;
    return this;
  }

  /**
   * Флаг ошибки
   * @return error
  */
  
  @Schema(name = "error", description = "Флаг ошибки", required = false)
  public Boolean getError() {
    return error;
  }

  public void setError(Boolean error) {
    this.error = error;
  }

  public ResponseBodyContentError403 errorText(String errorText) {
    this.errorText = errorText;
    return this;
  }

  /**
   * Описание ошибки
   * @return errorText
  */
  
  @Schema(name = "errorText", description = "Описание ошибки", required = false)
  public String getErrorText() {
    return errorText;
  }

  public void setErrorText(String errorText) {
    this.errorText = errorText;
  }

  public ResponseBodyContentError403 additionalErrors(String additionalErrors) {
    this.additionalErrors = additionalErrors;
    return this;
  }

  /**
   * Дополнительные ошибки
   * @return additionalErrors
  */
  
  @Schema(name = "additionalErrors", description = "Дополнительные ошибки", required = false)
  public String getAdditionalErrors() {
    return additionalErrors;
  }

  public void setAdditionalErrors(String additionalErrors) {
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
    ResponseBodyContentError403 responseBodyContentError403 = (ResponseBodyContentError403) o;
    return Objects.equals(this.data, responseBodyContentError403.data) &&
        Objects.equals(this.error, responseBodyContentError403.error) &&
        Objects.equals(this.errorText, responseBodyContentError403.errorText) &&
        Objects.equals(this.additionalErrors, responseBodyContentError403.additionalErrors);
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
    sb.append("class ResponseBodyContentError403 {\n");
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

