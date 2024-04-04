package org.vyatsu.localApiModule.messaging.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
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
    String srid;
}
