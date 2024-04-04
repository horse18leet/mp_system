package org.vyatsu.localApiModule.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vyatsu.localApiModule.dto.response.api.ApiKeyDto;
import org.vyatsu.localApiModule.dto.response.api.item.ItemDto;
import org.vyatsu.localApiModule.dto.response.api.item.OrderDto;
import org.vyatsu.localApiModule.entity.enums.ApiKeyType;
import org.vyatsu.localApiModule.entity.item.Order;
import org.vyatsu.localApiModule.entity.user.ApiKey;
import org.vyatsu.localApiModule.mapper.ApiKeyMapper;
import org.vyatsu.localApiModule.mapper.ItemMapper;
import org.vyatsu.localApiModule.mapper.OrderMapper;
import org.vyatsu.localApiModule.messaging.dto.OrderWBDto;
import org.vyatsu.localApiModule.service.ApiKeyService;
import org.vyatsu.localApiModule.service.ItemService;
import org.vyatsu.localApiModule.service.OrderService;
import org.vyatsu.localApiModule.task.service.ScheduleOrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api-key")
@RequiredArgsConstructor
public class ApiKeyController {

    private final ApiKeyService apiKeyService;
    private final ItemService itemService;
    private final OrderService orderService;

    private final ApiKeyMapper apiKeyMapper;
    private final OrderMapper orderMapper;
    private final ItemMapper itemMapper;

    private final ScheduleOrderService scheduleOrderService;

    @GetMapping
    public ResponseEntity<?> GetAllApiKey(@RequestParam(name = "type", required = false) ApiKeyType type) {
        List<ApiKey> apiKeys = apiKeyService.getAllApiKeyUser(type);
        return ResponseEntity.ok(apiKeyMapper.toDtoList(apiKeys));
    }

    //TODO: провести тестирование
    @PostMapping("/orders")
    public String recordOrdersByDay(OrderWBDto orderWBDto) {
        List<ApiKeyDto> apiKeys = apiKeyMapper.toDtoList(apiKeyService.getAllApiKey(ApiKeyType.WB));

        scheduleOrderService.GetOrdersByApiKeys(apiKeys, "0");
//        ArrayList<LinkedHashMap<String, String>> orders1 = orders.get(0).get(0);
//
//        List<OrderDto> localOrdersDto = null;
//        String vendorCode = null;
//        ItemDto itemDto = null;
//        for(LinkedHashMap<String, String> order : orders1){
//            String vendorCode1 = order.get("supplierArticle");
//            CharSequence orderDate = order.get("date");
//            int finishPrice = Integer.parseInt(order.get("finishedPrice"));
//
//            //если артикул поменялся в заказе, то есть последующий заказ другого товара
//            if(!Objects.equals(vendorCode, vendorCode1)){
//                //достаем товар из нашей базы по артикулу
//                itemDto = itemService.getItemByVendorCode(vendorCode1);
//                //достаем все записанные заказы по данному товару из нашей базы
//                localOrdersDto = orderMapper.toListDto(orderService.getOrdersByItemId(itemDto.getId()));
//                vendorCode = vendorCode1;
//            }
//
//            if(itemDto != null){
//                //если заказ новый, то записываем его в нашу базу
//                //проверка осуществляется путем сравнения дат
//                boolean temp = hasOrderForDate(localOrdersDto, LocalDateTime.parse(orderDate));
//                if(!temp){
//                    Order order1 = new Order();
//                    order1.setCreatedAt(LocalDateTime.parse(orderDate));
//                    order1.setItem(itemMapper.toEntity(itemDto));
//                    order1.setPrice(finishPrice);
//                    orderService.CreateOrder(order1);
//                }
//            }
//        }

        return "";
    }

    private boolean hasOrderForDate(List<OrderDto> localOrdersDto, LocalDateTime date){
        for (OrderDto localOrder : localOrdersDto){
            if(localOrder.getCreatedAt() == date) return true;
        }
        return false;
    }
    @PostMapping
    public ResponseEntity<?> CreateApiKey(@RequestBody ApiKeyDto apiKeyDto) {
        ApiKey createdApiKey = apiKeyService.CreateApiKey(apiKeyMapper.toEntity(apiKeyDto));
        return ResponseEntity.ok(apiKeyMapper.toDto(createdApiKey));
    }
}
