package org.vyatsu.localApiModule.service;

import jakarta.servlet.http.HttpServletRequest;
import org.vyatsu.localApiModule.entity.enums.ApiKeyType;
import org.vyatsu.localApiModule.entity.user.ApiKey;

import java.util.List;

public interface ApiKeyService {
    ApiKey CreateApiKey(HttpServletRequest request, ApiKey apiKey);

    List<ApiKey> getAllApiKeyUser(HttpServletRequest request, ApiKeyType type);

    List<ApiKey> getAllApiKey(ApiKeyType type);
}
