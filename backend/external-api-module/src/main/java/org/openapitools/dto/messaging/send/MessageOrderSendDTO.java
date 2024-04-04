package org.openapitools.dto.messaging.send;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageOrderSendDTO {
    private HttpServletRequest req;
    private String dateFrom;
    private Integer flag;
    private String apiKey;
}
