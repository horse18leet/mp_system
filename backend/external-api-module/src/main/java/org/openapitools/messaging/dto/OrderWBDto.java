package org.openapitools.messaging.dto;

<<<<<<< Updated upstream
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
=======
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
>>>>>>> Stashed changes

import java.time.LocalDateTime;

@Getter
@Setter
<<<<<<< Updated upstream
@Builder
public class OrderWBDto {
    LocalDateTime date;
    LocalDateTime lastChangeDate;
    String warehouseName;
    String countryName;
    String oblastOkrugName;
    String regionName;
    String supplierArticle;
    String barcode;
    Integer nmId;
    String category;
    String subject;
    String brand;
    String techSize;
    String incomeID;
    Boolean isSupply;
    Boolean isRealization;
    Integer totalPrice;
    Integer discountPercent;
    Integer spp;
    Integer finishedPrice;
    Integer priceWithDisc;
    Boolean isCancel;
    LocalDateTime cancelDate;
    String orderType;
    String sticker;
    String gNumber;
=======
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderWBDto {

    @JsonProperty("date")
    String date;

    @JsonProperty("lastChangeDate")
    String lastChangeDate;

    @JsonProperty("warehouseName")
    String warehouseName;

    @JsonProperty("countryName")
    String countryName;

    @JsonProperty("oblastOkrugName")
    String oblastOkrugName;

    @JsonProperty("regionName")
    String regionName;

    @JsonProperty("supplierArticle")
    String supplierArticle;

    @JsonProperty("barcode")
    String barcode;

    @JsonProperty("nmId")
    Integer nmId;

    @JsonProperty("category")
    String category;

    @JsonProperty("subject")
    String subject;

    @JsonProperty("brand")
    String brand;

    @JsonProperty("techSize")
    String techSize;

    @JsonProperty("incomeID")
    String incomeID;

    @JsonProperty("isSupply")
    Boolean isSupply;

    @JsonProperty("isRealization")
    Boolean isRealization;

    @JsonProperty("totalPrice")
    Integer totalPrice;

    @JsonProperty("discountPercent")
    Integer discountPercent;

    @JsonProperty("spp")
    Integer spp;

    @JsonProperty("finishedPrice")
    Integer finishedPrice;

    @JsonProperty("priceWithDisc")
    Integer priceWithDisc;

    @JsonProperty("isCancel")
    Boolean isCancel;

    @JsonProperty("cancelDate")
    String cancelDate;

    @JsonProperty("orderType")
    String orderType;

    @JsonProperty("sticker")
    String sticker;

    @JsonProperty("gNumber")
    String gNumber;

    @JsonProperty("srid")
>>>>>>> Stashed changes
    String srid;
}
