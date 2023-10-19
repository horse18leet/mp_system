package org.vyatsu.localApiModule.dto.response.api;

import lombok.Value;
import org.vyatsu.localApiModule.entity.enums.RoleType;

import java.io.Serializable;

/**
 * DTO for {@link org.vyatsu.localApiModule.entity.role.Role}
 */
@Value
public class RoleDto implements Serializable {
    Long id;
    RoleType name;
}