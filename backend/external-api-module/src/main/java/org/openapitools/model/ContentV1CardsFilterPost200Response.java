package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.openapitools.jackson.nullable.JsonNullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * ContentV1CardsFilterPost200Response
 */

@JsonTypeName("_content_v1_cards_filter_post_200_response")
public class ContentV1CardsFilterPost200Response {

  @JsonProperty("data")
  @Valid
  private List<ContentV1CardsFilterPost200ResponseDataInner> data = null;

  @JsonProperty("error")
  private Boolean error;

  @JsonProperty("errorText")
  private String errorText;

  @JsonProperty("additionalErrors")
  private JsonNullable<String> additionalErrors = JsonNullable.undefined();

  public ContentV1CardsFilterPost200Response data(List<ContentV1CardsFilterPost200ResponseDataInner> data) {
    this.data = data;
    return this;
  }

  public ContentV1CardsFilterPost200Response addDataItem(ContentV1CardsFilterPost200ResponseDataInner dataItem) {
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
  public List<ContentV1CardsFilterPost200ResponseDataInner> getData() {
    return data;
  }

  public void setData(List<ContentV1CardsFilterPost200ResponseDataInner> data) {
    this.data = data;
  }

  public ContentV1CardsFilterPost200Response error(Boolean error) {
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

  public ContentV1CardsFilterPost200Response errorText(String errorText) {
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

  public ContentV1CardsFilterPost200Response additionalErrors(String additionalErrors) {
    this.additionalErrors = JsonNullable.of(additionalErrors);
    return this;
  }

  /**
   * Дополнительные ошибки.
   * @return additionalErrors
  */
  
  @Schema(name = "additionalErrors", description = "Дополнительные ошибки.", required = false)
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
    ContentV1CardsFilterPost200Response contentV1CardsFilterPost200Response = (ContentV1CardsFilterPost200Response) o;
    return Objects.equals(this.data, contentV1CardsFilterPost200Response.data) &&
        Objects.equals(this.error, contentV1CardsFilterPost200Response.error) &&
        Objects.equals(this.errorText, contentV1CardsFilterPost200Response.errorText) &&
        Objects.equals(this.additionalErrors, contentV1CardsFilterPost200Response.additionalErrors);
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
    sb.append("class ContentV1CardsFilterPost200Response {\n");
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

