package org.vyatsu.localApiModule.messaging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleWBDto {

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

    @JsonProperty("nmId")
    Integer nmId;

    @JsonProperty("barcode")
    String barcode;

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

    @JsonProperty("paymentSaleAmount")
    Integer paymentSaleAmount;

    @JsonProperty("forPay")
    Integer forPay;

    @JsonProperty("finishedPrice")
    Integer finishedPrice;

    @JsonProperty("priceWithDisc")
    Integer priceWithDisc;

    @JsonProperty("saleId")
    Boolean saleId;

    @JsonProperty("orderType")
    String orderType;

    @JsonProperty("sticker")
    String sticker;

    @JsonProperty("gNumber")
    String gNumber;

    @JsonProperty("srid")
    String srid;
}

