package org.vyatsu.localApiModule.dto.response.api.item;

import lombok.*;
import org.vyatsu.localApiModule.dto.response.api.UserDto;
import org.vyatsu.localApiModule.entity.item.Item;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO for {@link Item}
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDto {
    private Long id;
    private String title;
    private String description;
    private Double firstPrice;
    private SimpleUserDto user;
    private String category;
    private String mpLink;
    private Boolean isActive;
    private LocalDateTime createdAt;
}