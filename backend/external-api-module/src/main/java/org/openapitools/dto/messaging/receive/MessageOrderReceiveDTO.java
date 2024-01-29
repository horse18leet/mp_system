package org.openapitools.dto.messaging.receive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openapitools.dto.ApiKeyDto;
import org.openapitools.dto.enums.ApiKeyType;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageOrderReceiveDTO {
    private List<ApiKeyDto> apiKeys;
    private String dateFrom;
    private Integer flag;
    private String apiKey;
    private ApiKeyType apiKeyType;
}
