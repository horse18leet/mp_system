package org.openapitools.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "realizationReportsWB")
public class RealizationReportWB {
    @Id
    private String id;
    private Long realizationReportId;
    private String dateFrom;
    private String dateTo;
    private String createDt;
    private String currencyName;
    private Integer supplierContractCode;
    private Long rrdId;
    private Long barcode;
    private Long giId;
    private String subjectName;
    private Long nmId;
    private String brandName;
    private String saName;
    private String tsName;
    private String docTypeName;
    private Integer quantity;
    private Double retailPrice;
    private Double retailAmount;
    private Double salePercent;
    private Double commissionPercent;
    private String officeName;
    private String supplierOperName;
    private String orderDt;
    private String saleDt;
    private String rrDt;
    private Long shkId;
    private Double retailPriceWithdiscRub;
    private Double deliveryAmount;
    private Double returnAmount;
    private Double deliveryRub;
    private String giBoxTypeName;
    private Double productDiscountForReport;
    private Integer supplierPromo;
    private Integer rid;
    private Double ppvzSppPrc;
    private Double ppvzKvwPrcBase;
    private Double ppvzKvwPrc;
    private Double supRatingPrcUp;
    private Integer isKgvpV2;
    private Double ppvzSalesCommission;
    private Double ppvzForPay;
    private Double ppvzReward;
    private Double acquiringFee;
    private Double acquiringPercent;
    private String acquiringBank;
    private Integer ppvzVw;
    private Double ppvzVwNds;
    private String ppvzOfficeName;
    private Integer ppvzOfficeId;
    private Long ppvzSupplierId;
    private String ppvzSupplierName;
    private String ppvzInn;
    private String declarationNumber;
    private Long stickerId;
    private String siteCountry;
    private String penalty;
    private Double additionalPayment;
    private Double rebillLogisticCost;
    private String rebillLogisticOrg;
    private Double storageFee;
    private String deduction;
    private String acceptance;
    private String srid;
    private Integer report_type;
    private String bonusTypeName;
}
