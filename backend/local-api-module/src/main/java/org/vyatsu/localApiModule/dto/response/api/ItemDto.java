package org.vyatsu.localApiModule.dto.response.api;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.vyatsu.localApiModule.entity.item.Item;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Item}
 */

@Getter
@Setter
public class ItemDto implements Serializable {
    Long id;
    String title;
    String description;
    Double firstPrice;
    UserDto user;
    String category;
    String mpLink;
    Boolean isActive;
    LocalDate createdAt;
}