package org.vyatsu.localApiModule.dto.response.api;

import lombok.*;
import org.vyatsu.localApiModule.entity.enums.ApiKeyType;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiKeyDto implements Serializable {
    Long id;
    String key;
    String clientId;
    ApiKeyType type;
    Boolean isExpired;
    Long userId;
}