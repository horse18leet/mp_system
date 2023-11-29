package org.openapitools.dto;

import lombok.Value;
import org.openapitools.dto.enums.ApiKeyType;

import java.time.LocalDateTime;

@Value
public class ApiKeyDto {
    Long id;
    String key;
    String type;
    LocalDateTime createdAt;

    public ApiKeyDto(Long id, String key, String type, LocalDateTime createdAt){

        this.id = id;
        this.key = key;
        this.type = type;
        this.createdAt = createdAt;
    }
}