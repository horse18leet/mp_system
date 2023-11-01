package org.vyatsu.localApiModule.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vyatsu.localApiModule.dto.request.api.ItemReqDto;
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

    @GetMapping("/{id}")
    private ResponseEntity<ItemDto> getUserItem(HttpServletRequest request, @PathVariable Long id){
        ItemDto userItem = itemService.getUserItemById(request, id);
        return ResponseEntity.ok(userItem);
    }

    @PostMapping("/create")
    private ResponseEntity<ItemDto> createUserItem(HttpServletRequest request, @RequestBody ItemDto itemDto){
        ItemDto createdItem = itemService.createItem(request, itemDto);
        return ResponseEntity.ok(createdItem);
    }

    @PutMapping("/edit")
    private ResponseEntity<ItemDto> editUserItem(HttpServletRequest request, @RequestBody ItemDto itemDto){
        ItemDto editedItem = itemService.editUserItem(request, itemDto);
        return ResponseEntity.ok(editedItem);
    }

    @PostMapping("/category")
    private ResponseEntity<List<String>> getUserCategory(HttpServletRequest request){
        List<String> userCategories = itemService.getCategoryByUser(request);
        return ResponseEntity.ok(userCategories);
    }

    @PostMapping("/drop")
    private ResponseEntity<Void> deleteUserItem(HttpServletRequest request, @RequestBody ItemReqDto itemReqDto){
        itemService.deleteUserItemById(request, itemReqDto);
        return ResponseEntity.ok().build();
    }
}
