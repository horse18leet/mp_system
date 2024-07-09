package org.vyatsu.localApiModule.service.impl;

<<<<<<< Updated upstream
import jakarta.transaction.Transactional;
=======
>>>>>>> Stashed changes
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.vyatsu.localApiModule.dto.response.api.item.ItemDto;
import org.vyatsu.localApiModule.entity.item.Item;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.mapper.ItemMapper;
import org.vyatsu.localApiModule.mapper.UserMapper;
import org.vyatsu.localApiModule.repository.ItemRepository;
import org.vyatsu.localApiModule.security.authentication.impl.AuthenticationFacade;
import org.vyatsu.localApiModule.security.utils.JwtUtils;
import org.vyatsu.localApiModule.service.ItemService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final AuthenticationFacade authenticationFacade;

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;
    private final UserMapper userMapper;

    private final JwtUtils jwtUtils;

    @Override
    public List<ItemDto> getItemsByUser(boolean isDraft) {
        User user = authenticationFacade.getAuthenticationUser();
        List<ItemDto> userItemsDto = new ArrayList<>();
        if (user != null) {
            List<Item> userItems = itemRepository.findItemByUserAndIsDraft(user, isDraft).stream().filter(Item::getIsActive).toList();
            userItemsDto = itemMapper.toDtoList(userItems);
        }

        return userItemsDto;
    }

    @Override
    public ItemDto createItem(@RequestBody ItemDto itemDto){
        User user = authenticationFacade.getAuthenticationUser();

        Item item = Item.builder()
                .title(itemDto.getTitle())
                .description(itemDto.getDescription())
                .firstPrice(itemDto.getFirstPrice())
                .category(itemDto.getCategory())
                .user(user)
                .isActive(true)
                .createdAt(LocalDateTime.now())
                .isDraft(true)
                .build();

        Item createdItem = itemRepository.save(item);
        return itemMapper.toDto(createdItem);
    }

    @Override
    public List<String> getCategoryByUser(){
        User user = authenticationFacade.getAuthenticationUser();

        List<String> categories = new ArrayList<>();
        if(user != null) categories = itemRepository.findUniqueCategoryByUserId(user.getId());

        return categories;
    }

    @Override
    public void deleteUserItemById(Long id) {
        User user = authenticationFacade.getAuthenticationUser();
<<<<<<< Updated upstream
        Item item = itemRepository.findById(itemReqDto.getId()).get();
=======
        Item item = itemRepository.findById(id).get();
>>>>>>> Stashed changes
        if(item.getUser() == user){
            item.setIsActive(false);
            itemRepository.save(item);
        }
    }

    @Override
    public ItemDto getUserItemById(Long id) {
        User user = authenticationFacade.getAuthenticationUser();
        Optional<Item> item = itemRepository.findById(id);
        ItemDto itemDto = null;
        if(item.isPresent()){
            if(Objects.equals(user, item.get().getUser())){
                itemDto = itemMapper.toDto(item.get());
            }
        }
        return itemDto;
    }

    @Override
    public ItemDto editUserItem(ItemDto itemDto) {
        User user = authenticationFacade.getAuthenticationUser();
        Optional<Item> item = itemRepository.findById(itemDto.getId());
        Item editedItem = null;
        if(item.isPresent()){
            if(Objects.equals(user, item.get().getUser())){
                editedItem = itemRepository.save(itemMapper.toEntity(itemDto));
            }
        }
        return itemMapper.toDto(editedItem);
    }

    @Override
    public ItemDto getItemByVendorCode(String vendorCode) {
        Item item = itemRepository.findByVendorCode(vendorCode);
        return itemMapper.toDto(item);
    }

}
