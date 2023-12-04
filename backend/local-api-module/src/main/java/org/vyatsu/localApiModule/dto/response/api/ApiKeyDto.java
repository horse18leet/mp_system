package org.vyatsu.localApiModule.dto.response.api;

import lombok.Value;
import org.vyatsu.localApiModule.entity.enums.ApiKeyType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.vyatsu.localApiModule.entity.user.ApiKey}
 */
@Value
public class ApiKeyDto implements Serializable {
    Long id;
    String key;
    ApiKeyType type;
    LocalDateTime createdAt;
}