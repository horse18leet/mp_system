package org.openapitools.service.impl;

import lombok.AllArgsConstructor;
import org.openapitools.entity.ApiKey;
import org.openapitools.repository.ApiKeyRepository;
import org.openapitools.service.ApiKeyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApiKeyServiceImpl implements ApiKeyService {

    private final ApiKeyRepository apiKeyRepository;
    @Override
    public List<ApiKey> getAllApiKey() {
        return apiKeyRepository.findAll();
    }

    @Override
    public ApiKey saveApiKey(ApiKey apiKey) {
        return apiKeyRepository.save(apiKey);
    }
}
