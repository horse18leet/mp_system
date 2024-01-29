package org.vyatsu.localApiModule.dto.request.api;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.vyatsu.localApiModule.dto.response.api.ApiKeyDto;
import org.vyatsu.localApiModule.entity.enums.ApiKeyType;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderReqDto {

    private List<ApiKeyDto> apiKeys;
    private String dateFrom;
    private Integer flag;
    private String apiKey;
    private ApiKeyType apiKeyType;
}
