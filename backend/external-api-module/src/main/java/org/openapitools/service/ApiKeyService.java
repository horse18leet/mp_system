package org.openapitools.service;

import org.openapitools.entity.ApiKey;

import java.util.List;

public interface ApiKeyService {
<<<<<<< Updated upstream
    List<ApiKey> getAllApiKey();
=======
    List<ApiKey> getAllApiKeyByType(String type);
>>>>>>> Stashed changes
    ApiKey saveApiKey(ApiKey apiKey);
}
