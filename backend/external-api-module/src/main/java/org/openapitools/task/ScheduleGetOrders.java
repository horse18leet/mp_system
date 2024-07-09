package org.openapitools.task;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.openapitools.dto.ApiKeyDto;
import org.openapitools.dto.messaging.receive.MessageOrderReceiveDTO;
import org.openapitools.entity.ApiKey;
import org.openapitools.service.ApiKeyService;
import org.openapitools.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class ScheduleGetOrders {

    private static final Logger log = LoggerFactory.getLogger(ScheduleGetOrders.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private final ApiKeyService apiKeyService;
    private final OrderService orderService;

    @Scheduled(fixedRate = 300000)
    public void getOrdersAndSalesByDay() throws URISyntaxException, JsonProcessingException {
        List<ApiKey> apiKeysWB = apiKeyService.getAllApiKeyByType("WB");
        MessageOrderReceiveDTO message = MessageOrderReceiveDTO
                .builder()
                .flag(1)
                .dateFrom(String.valueOf(LocalDateTime.now()))
                .build();
        for (ApiKey apiKey : apiKeysWB){
            message.setApiKeyDto(ApiKeyDto
                    .builder()
                    .key(apiKey.getKey())
                    .clientId(apiKey.getClientId())
                    .type(apiKey.getType())
                    .build());

            orderService.getOrdersPerDay(message);
            orderService.getSalesPerDay(message);
        }
        log.info("Проверка у " + apiKeysWB.stream().count() + " ключей");
        log.info("Время проверки заказов и выкупов: {}", dateFormat.format(new Date()));
    }

}
