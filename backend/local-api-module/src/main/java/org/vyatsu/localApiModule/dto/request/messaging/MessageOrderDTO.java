package org.vyatsu.localApiModule.dto.request.messaging;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageOrderDTO {
    private HttpServletRequest req;
    private String dateFrom;
    private Integer flag;
    private String apiKey;
}
