package org.vyatsu.localApiModule.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vyatsu.localApiModule.dto.request.api.ItemReqDto;
import org.vyatsu.localApiModule.dto.response.api.item.ItemDto;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.security.UserDetailsImpl;
import org.vyatsu.localApiModule.security.authentication.impl.AuthenticationFacade;
import org.vyatsu.localApiModule.service.impl.ItemServiceImpl;
import org.vyatsu.localApiModule.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final AuthenticationFacade authenticationFacade;

    private final ItemServiceImpl itemService;
    private final UserServiceImpl userService;

    // получение товаров
    // isDraft == true - получение только товаров-черновиков
    // isDraft == false - получение только импортированных товаров
    @GetMapping
    private ResponseEntity<List<ItemDto>> getUserItems(@RequestParam("isDraft") boolean isDraft){
        User user = authenticationFacade.getAuthenticationUser();
        List<ItemDto> userItems = itemService.getItemsByUser(isDraft);
        return ResponseEntity.ok(userItems);
    }

    // получение товара по айди
    @GetMapping("/{id}")
    private ResponseEntity<ItemDto> getUserItem(@PathVariable Long id){
        ItemDto userItem = itemService.getUserItemById(id);
        return ResponseEntity.ok(userItem);
    }

    //добавление товара (шаблона)
    @PostMapping("/create")
    private ResponseEntity<ItemDto> createUserItem(@RequestBody ItemDto itemDto){
        ItemDto createdItem = itemService.createItem(itemDto);
        return ResponseEntity.ok(createdItem);
    }

    // редактирование товара
    @PutMapping("/edit")
    private ResponseEntity<ItemDto> editUserItem(@RequestBody ItemDto itemDto){
        ItemDto editedItem = itemService.editUserItem(itemDto);
        return ResponseEntity.ok(editedItem);
    }

    // получение пользовательских категорий товара
    @PostMapping("/category")
    private ResponseEntity<List<String>> getUserCategory(){
        List<String> userCategories = itemService.getCategoryByUser();
        return ResponseEntity.ok(userCategories);
    }

    // удаление товара
    @PostMapping("/drop")
    private ResponseEntity<Void> deleteUserItem(@RequestBody ItemReqDto itemReqDto){
        itemService.deleteUserItemById(itemReqDto);
        return ResponseEntity.ok().build();
    }
}
