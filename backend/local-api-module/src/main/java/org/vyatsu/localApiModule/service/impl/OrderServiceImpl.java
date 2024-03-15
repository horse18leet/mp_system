package org.vyatsu.localApiModule.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.vyatsu.localApiModule.dto.request.api.OrderReqDto;
import org.vyatsu.localApiModule.entity.item.Order;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.mapper.ApiKeyMapper;
import org.vyatsu.localApiModule.repository.OrderRepository;
import org.vyatsu.localApiModule.security.authentication.impl.AuthenticationFacade;
import org.vyatsu.localApiModule.service.OrderService;
import org.vyatsu.localApiModule.util.HelperUtil;

import java.util.List;

@Repository
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private AuthenticationFacade authenticationFacade;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

    private final ApiKeyServiceImpl apiKeyService;

    private final OrderRepository orderRepository;

    private final ApiKeyMapper apiKeyMapper;

    @Override
    public List<Order> getOrdersByItemId(Long id) {
        return orderRepository.findOrdersByItemId(id);
    }

    @Override
    public Order CreateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public ResponseEntity<Object> getOrders(HttpServletRequest request, OrderReqDto dto) {
        dto.setApiKeys(apiKeyMapper.toDtoList(apiKeyService.getAllApiKeyUser(dto.getApiKeyType())));
        dto.setApiKey(HelperUtil.GetJwtToken(request));
        if(dto.getApiKeys() != null){
            Object result = rabbitTemplate.convertSendAndReceive(directExchange.getName(), "event_get_orders", dto);
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }
}
