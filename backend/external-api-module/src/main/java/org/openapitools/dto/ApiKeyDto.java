package org.openapitools.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiKeyDto {
    String id;
    String key;
    String clientId;
    String type;
    int userId;
}