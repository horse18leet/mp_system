package org.vyatsu.localApiModule.task;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Component;
import org.vyatsu.localApiModule.dto.response.api.ApiKeyDto;
import org.vyatsu.localApiModule.entity.enums.ApiKeyType;
import org.vyatsu.localApiModule.mapper.ApiKeyMapper;
import org.vyatsu.localApiModule.service.impl.ApiKeyServiceImpl;
import org.vyatsu.localApiModule.task.service.ScheduleOrderService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Component
@AllArgsConstructor
public class ScheduleGetOrdersWB {

    private final ApiKeyServiceImpl apiKeyService;
    private final ApiKeyMapper apiKeyMapper;
    private final ScheduleOrderService scheduleOrderService;
    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 30 * 60 * 1000)
    public void getOrdersByDay() {
        List<ApiKeyDto> apiKeys = apiKeyMapper.toDtoList(apiKeyService.getAllApiKey(ApiKeyType.WB));

        ArrayList<ArrayList<ArrayList<LinkedHashMap<String, String>>>> orders = scheduleOrderService.GetOrdersByApiKeys(apiKeys, "0");
        log.info("Время проверки заказов: {}", dateFormat.format(new Date()));
        log.info("Заказов сегодня: " + orders.get(0).get(0).size() + " шт.");
    }
}
