package org.vyatsu.localApiModule.service;

import jakarta.servlet.http.HttpServletRequest;
import org.vyatsu.localApiModule.dto.request.api.ItemReqDto;
import org.vyatsu.localApiModule.dto.response.api.item.ItemDto;

import java.util.List;


public interface ItemService {
    List<ItemDto> getItemsByUser(HttpServletRequest request, boolean isDraft);

    ItemDto createItem(HttpServletRequest request, ItemDto itemDto);
    List<String> getCategoryByUser(HttpServletRequest request);
    void deleteUserItemById(HttpServletRequest req, ItemReqDto itemReqDto);
    ItemDto getUserItemById(HttpServletRequest req, Long id);

    ItemDto editUserItem(HttpServletRequest request, ItemDto itemDto);

    ItemDto getItemByVendorCode(String vendorCode);

}
