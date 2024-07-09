package org.vyatsu.localApiModule.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vyatsu.localApiModule.dto.request.api.ItemReqDto;
import org.vyatsu.localApiModule.dto.response.api.item.ItemDto;
import org.vyatsu.localApiModule.entity.user.User;
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

    /** Получение товаров
    isDraft == true - получение только товаров-черновиков
    isDraft == false - получение только импортированных товаров */


    @GetMapping
    private ResponseEntity<List<ItemDto>> getUserItems(@RequestParam("isDraft") boolean isDraft){
        List<ItemDto> userItems = itemService.getItemsByUser(isDraft);
        return ResponseEntity.ok(userItems);
    }

    /** Получение товара по айди */
    @GetMapping("/{id}")
    private ResponseEntity<ItemDto> getUserItem(@PathVariable Long id){
        ItemDto userItem = itemService.getUserItemById(id);
        return ResponseEntity.ok(userItem);
    }

    /** Добавление товара (шаблона) */
    @PostMapping("/create")
    private ResponseEntity<ItemDto> createUserItem(@RequestBody ItemDto itemDto){
        ItemDto createdItem = itemService.createItem(itemDto);
        return ResponseEntity.ok(createdItem);
    }

    /** Редактирование товара */
    @PutMapping("/edit")
    private ResponseEntity<ItemDto> editUserItem(@RequestBody ItemDto itemDto){
        ItemDto editedItem = itemService.editUserItem(itemDto);
        return ResponseEntity.ok(editedItem);
    }

    /** Получение пользовательских категорий товара */
<<<<<<< Updated upstream
    @PostMapping("/category")
=======
    @GetMapping("/category")
>>>>>>> Stashed changes
    private ResponseEntity<List<String>> getUserCategory(){
        List<String> userCategories = itemService.getCategoryByUser();
        return ResponseEntity.ok(userCategories);
    }

    /** Удаление товара */
<<<<<<< Updated upstream
    @PostMapping("/drop")
    private ResponseEntity<Void> deleteUserItem(@RequestBody ItemReqDto itemReqDto){
        itemService.deleteUserItemById(itemReqDto);
=======
    @DeleteMapping("/drop/{id}")
    private ResponseEntity<Void> deleteUserItem(@PathVariable Long id){
        itemService.deleteUserItemById(id);
>>>>>>> Stashed changes
        return ResponseEntity.ok().build();
    }
}
