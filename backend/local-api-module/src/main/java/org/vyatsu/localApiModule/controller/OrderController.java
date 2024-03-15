package org.vyatsu.localApiModule.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vyatsu.localApiModule.dto.request.api.OrderReqDto;
import org.vyatsu.localApiModule.service.OrderService;

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
}
