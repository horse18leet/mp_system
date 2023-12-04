package org.vyatsu.localApiModule.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.vyatsu.localApiModule.entity.item.Order;
import org.vyatsu.localApiModule.repository.OrderRepository;
import org.vyatsu.localApiModule.service.OrderService;

import java.util.List;

@Repository
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public List<Order> getOrdersByItemId(Long id) {
        return orderRepository.findOrdersByItemId(id);
    }

    @Override
    public Order CreateOrder(Order order) {
        return orderRepository.save(order);
    }
}
