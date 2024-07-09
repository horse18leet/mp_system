package org.vyatsu.localApiModule.dto.request.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseCreateDTO {
    private Long itemId;
    private Double quantity;
    private List<ContractorWork> contractorsWork;
    private Long purchaseId;
}
