package org.vyatsu.localApiModule.dto.response.api.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.vyatsu.localApiModule.dto.response.api.UserDto;

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
    private UserDto user;
    private String category;
    private String vendorCode;
    private String mpLink;
    private Boolean isDraft;
    private Boolean isActive;
    private LocalDateTime createdAt;
}