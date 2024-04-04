package org.vyatsu.localApiModule.service;

import org.vyatsu.localApiModule.entity.enums.ApiKeyType;
import org.vyatsu.localApiModule.entity.user.ApiKey;

import java.util.List;

public interface ApiKeyService {
    ApiKey CreateApiKey(ApiKey apiKey);

    List<ApiKey> getAllApiKeyUser(ApiKeyType type);

    List<ApiKey> getAllApiKey(ApiKeyType type);
}
