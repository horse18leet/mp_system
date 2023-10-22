package org.vyatsu.localApiModule.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.catalina.UserDatabase;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.vyatsu.localApiModule.dto.response.api.ItemDto;
import org.vyatsu.localApiModule.dto.response.api.UserDto;
import org.vyatsu.localApiModule.entity.item.Item;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.mapper.ItemMapper;
import org.vyatsu.localApiModule.mapper.UserMapper;
import org.vyatsu.localApiModule.repository.ItemRepository;
import org.vyatsu.localApiModule.security.JwtAuthenticationService;
import org.vyatsu.localApiModule.service.ItemService;
import org.vyatsu.localApiModule.service.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    private final JwtAuthenticationService jwtAuthenticationService;
    private final UserService userService;

    private final ItemMapper itemMapper;
    private final UserMapper userMapper;

    public List<ItemDto> getItemsByUser(HttpServletRequest request, HttpServletResponse response) {
        User user = getUserByReq(request);
        if (user != null) {
            List<Item> userItems = itemRepository.findByUserId(user.getId());
            return itemMapper.toDtoList(userItems);
        }
        return null;
    }

    public ItemDto createItem(HttpServletRequest request, HttpServletResponse response, @RequestBody ItemDto itemDto){
        User user = getUserByReq(request);

        itemDto.setUser(userMapper.toDto(user));
        Item createdItem = itemRepository.save(itemMapper.toEntity(itemDto));
        return itemMapper.toDto(createdItem);
    }

    private User getUserByReq(HttpServletRequest req){
        final String authHeader = req.getHeader(HttpHeaders.AUTHORIZATION);
        final String jwt;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) return null;

        jwt = authHeader.substring(7);
        String email = jwtAuthenticationService.extractUsername(jwt);
        if(email != null){
            return userService.getUserByEmail(email);
        }
        return null;
    }
}
