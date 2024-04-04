package org.vyatsu.localApiModule.dto;

import lombok.*;
import org.vyatsu.localApiModule.dto.request.api.ContractorDto;
import org.vyatsu.localApiModule.dto.response.api.item.ItemDto;
import org.vyatsu.localApiModule.entity.enums.WalletTransactionType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.vyatsu.localApiModule.entity.contractor.WalletTransaction}
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WalletTransactionDto implements Serializable {
    Long id;
    double amount;
    String description;
    LocalDateTime implDate;
    LocalDateTime createdAt;
    WalletTransactionType type;
    ContractorDto contractorDto;
    ItemDto itemDto;
}