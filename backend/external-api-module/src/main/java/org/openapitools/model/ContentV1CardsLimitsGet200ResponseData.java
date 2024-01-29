package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * ContentV1CardsLimitsGet200ResponseData
 */

@JsonTypeName("_content_v1_cards_limits_get_200_response_data")
public class ContentV1CardsLimitsGet200ResponseData {

  @JsonProperty("freeLimits")
  private Integer freeLimits;

  @JsonProperty("paidLimits")
  private Integer paidLimits;

  public ContentV1CardsLimitsGet200ResponseData freeLimits(Integer freeLimits) {
    this.freeLimits = freeLimits;
    return this;
  }

  /**
   * Количество бесплатных лимитов
   * @return freeLimits
  */
  
  @Schema(name = "freeLimits", description = "Количество бесплатных лимитов", required = false)
  public Integer getFreeLimits() {
    return freeLimits;
  }

  public void setFreeLimits(Integer freeLimits) {
    this.freeLimits = freeLimits;
  }

  public ContentV1CardsLimitsGet200ResponseData paidLimits(Integer paidLimits) {
    this.paidLimits = paidLimits;
    return this;
  }

  /**
   * Количество оплаченных лимитов
   * @return paidLimits
  */
  
  @Schema(name = "paidLimits", description = "Количество оплаченных лимитов", required = false)
  public Integer getPaidLimits() {
    return paidLimits;
  }

  public void setPaidLimits(Integer paidLimits) {
    this.paidLimits = paidLimits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsLimitsGet200ResponseData contentV1CardsLimitsGet200ResponseData = (ContentV1CardsLimitsGet200ResponseData) o;
    return Objects.equals(this.freeLimits, contentV1CardsLimitsGet200ResponseData.freeLimits) &&
        Objects.equals(this.paidLimits, contentV1CardsLimitsGet200ResponseData.paidLimits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(freeLimits, paidLimits);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsLimitsGet200ResponseData {\n");
    sb.append("    freeLimits: ").append(toIndentedString(freeLimits)).append("\n");
    sb.append("    paidLimits: ").append(toIndentedString(paidLimits)).append("\n");
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

