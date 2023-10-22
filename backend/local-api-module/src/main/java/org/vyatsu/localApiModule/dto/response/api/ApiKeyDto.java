package org.vyatsu.localApiModule.dto.response.api;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link org.vyatsu.localApiModule.entity.user.ApiKey}
 */
@Value
public class ApiKeyDto implements Serializable {
    Long id;
    String key;
    LocalDate createdAt;
}