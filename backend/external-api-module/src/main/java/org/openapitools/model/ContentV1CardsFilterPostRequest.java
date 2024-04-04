package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ContentV1CardsFilterPostRequest
 */

@JsonTypeName("_content_v1_cards_filter_post_request")
public class ContentV1CardsFilterPostRequest {

  @JsonProperty("vendorCodes")
  @Valid
  private List<String> vendorCodes = null;

  @JsonProperty("allowedCategoriesOnly")
  private Boolean allowedCategoriesOnly;

  public ContentV1CardsFilterPostRequest vendorCodes(List<String> vendorCodes) {
    this.vendorCodes = vendorCodes;
    return this;
  }

  public ContentV1CardsFilterPostRequest addVendorCodesItem(String vendorCodesItem) {
    if (this.vendorCodes == null) {
      this.vendorCodes = new ArrayList<>();
    }
    this.vendorCodes.add(vendorCodesItem);
    return this;
  }

  /**
   * Массив  артикулов продавца. <br>Максимальное количество в запросе `100`. 
   * @return vendorCodes
  */
  
  @Schema(name = "vendorCodes", description = "Массив  артикулов продавца. <br>Максимальное количество в запросе `100`. ", required = false)
  public List<String> getVendorCodes() {
    return vendorCodes;
  }

  public void setVendorCodes(List<String> vendorCodes) {
    this.vendorCodes = vendorCodes;
  }

  public ContentV1CardsFilterPostRequest allowedCategoriesOnly(Boolean allowedCategoriesOnly) {
    this.allowedCategoriesOnly = allowedCategoriesOnly;
    return this;
  }

  /**
   * <code>true</code> - показать КТ только из разрешенных к реализации категорий<br> <code>false</code> - показать КТ из всех категорий 
   * @return allowedCategoriesOnly
  */
  
  @Schema(name = "allowedCategoriesOnly", description = "<code>true</code> - показать КТ только из разрешенных к реализации категорий<br> <code>false</code> - показать КТ из всех категорий ", required = false)
  public Boolean getAllowedCategoriesOnly() {
    return allowedCategoriesOnly;
  }

  public void setAllowedCategoriesOnly(Boolean allowedCategoriesOnly) {
    this.allowedCategoriesOnly = allowedCategoriesOnly;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsFilterPostRequest contentV1CardsFilterPostRequest = (ContentV1CardsFilterPostRequest) o;
    return Objects.equals(this.vendorCodes, contentV1CardsFilterPostRequest.vendorCodes) &&
        Objects.equals(this.allowedCategoriesOnly, contentV1CardsFilterPostRequest.allowedCategoriesOnly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vendorCodes, allowedCategoriesOnly);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsFilterPostRequest {\n");
    sb.append("    vendorCodes: ").append(toIndentedString(vendorCodes)).append("\n");
    sb.append("    allowedCategoriesOnly: ").append(toIndentedString(allowedCategoriesOnly)).append("\n");
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

