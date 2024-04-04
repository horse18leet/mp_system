package org.vyatsu.localApiModule.messaging.dto;

import lombok.*;
import org.vyatsu.localApiModule.dto.response.api.ApiKeyDto;
import org.vyatsu.localApiModule.entity.enums.ApiKeyType;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MessageOrderSenderDTO {
    private List<ApiKeyDto> apiKeys;
    private String dateFrom;
    private Integer flag;
    private String apiKey;
    private ApiKeyType apiKeyType;
}
