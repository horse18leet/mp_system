package org.vyatsu.localApiModule.dto.response.api.item;

import lombok.Value;
import org.vyatsu.localApiModule.entity.item.Order;

import java.io.Serializable;
import java.time.LocalDateTime;

@Value
public class OrderDto{
    Long id;
    double price;
    LocalDateTime takedAt;
    LocalDateTime createdAt;
}