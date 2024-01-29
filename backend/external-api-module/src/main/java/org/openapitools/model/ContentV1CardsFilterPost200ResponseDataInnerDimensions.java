package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * Габариты упаковки, в сантиметрах 
 */

@Schema(name = "_content_v1_cards_filter_post_200_response_data_inner_dimensions", description = "Габариты упаковки, в сантиметрах ")
@JsonTypeName("_content_v1_cards_filter_post_200_response_data_inner_dimensions")
public class ContentV1CardsFilterPost200ResponseDataInnerDimensions {

  @JsonProperty("width")
  private Integer width;

  @JsonProperty("length")
  private Integer length;

  @JsonProperty("height")
  private Integer height;

  public ContentV1CardsFilterPost200ResponseDataInnerDimensions width(Integer width) {
    this.width = width;
    return this;
  }

  /**
   * Ширина
   * @return width
  */
  
  @Schema(name = "width", description = "Ширина", required = false)
  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public ContentV1CardsFilterPost200ResponseDataInnerDimensions length(Integer length) {
    this.length = length;
    return this;
  }

  /**
   * Длина
   * @return length
  */
  
  @Schema(name = "length", description = "Длина", required = false)
  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public ContentV1CardsFilterPost200ResponseDataInnerDimensions height(Integer height) {
    this.height = height;
    return this;
  }

  /**
   * Высота
   * @return height
  */
  
  @Schema(name = "height", description = "Высота", required = false)
  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1CardsFilterPost200ResponseDataInnerDimensions contentV1CardsFilterPost200ResponseDataInnerDimensions = (ContentV1CardsFilterPost200ResponseDataInnerDimensions) o;
    return Objects.equals(this.width, contentV1CardsFilterPost200ResponseDataInnerDimensions.width) &&
        Objects.equals(this.length, contentV1CardsFilterPost200ResponseDataInnerDimensions.length) &&
        Objects.equals(this.height, contentV1CardsFilterPost200ResponseDataInnerDimensions.height);
  }

  @Override
  public int hashCode() {
    return Objects.hash(width, length, height);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1CardsFilterPost200ResponseDataInnerDimensions {\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
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

