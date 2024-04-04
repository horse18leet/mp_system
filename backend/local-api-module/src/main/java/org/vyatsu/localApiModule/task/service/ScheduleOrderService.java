package org.vyatsu.localApiModule.task.service;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.vyatsu.localApiModule.dto.response.api.ApiKeyDto;
import org.vyatsu.localApiModule.entity.enums.ApiKeyType;
import org.vyatsu.localApiModule.entity.user.ApiKey;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.messaging.dto.MessageOrderSenderDTO;
import org.vyatsu.localApiModule.repository.ApiKeyRepository;
import org.vyatsu.localApiModule.security.authentication.impl.AuthenticationFacade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.vyatsu.localApiModule.util.HelperUtil.urlExternalModule;


@Service
@AllArgsConstructor
public class ScheduleOrderService {

    private final AuthenticationFacade authenticationFacade;

    @Autowired
    RabbitTemplate template;
    @Autowired
    private ApiKeyRepository apiKeyRepository;

    public void GetOrdersByApiKeys(List<ApiKeyDto> apiKeys, String flag){
        User user = authenticationFacade.getAuthenticationUser();

        ApiKey apiKey = apiKeyRepository.findByTypeAndUser(ApiKeyType.WB, user.getId());
        MessageOrderSenderDTO message = MessageOrderSenderDTO.builder()
                .apiKeyType(ApiKeyType.WB)
                .dateFrom(LocalDateTime.now().minusDays(1).toString())
                .apiKey(apiKey.getKey())
                .flag(0)
                .build();
        template.setExchange("exchange-order-1");
        template.convertAndSend(message);
    }

}
