package org.vyatsu.localApiModule.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.vyatsu.localApiModule.dto.response.api.ItemDto;

import java.util.List;


public interface ItemService {
    List<ItemDto> getItemsByUser(HttpServletRequest request);
    ItemDto createItem(HttpServletRequest request, ItemDto itemDto);
    List<String> getCategoryByUser(HttpServletRequest request);
}
