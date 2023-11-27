package org.vyatsu.localApiModule.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.vyatsu.localApiModule.entity.user.ApiKey;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.exception.AppException;
import org.vyatsu.localApiModule.repository.ApiKeyRepository;
import org.vyatsu.localApiModule.security.utils.JwtUtils;
import org.vyatsu.localApiModule.service.ApiKeyService;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class ApiKeyServiceImpl implements ApiKeyService {

    private final ApiKeyRepository apiKeyRepository;

    private final JwtUtils jwtUtils;
    @Override
    public ApiKey CreateApiKey(HttpServletRequest request, ApiKey apiKey) {
        if(apiKey.getKey() != null) {
            User user = jwtUtils.getUserByReq(request);
            int countApiKeys = apiKeyRepository.findByUserId(user.getId()).size();
            if (countApiKeys < 10) {
                String[] typeAndKey = apiKey.getKey().split(" ");
                if (typeAndKey.length == 2) {
                    ApiKey tempApiKey = apiKeyRepository.findByKey(apiKey.getKey());
                    if (tempApiKey != null) {
                        throw new AppException("API key already exists", HttpStatus.BAD_REQUEST);
                    } else {
                        apiKey.setUser(user);
                        apiKey.setCreatedAt(LocalDateTime.now());
                        return apiKeyRepository.save(apiKey);
                    }
                } else {
                    throw new AppException("API key is incorrect. Format: {type_key}.", HttpStatus.BAD_REQUEST);
                }
            }
            else{
                throw new AppException("API keys is limit 10", HttpStatus.BAD_REQUEST);
            }
        }
        else{
            throw new AppException("API key is required", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<ApiKey> getAllApiKey(HttpServletRequest request, String type) {
        User user = jwtUtils.getUserByReq(request);
        List<ApiKey> apiKeys = apiKeyRepository.findByUserId(user.getId());
        return apiKeys.stream()
                .filter(apiKey -> {
                    String[] typeAndKey = apiKey.getKey().split(" ");
                    return typeAndKey.length > 0 && typeAndKey[0].equals(type);
                }).toList();
    }
}
