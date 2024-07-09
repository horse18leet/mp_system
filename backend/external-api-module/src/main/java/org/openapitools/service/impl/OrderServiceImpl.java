package org.openapitools.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openapitools.dto.messaging.receive.MessageOrderReceiveDTO;
import org.openapitools.dto.messaging.receive.MessageReportDetailReceiveDTO;
import org.openapitools.messaging.dto.OrderWBDto;
import org.openapitools.messaging.dto.RealizationReportWBDto;
import org.openapitools.messaging.dto.SaleWBDto;
import org.openapitools.service.OrderService;
import org.openapitools.util.HelperUtil;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@EnableRabbit
public class OrderServiceImpl implements OrderService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

    @Override
    public void getOrdersPerDay(MessageOrderReceiveDTO message) throws JsonProcessingException, URISyntaxException {
        String getOrdersUrl = HelperUtil.urlStatsWB + "api/v1/supplier/orders?dateFrom=" + message.getDateFrom() + "&flag=" + message.getFlag();
        String ordersJson = HelperUtil.createWBRequest(getOrdersUrl, HttpMethod.GET, message.getApiKeyDto().getKey(), null);

        ObjectMapper objectMapper = new ObjectMapper();
        List<OrderWBDto> orders = objectMapper.readValue(ordersJson, new TypeReference<>() {
        });

        for (OrderWBDto order : orders) {
            rabbitTemplate.setExchange("exchange-order-2");
            rabbitTemplate.convertAndSend(order);
        }
    }

    @Override
    public void getSalesPerDay(MessageOrderReceiveDTO message) throws URISyntaxException, JsonProcessingException {
        String url = HelperUtil.urlStatsWB + "api/v1/supplier/sales?dateFrom=" + message.getDateFrom() + "&flag=" + message.getFlag();
        String salesJson = HelperUtil.createWBRequest(url, HttpMethod.GET, message.getApiKeyDto().getKey(), null);

        ObjectMapper objectMapper = new ObjectMapper();
        List<SaleWBDto> sales = objectMapper.readValue(salesJson, new TypeReference<>() {
        });

        for (SaleWBDto sale : sales) {
            rabbitTemplate.setExchange("exchange-sale-1");
            rabbitTemplate.convertAndSend(sale);
        }
    }

    @Override
    public void getReportDetail(MessageReportDetailReceiveDTO message) throws URISyntaxException, JsonProcessingException {
        String getOrdersUrl = HelperUtil.urlStatsWB + "api/v5/supplier/reportDetailByPeriod?dateFrom=" + message.getDateFrom() + "&dateTo=" + message.getDateTo();
        String ordersJson = HelperUtil.createWBRequest(getOrdersUrl, HttpMethod.GET, message.getApiKeyDto().getKey(), null);

        ObjectMapper objectMapper = new ObjectMapper();
        List<RealizationReportWBDto> realizationReports = objectMapper.readValue(ordersJson, new TypeReference<>() {
        });

        rabbitTemplate.setExchange("exchange-order-1");
        rabbitTemplate.convertAndSend(ordersJson);


        //реализовать добавление в монго дб
        System.out.println(realizationReports);
    }
}
