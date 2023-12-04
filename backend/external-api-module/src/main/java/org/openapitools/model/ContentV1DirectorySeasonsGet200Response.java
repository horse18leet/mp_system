package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ContentV1DirectorySeasonsGet200Response
 */

@JsonTypeName("_content_v1_directory_seasons_get_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1DirectorySeasonsGet200Response {

  @JsonProperty("data")
  @Valid
  private List<String> data = null;

  @JsonProperty("error")
  private Boolean error;

  @JsonProperty("errorText")
  private String errorText;

  @JsonProperty("additionalErrors")
  private String additionalErrors;

  public ContentV1DirectorySeasonsGet200Response data(List<String> data) {
    this.data = data;
    return this;
  }

  public ContentV1DirectorySeasonsGet200Response addDataItem(String dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Массив значений для хар-ки Сезон
   * @return data
  */
  
  @Schema(name = "data", description = "Массив значений для хар-ки Сезон", required = false)
  public List<String> getData() {
    return data;
  }

  public void setData(List<String> data) {
    this.data = data;
  }

  public ContentV1DirectorySeasonsGet200Response error(Boolean error) {
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

  public ContentV1DirectorySeasonsGet200Response errorText(String errorText) {
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

  public ContentV1DirectorySeasonsGet200Response additionalErrors(String additionalErrors) {
    this.additionalErrors = additionalErrors;
    return this;
  }

  /**
   * Дополнительные ошибки
   * @return additionalErrors
  */
  
  @Schema(name = "additionalErrors", example = "", description = "Дополнительные ошибки", required = false)
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
    ContentV1DirectorySeasonsGet200Response contentV1DirectorySeasonsGet200Response = (ContentV1DirectorySeasonsGet200Response) o;
    return Objects.equals(this.data, contentV1DirectorySeasonsGet200Response.data) &&
        Objects.equals(this.error, contentV1DirectorySeasonsGet200Response.error) &&
        Objects.equals(this.errorText, contentV1DirectorySeasonsGet200Response.errorText) &&
        Objects.equals(this.additionalErrors, contentV1DirectorySeasonsGet200Response.additionalErrors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, error, errorText, additionalErrors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1DirectorySeasonsGet200Response {\n");
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

