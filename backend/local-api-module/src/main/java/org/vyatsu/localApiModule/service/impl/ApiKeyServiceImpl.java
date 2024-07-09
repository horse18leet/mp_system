package org.vyatsu.localApiModule.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.vyatsu.localApiModule.dto.response.api.ApiKeyDto;
import org.vyatsu.localApiModule.entity.enums.ApiKeyType;
import org.vyatsu.localApiModule.entity.user.ApiKey;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.exception.AppException;
import org.vyatsu.localApiModule.repository.ApiKeyRepository;
import org.vyatsu.localApiModule.security.authentication.impl.AuthenticationFacade;
import org.vyatsu.localApiModule.security.utils.JwtUtils;
import org.vyatsu.localApiModule.service.ApiKeyService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ApiKeyServiceImpl implements ApiKeyService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    private final AuthenticationFacade authenticationFacade;

    private final ApiKeyRepository apiKeyRepository;

    private final JwtUtils jwtUtils;

    @Override
    public ApiKey CreateApiKey(ApiKey apiKey) {
        if (apiKey.getKey() != null) {
            if (apiKey.getType() == ApiKeyType.WB) {
                User user = authenticationFacade.getAuthenticationUser();
                int countApiKeys = apiKeyRepository.findByUserId(user.getId()).size();
                if (countApiKeys < 10) {
                    ApiKey tempApiKey = apiKeyRepository.findByKey(apiKey.getKey());
                    if (tempApiKey == null) {
                        apiKey.setUser(user);
                        apiKey.setType(apiKey.getType());
                        apiKey.setCreatedAt(LocalDateTime.now());
                        apiKey.setIsExpired(false);

                        rabbitTemplate.setExchange("exchange-apikeywb-1");
                        rabbitTemplate.convertAndSend(ApiKeyDto.builder()
                                .key(apiKey.getKey())
                                .type(apiKey.getType())
                                .userId(user.getId())
                                .clientId(apiKey.getClientId())
                                .isExpired(apiKey.getIsExpired())
                                .build());

                        return apiKeyRepository.save(apiKey);
                    } else {
                        throw new AppException("API-ключ уже используется", HttpStatus.BAD_REQUEST);
                    }
                } else {
                    throw new AppException("Превышено кол-во API-ключей", HttpStatus.BAD_REQUEST);
                }
            } else {
                throw new AppException("Данный API ключ не поддерживается", HttpStatus.BAD_REQUEST);
            }
        } else {
            throw new AppException("Введите API-ключ", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<ApiKey> getAllApiKeyUser(ApiKeyType type) {
        User user = authenticationFacade.getAuthenticationUser();
        List<ApiKey> apiKeys = apiKeyRepository.findByUserId(user.getId());
        if (type != null) {
            return apiKeys.stream()
                    .filter(apiKey -> apiKey.getType() == type)
                    .collect(Collectors.toList());
        }
        return apiKeys;
    }

    @Override
    public List<ApiKey> getAllApiKey(ApiKeyType type) {
        return apiKeyRepository.findAll();
    }
}
