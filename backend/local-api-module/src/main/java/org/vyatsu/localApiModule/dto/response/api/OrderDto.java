package org.vyatsu.localApiModule.dto.response.api;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.vyatsu.localApiModule.entity.item.Order}
 */
@Value
public class OrderDto implements Serializable {
    double price;
    LocalDateTime takedAt;
    LocalDateTime createdAt;
}