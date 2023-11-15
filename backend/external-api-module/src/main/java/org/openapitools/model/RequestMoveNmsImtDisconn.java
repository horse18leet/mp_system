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
 * RequestMoveNmsImtDisconn
 */

@JsonTypeName("requestMoveNmsImtDisconn")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class RequestMoveNmsImtDisconn implements ContentV1CardsMoveNmPostRequest {

  @JsonProperty("nmIDs")
  @Valid
  private List<Integer> nmIDs = new ArrayList<>();

  public RequestMoveNmsImtDisconn nmIDs(List<Integer> nmIDs) {
    this.nmIDs = nmIDs;
    return this;
  }

  public RequestMoveNmsImtDisconn addNmIDsItem(Integer nmIDsItem) {
    this.nmIDs.add(nmIDsItem);
    return this;
  }

  /**
   * `nmID`, которые необходимо разъединить (max 30)
   * @return nmIDs
  */
  @NotNull 
  @Schema(name = "nmIDs", example = "[837459235,828572090]", description = "`nmID`, которые необходимо разъединить (max 30)", required = true)
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
    RequestMoveNmsImtDisconn requestMoveNmsImtDisconn = (RequestMoveNmsImtDisconn) o;
    return Objects.equals(this.nmIDs, requestMoveNmsImtDisconn.nmIDs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nmIDs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestMoveNmsImtDisconn {\n");
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

