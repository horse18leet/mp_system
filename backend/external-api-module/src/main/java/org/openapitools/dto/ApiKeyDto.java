package org.openapitools.dto;

import lombok.Value;
import org.openapitools.dto.enums.ApiKeyType;

import java.time.LocalDateTime;

@Value
public class ApiKeyDto {
    Long id;
    String key;
    String type;

    public ApiKeyDto(Long id, String key, String type){

        this.id = id;
        this.key = key;
        this.type = type;
    }
}