package org.vyatsu.localApiModule.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vyatsu.localApiModule.dto.request.api.OrderReqDto;
import org.vyatsu.localApiModule.dto.request.messaging.RealizationReportWBDto;
import org.vyatsu.localApiModule.dto.response.api.OrderDto;
import org.vyatsu.localApiModule.messaging.dto.OrderWBDto;
import org.vyatsu.localApiModule.messaging.dto.SaleWBDto;
import org.vyatsu.localApiModule.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // получение заказов
    // servlet не трогать
    @GetMapping
    private void getUserOrders(HttpServletRequest request, @RequestBody OrderReqDto dto){
        orderService.getOrders(request, dto);
    }

    @RabbitListener(queues = "queue.RecordOrder")
    private void recordOrder(OrderWBDto orderWBDto){
        orderService.createWBOrder(orderWBDto);
    }

    @RabbitListener(queues = "queue.RecordSale")
    private void recordSale(SaleWBDto saleWBDto){
        orderService.createWBSale(saleWBDto);
    }

    @RabbitListener(queues = "queue.ReportDetailWB")
    private void recordReportDetailWB(String message) throws JsonProcessingException {
        orderService.processRealizationReportData(message);
    }

    @GetMapping("/wb")
    private ResponseEntity<List<OrderDto>> getUserOrdersByDateFrom(@RequestParam("dateFrom") LocalDateTime dateFrom){
        List<OrderDto> orders = orderService.getOrdersByDateFrom(dateFrom);
        return ResponseEntity.ok(orders);
    }
}
