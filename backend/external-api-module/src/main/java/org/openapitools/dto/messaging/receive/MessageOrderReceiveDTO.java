package org.openapitools.dto.messaging.receive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openapitools.dto.ApiKeyDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageOrderReceiveDTO {
    private String dateFrom;
    private Integer flag;
    private ApiKeyDto apiKeyDto;
}
