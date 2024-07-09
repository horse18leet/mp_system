package org.openapitools.service.impl;

import lombok.AllArgsConstructor;
<<<<<<< Updated upstream
=======
import org.openapitools.dto.ApiKeyDto;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    public List<ApiKey> getAllApiKey() {
        return apiKeyRepository.findAll();
=======
    public List<ApiKey> getAllApiKeyByType(String type) {
        return apiKeyRepository.findByType(type);
>>>>>>> Stashed changes
    }

    @Override
    public ApiKey saveApiKey(ApiKey apiKey) {
<<<<<<< Updated upstream
        return apiKeyRepository.save(apiKey);
=======
        boolean isExists = apiKeyRepository.existsByKey(apiKey.getKey());
        if(!isExists){
            apiKey = apiKeyRepository.save(apiKey);
        }
        return apiKey;
>>>>>>> Stashed changes
    }
}
