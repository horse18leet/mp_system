package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * RequestMoveNmsImtConn
 */

@JsonTypeName("requestMoveNmsImtConn")
public class RequestMoveNmsImtConn implements ContentV1CardsMoveNmPostRequest {

  @JsonProperty("targetIMT")
  private Integer targetIMT;

  @JsonProperty("nmIDs")
  @Valid
  private List<Integer> nmIDs = new ArrayList<>();

  public RequestMoveNmsImtConn targetIMT(Integer targetIMT) {
    this.targetIMT = targetIMT;
    return this;
  }

  /**
   * Существующий у продавца `imtID`, под которым необходимо объединить НМ
   * @return targetIMT
  */
  @NotNull
  @Schema(name = "targetIMT", example = "123", description = "Существующий у продавца `imtID`, под которым необходимо объединить НМ", required = true)
  public Integer getTargetIMT() {
    return targetIMT;
  }

  public void setTargetIMT(Integer targetIMT) {
    this.targetIMT = targetIMT;
  }

  public RequestMoveNmsImtConn nmIDs(List<Integer> nmIDs) {
    this.nmIDs = nmIDs;
    return this;
  }

  public RequestMoveNmsImtConn addNmIDsItem(Integer nmIDsItem) {
    this.nmIDs.add(nmIDsItem);
    return this;
  }

  /**
   * `nmID`, которые необходимо объединить (max 30)
   * @return nmIDs
  */
  @NotNull 
  @Schema(name = "nmIDs", example = "[837459235,828572090]", description = "`nmID`, которые необходимо объединить (max 30)", required = true)
  public List<Integer> getNmIDs() {
    return nmIDs;
  }

  public void setNmIDs(List<Integer> nmIDs) {
    this.nmIDs = nmIDs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestMoveNmsImtConn requestMoveNmsImtConn = (RequestMoveNmsImtConn) o;
    return Objects.equals(this.targetIMT, requestMoveNmsImtConn.targetIMT) &&
        Objects.equals(this.nmIDs, requestMoveNmsImtConn.nmIDs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(targetIMT, nmIDs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestMoveNmsImtConn {\n");
    sb.append("    targetIMT: ").append(toIndentedString(targetIMT)).append("\n");
    sb.append("    nmIDs: ").append(toIndentedString(nmIDs)).append("\n");
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

