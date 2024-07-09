package org.vyatsu.localApiModule.dto.request.messaging;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RealizationReportWBDto {

    @JsonProperty("realizationreport_id")
    Long realizationReportId;

    @JsonProperty("date_from")
    String dateFrom;

    @JsonProperty("date_to")
    String dateTo;

    @JsonProperty("create_dt")
    String createDt;

    @JsonProperty("currency_name")
    String currencyName;

    @JsonProperty("suppliercontract_code")
    Integer supplierContractCode;

    @JsonProperty("rrd_id")
    Long rrdId;

    @JsonProperty("barcode")
    Long barcode;

    @JsonProperty("gi_id")
    Long giId;

    @JsonProperty("subject_name")
    String subjectName;

    @JsonProperty("nm_id")
    Long nmId;

    @JsonProperty("brand_name")
    String brandName;

    @JsonProperty("sa_name")
    String saName;

    @JsonProperty("ts_name")
    String tsName;

    @JsonProperty("doc_type_name")
    String docTypeName;

    @JsonProperty("quantity")
    Integer quantity;

    @JsonProperty("retail_price")
    Double retailPrice;

    @JsonProperty("retail_amount")
    Double retailAmount;

    @JsonProperty("sale_percent")
    Double salePercent;

    @JsonProperty("commission_percent")
    Double commissionPercent;

    @JsonProperty("office_name")
    String officeName;

    @JsonProperty("supplier_oper_name")
    String supplierOperName;

    @JsonProperty("order_dt")
    String orderDt;

    @JsonProperty("sale_dt")
    String saleDt;

    @JsonProperty("rr_dt")
    String rrDt;

    @JsonProperty("shk_id")
    Long shkId;

    @JsonProperty("retail_price_withdisc_rub")
    Double retailPriceWithdiscRub;

    @JsonProperty("delivery_amount")
    Double deliveryAmount;

    @JsonProperty("return_amount")
    Double returnAmount;

    @JsonProperty("delivery_rub")
    Double deliveryRub;

    @JsonProperty("gi_box_type_name")
    String giBoxTypeName;

    @JsonProperty("product_discount_for_report")
    Double productDiscountForReport;

    @JsonProperty("supplier_promo")
    Integer supplierPromo;

    @JsonProperty("rid")
    Integer rid;

    @JsonProperty("ppvz_spp_prc")
    Double ppvzSppPrc;

    @JsonProperty("ppvz_kvw_prc_base")
    Double ppvzKvwPrcBase;

    @JsonProperty("ppvz_kvw_prc")
    Double ppvzKvwPrc;

    @JsonProperty("sup_rating_prc_up")
    Double supRatingPrcUp;

    @JsonProperty("is_kgvp_v2")
    Integer isKgvpV2;

    @JsonProperty("ppvz_sales_commission")
    Double ppvzSalesCommission;

    @JsonProperty("ppvz_for_pay")
    Double ppvzForPay;

    @JsonProperty("ppvz_reward")
    Double ppvzReward;

    @JsonProperty("acquiring_fee")
    Double acquiringFee;

    @JsonProperty("acquiring_percent")
    Double acquiringPercent;

    @JsonProperty("acquiring_bank")
    String acquiringBank;

    @JsonProperty("ppvz_vw")
    Integer ppvzVw;

    @JsonProperty("ppvz_vw_nds")
    Double ppvzVwNds;

    @JsonProperty("ppvz_office_name")
    String ppvzOfficeName;

    @JsonProperty("ppvz_office_id")
    Integer ppvzOfficeId;

    @JsonProperty("ppvz_supplier_id")
    Long ppvzSupplierId;

    @JsonProperty("ppvz_supplier_name")
    String ppvzSupplierName;

    @JsonProperty("ppvz_inn")
    String ppvzInn;

    @JsonProperty("declaration_number")
    String declarationNumber;

    @JsonProperty("sticker_id")
    Long stickerId;

    @JsonProperty("site_country")
    String siteCountry;

    @JsonProperty("penalty")
    String penalty;

    @JsonProperty("additional_payment")
    Double additionalPayment;

    @JsonProperty("rebill_logistic_cost")
    Double rebillLogisticCost;

    @JsonProperty("rebill_logistic_org")
    String rebillLogisticOrg;

    @JsonProperty("storage_fee")
    Double storageFee;

    @JsonProperty("deduction")
    Double deduction;

    @JsonProperty("acceptance")
    String acceptance;

    @JsonProperty("srid")
    String srid;

    @JsonProperty("report_type")
    Integer report_type;

    @JsonProperty("bonus_type_name")
    String bonusTypeName;

}
