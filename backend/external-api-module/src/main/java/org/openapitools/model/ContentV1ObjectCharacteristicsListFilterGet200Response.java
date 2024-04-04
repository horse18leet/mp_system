package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ContentV1ObjectCharacteristicsListFilterGet200Response
 */

@JsonTypeName("_content_v1_object_characteristics_list_filter_get_200_response")
public class ContentV1ObjectCharacteristicsListFilterGet200Response {

  @JsonProperty("data")
  @Valid
  private List<ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner> data = null;

  @JsonProperty("error")
  private Boolean error;

  @JsonProperty("errorText")
  private String errorText;

  @JsonProperty("additionalErrors")
  private String additionalErrors;

  public ContentV1ObjectCharacteristicsListFilterGet200Response data(List<ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner> data) {
    this.data = data;
    return this;
  }

  public ContentV1ObjectCharacteristicsListFilterGet200Response addDataItem(ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @Valid 
  @Schema(name = "data", required = false)
  public List<ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner> getData() {
    return data;
  }

  public void setData(List<ContentV1ObjectCharacteristicsListFilterGet200ResponseDataInner> data) {
    this.data = data;
  }

  public ContentV1ObjectCharacteristicsListFilterGet200Response error(Boolean error) {
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

  public ContentV1ObjectCharacteristicsListFilterGet200Response errorText(String errorText) {
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

  public ContentV1ObjectCharacteristicsListFilterGet200Response additionalErrors(String additionalErrors) {
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
    ContentV1ObjectCharacteristicsListFilterGet200Response contentV1ObjectCharacteristicsListFilterGet200Response = (ContentV1ObjectCharacteristicsListFilterGet200Response) o;
    return Objects.equals(this.data, contentV1ObjectCharacteristicsListFilterGet200Response.data) &&
        Objects.equals(this.error, contentV1ObjectCharacteristicsListFilterGet200Response.error) &&
        Objects.equals(this.errorText, contentV1ObjectCharacteristicsListFilterGet200Response.errorText) &&
        Objects.equals(this.additionalErrors, contentV1ObjectCharacteristicsListFilterGet200Response.additionalErrors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, error, errorText, additionalErrors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1ObjectCharacteristicsListFilterGet200Response {\n");
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

