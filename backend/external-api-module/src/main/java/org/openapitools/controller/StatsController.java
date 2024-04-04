package org.openapitools.controller;

import org.openapitools.dto.messaging.receive.MessageOrderReceiveDTO;
import org.openapitools.dto.messaging.send.MessageOrderSendDTO;
import org.openapitools.messaging.dto.OrderWBDto;
import org.openapitools.util.HelperUtil;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@EnableRabbit
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

//    @GetMapping("/orders")
    @RabbitListener(queues = "queue.Order")
    private void getIntervalOrders(@RequestBody MessageOrderReceiveDTO message) throws URISyntaxException, IOException {

        String getOrdersUrl = HelperUtil.urlStatsWB + "api/v1/supplier/orders?dateFrom=" + message.getDateFrom() + "&flag=" + message.getFlag();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", message.getApiKey());

        RequestEntity<String> entity = new RequestEntity<>(
                null,
                headers,
                HttpMethod.GET,
                new URI(getOrdersUrl)
        );

        OrderWBDto orders = null;

        try {
            orders = restTemplate.exchange(getOrdersUrl, HttpMethod.GET, entity, OrderWBDto.class).getBody();
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.BAD_REQUEST) {
                System.out.println("Error response body: " + ex.getResponseBodyAsString());
            } else {
                System.out.println("Error status code: " + ex.getStatusCode());
            }
        }

        System.out.println(orders);

        rabbitTemplate.setExchange("exchange-order-1");
        rabbitTemplate.convertAndSend(orders);
    }
}
