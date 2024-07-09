package org.openapitools.controller;

import lombok.AllArgsConstructor;
import org.openapitools.dto.messaging.receive.MessageOrderReceiveDTO;
<<<<<<< Updated upstream
import org.openapitools.dto.messaging.send.MessageOrderSendDTO;
import org.openapitools.messaging.dto.OrderWBDto;
import org.openapitools.util.HelperUtil;
import org.springframework.amqp.core.DirectExchange;
=======
import org.openapitools.service.OrderService;
>>>>>>> Stashed changes
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@EnableRabbit
@RequestMapping("/stats")
@AllArgsConstructor
public class StatsController {

    private final OrderService orderService;

//    @GetMapping("/orders")
    @RabbitListener(queues = "queue.Order")
<<<<<<< Updated upstream
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
=======
    @PostMapping("/getOrders")
    private void getOrdersPerDay(@RequestBody MessageOrderReceiveDTO message) throws URISyntaxException, IOException {
        orderService.getOrdersPerDay(message);
>>>>>>> Stashed changes
    }

}
