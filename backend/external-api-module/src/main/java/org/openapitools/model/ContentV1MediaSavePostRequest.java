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
 * ContentV1MediaSavePostRequest
 */

@JsonTypeName("_content_v1_media_save_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ContentV1MediaSavePostRequest {

  @JsonProperty("vendorCode")
  private String vendorCode;

  @JsonProperty("data")
  @Valid
  private List<String> data = null;

  public ContentV1MediaSavePostRequest vendorCode(String vendorCode) {
    this.vendorCode = vendorCode;
    return this;
  }

  /**
   * Артикул продавца
   * @return vendorCode
  */
  
  @Schema(name = "vendorCode", example = "6000000001", description = "Артикул продавца", required = false)
  public String getVendorCode() {
    return vendorCode;
  }

  public void setVendorCode(String vendorCode) {
    this.vendorCode = vendorCode;
  }

  public ContentV1MediaSavePostRequest data(List<String> data) {
    this.data = data;
    return this;
  }

  public ContentV1MediaSavePostRequest addDataItem(String dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Ссылки на изображения в том порядке, в котором мы хотим их увидеть в карточке товара.
   * @return data
  */
  
  @Schema(name = "data", description = "Ссылки на изображения в том порядке, в котором мы хотим их увидеть в карточке товара.", required = false)
  public List<String> getData() {
    return data;
  }

  public void setData(List<String> data) {
    this.data = data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1MediaSavePostRequest contentV1MediaSavePostRequest = (ContentV1MediaSavePostRequest) o;
    return Objects.equals(this.vendorCode, contentV1MediaSavePostRequest.vendorCode) &&
        Objects.equals(this.data, contentV1MediaSavePostRequest.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vendorCode, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1MediaSavePostRequest {\n");
    sb.append("    vendorCode: ").append(toIndentedString(vendorCode)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

