package org.openapitools.service;

import org.openapitools.entity.ApiKey;

import java.util.List;

public interface ApiKeyService {
    List<ApiKey> getAllApiKey();
    ApiKey saveApiKey(ApiKey apiKey);
}
