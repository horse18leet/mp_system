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
public class MessageReportDetailReceiveDTO {
    private String dateFrom;
    private String dateTo;
    private Long rrdid;
    private Integer limit;
    private ApiKeyDto apiKeyDto;
}
