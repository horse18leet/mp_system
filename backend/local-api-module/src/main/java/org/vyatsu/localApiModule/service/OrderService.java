package org.vyatsu.localApiModule.service;

import org.vyatsu.localApiModule.dto.response.api.item.OrderDto;
import org.vyatsu.localApiModule.entity.item.Order;
import org.vyatsu.localApiModule.repository.OrderRepository;

import java.util.List;

public interface OrderService {

    List<Order> getOrdersByItemId(Long id);
    Order CreateOrder(Order order);
}
