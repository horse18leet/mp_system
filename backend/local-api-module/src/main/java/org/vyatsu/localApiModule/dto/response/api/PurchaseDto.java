package org.vyatsu.localApiModule.dto.response.api;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link org.vyatsu.localApiModule.entity.purchase.Purchase}
 */
@Value
public class PurchaseDto implements Serializable {
    Long id;
    double cost;
    LocalDate createdAt;
}