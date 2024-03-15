package org.vyatsu.localApiModule.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.vyatsu.localApiModule.dto.request.api.OrderReqDto;
import org.vyatsu.localApiModule.entity.item.Order;

import java.util.List;

public interface OrderService {

    List<Order> getOrdersByItemId(Long id);
    Order CreateOrder(Order order);

    //не трогать servlet
    ResponseEntity<Object> getOrders(HttpServletRequest request, OrderReqDto dto);
}
