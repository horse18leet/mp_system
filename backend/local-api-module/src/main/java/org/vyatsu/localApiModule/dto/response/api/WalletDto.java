package org.vyatsu.localApiModule.dto.response.api;

import lombok.Value;
import org.vyatsu.localApiModule.entity.contractor.Wallet;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Wallet}
 */
@Value
public class WalletDto implements Serializable {
    Long id;
    String paymentNum;
    LocalDateTime createdAt;
}