package org.vyatsu.localApiModule.dto.response.api;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.vyatsu.localApiModule.entity.user.User}
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto implements Serializable {
    Long id;
    String email;
    String password;
    String firstName;
    String secondName;
    String phoneNum;
    Boolean isActive;
    LocalDateTime createdAt;
}