package org.vyatsu.localApiModule.dto.request.api;

import lombok.*;
import org.vyatsu.localApiModule.entity.enums.ContractorType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.vyatsu.localApiModule.entity.contractor.Contractor}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractorDto implements Serializable {
    Long id;
    String name;
    ContractorType type;
    String description;
    String email;
    String phoneNum;
    String actualAddress;
    Boolean isActive;
    LocalDateTime createdAt;
    String paymentNum;
}