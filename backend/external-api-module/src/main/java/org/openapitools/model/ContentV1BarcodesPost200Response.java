package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ContentV1BarcodesPost200Response
 */

@JsonTypeName("_content_v1_barcodes_post_200_response")
public class ContentV1BarcodesPost200Response {

  @JsonProperty("data")
  @Valid
  private List<String> data = null;

  @JsonProperty("error")
  private Boolean error;

  @JsonProperty("errorText")
  private String errorText;

  @JsonProperty("additionalErrors")
  private String additionalErrors;

  public ContentV1BarcodesPost200Response data(List<String> data) {
    this.data = data;
    return this;
  }

  public ContentV1BarcodesPost200Response addDataItem(String dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Массив сгенерированых баркодов
   * @return data
  */
  
  @Schema(name = "data", description = "Массив сгенерированых баркодов", required = false)
  public List<String> getData() {
    return data;
  }

  public void setData(List<String> data) {
    this.data = data;
  }

  public ContentV1BarcodesPost200Response error(Boolean error) {
    this.error = error;
    return this;
  }

  /**
   * Флаг ошибки.
   * @return error
  */
  
  @Schema(name = "error", example = "false", description = "Флаг ошибки.", required = false)
  public Boolean getError() {
    return error;
  }

  public void setError(Boolean error) {
    this.error = error;
  }

  public ContentV1BarcodesPost200Response errorText(String errorText) {
    this.errorText = errorText;
    return this;
  }

  /**
   * Описание ошибки.
   * @return errorText
  */
  
  @Schema(name = "errorText", example = "", description = "Описание ошибки.", required = false)
  public String getErrorText() {
    return errorText;
  }

  public void setErrorText(String errorText) {
    this.errorText = errorText;
  }

  public ContentV1BarcodesPost200Response additionalErrors(String additionalErrors) {
    this.additionalErrors = additionalErrors;
    return this;
  }

  /**
   * Дополнительные ошибки.
   * @return additionalErrors
  */
  
  @Schema(name = "additionalErrors", example = "", description = "Дополнительные ошибки.", required = false)
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
    ContentV1BarcodesPost200Response contentV1BarcodesPost200Response = (ContentV1BarcodesPost200Response) o;
    return Objects.equals(this.data, contentV1BarcodesPost200Response.data) &&
        Objects.equals(this.error, contentV1BarcodesPost200Response.error) &&
        Objects.equals(this.errorText, contentV1BarcodesPost200Response.errorText) &&
        Objects.equals(this.additionalErrors, contentV1BarcodesPost200Response.additionalErrors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, error, errorText, additionalErrors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1BarcodesPost200Response {\n");
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

