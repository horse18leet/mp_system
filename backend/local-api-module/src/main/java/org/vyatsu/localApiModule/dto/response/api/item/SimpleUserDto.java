package org.vyatsu.localApiModule.dto.response.api.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.vyatsu.localApiModule.entity.user.User;

/**
 * DTO for {@link User}
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimpleUserDto {
    private Long id;
}