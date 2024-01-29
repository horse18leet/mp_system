package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * ContentV1TagsGet200Response
 */

@JsonTypeName("_content_v1_tags_get_200_response")
public class ContentV1TagsGet200Response {

  @JsonProperty("data")
  private ContentV1TagsGet200ResponseData data;

  @JsonProperty("error")
  private Boolean error;

  @JsonProperty("errorText")
  private String errorText;

  @JsonProperty("additionalErrors")
  private String additionalErrors;

  public ContentV1TagsGet200Response data(ContentV1TagsGet200ResponseData data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @Valid
  @Schema(name = "data", required = false)
  public ContentV1TagsGet200ResponseData getData() {
    return data;
  }

  public void setData(ContentV1TagsGet200ResponseData data) {
    this.data = data;
  }

  public ContentV1TagsGet200Response error(Boolean error) {
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

  public ContentV1TagsGet200Response errorText(String errorText) {
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

  public ContentV1TagsGet200Response additionalErrors(String additionalErrors) {
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
    ContentV1TagsGet200Response contentV1TagsGet200Response = (ContentV1TagsGet200Response) o;
    return Objects.equals(this.data, contentV1TagsGet200Response.data) &&
        Objects.equals(this.error, contentV1TagsGet200Response.error) &&
        Objects.equals(this.errorText, contentV1TagsGet200Response.errorText) &&
        Objects.equals(this.additionalErrors, contentV1TagsGet200Response.additionalErrors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, error, errorText, additionalErrors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1TagsGet200Response {\n");
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

