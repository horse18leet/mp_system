package org.vyatsu.localApiModule.service;

import jakarta.servlet.http.HttpServletRequest;
import org.vyatsu.localApiModule.dto.response.api.item.ItemDto;

import java.util.List;


public interface ItemService {
    List<ItemDto> getItemsByUser(HttpServletRequest request);
    ItemDto createItem(HttpServletRequest request, ItemDto itemDto);
    List<String> getCategoryByUser(HttpServletRequest request);
}
