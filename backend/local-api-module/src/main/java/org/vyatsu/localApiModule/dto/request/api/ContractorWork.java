package org.vyatsu.localApiModule.dto.request.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractorWork {
    private Long contractorId;
    private Double cost;
    private LocalDateTime deadline;
}
