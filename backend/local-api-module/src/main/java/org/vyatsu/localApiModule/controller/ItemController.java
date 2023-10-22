package org.vyatsu.localApiModule.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vyatsu.localApiModule.dto.response.api.ItemDto;
import org.vyatsu.localApiModule.service.impl.ItemServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemServiceImpl itemService;

    @PostMapping
    private ResponseEntity<List<ItemDto>> getUserItems(HttpServletRequest request,
                                                       HttpServletResponse response){
        List<ItemDto> userItems = itemService.getItemsByUser(request, response);
        return ResponseEntity.ok(userItems);
    }

    @PostMapping("/create")
    private ResponseEntity<ItemDto> createUserItem(HttpServletRequest request,
                                                   HttpServletResponse response,
                                                   ItemDto itemDto){
        ItemDto createdItem = itemService.createItem(request, response, itemDto);
        return ResponseEntity.ok(createdItem);
    }
}
