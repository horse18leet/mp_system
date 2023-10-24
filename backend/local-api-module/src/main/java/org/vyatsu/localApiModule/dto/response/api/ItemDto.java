package org.vyatsu.localApiModule.dto.response.api;

import lombok.*;
import org.vyatsu.localApiModule.entity.item.Item;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Item}
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDto implements Serializable {
    private Long id;
    private String title;
    private String description;
    private Double firstPrice;
    private UserDto user;
    private String category;
    private String mpLink;
    private Boolean isActive;
    private LocalDate createdAt;
}