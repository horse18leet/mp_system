package org.vyatsu.localApiModule.dto.response.api.item;

import lombok.*;
import org.vyatsu.localApiModule.dto.response.api.UserDto;
import org.vyatsu.localApiModule.entity.item.Item;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private String vendorCode;
    private String mpLink;
    private Boolean isDraft;
    private Boolean isActive;
    private LocalDateTime createdAt;
}