package org.vyatsu.localApiModule.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vyatsu.localApiModule.dto.response.api.item.ItemDto;
import org.vyatsu.localApiModule.service.impl.ItemServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemServiceImpl itemService;

    @PostMapping
    private ResponseEntity<List<ItemDto>> getUserItems(HttpServletRequest request){
        List<ItemDto> userItems = itemService.getItemsByUser(request);
        return ResponseEntity.ok(userItems);
    }

    @PostMapping("/create")
    private ResponseEntity<ItemDto> createUserItem(HttpServletRequest request, @RequestBody ItemDto itemDto){
        ItemDto createdItem = itemService.createItem(request, itemDto);
        return ResponseEntity.ok(createdItem);
    }

    @PostMapping("/category")
    private ResponseEntity<List<String>> getUserCategory(HttpServletRequest request){
        List<String> userCategories = itemService.getCategoryByUser(request);
        return ResponseEntity.ok(userCategories);
    }
}
