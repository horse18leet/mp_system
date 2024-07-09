package org.vyatsu.localApiModule.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.vyatsu.localApiModule.dto.request.api.OrderReqDto;
import org.vyatsu.localApiModule.dto.response.api.OrderDto;
import org.vyatsu.localApiModule.entity.item.Order;
import org.vyatsu.localApiModule.messaging.dto.OrderWBDto;
import org.vyatsu.localApiModule.messaging.dto.SaleWBDto;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

    List<Order> getOrdersByItemId(Long id);
    Order CreateOrder(Order order);

    //не трогать servlet
    ResponseEntity<Object> getOrders(HttpServletRequest request, OrderReqDto dto);

    void createWBOrder(OrderWBDto orderWBDto);
    void createWBSale(SaleWBDto saleWBDto);

    List<OrderDto> getOrdersByDateFrom(LocalDateTime dateFrom);

    void processRealizationReportData(String message) throws JsonProcessingException;
}
