package org.vyatsu.localApiModule.dto.response.api;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link org.vyatsu.localApiModule.entity.item.Item}
 */
@Value
public class ItemDto implements Serializable {
    Long id;
    String title;
    String description;
    Double firstPrice;
    String category;
    String mpLink;
    Boolean isActive;
    LocalDate createdAt;
}