package org.vyatsu.localApiModule.service;

import org.vyatsu.localApiModule.dto.response.api.item.ItemDto;

import java.util.List;


public interface ItemService {
    List<ItemDto> getItemsByUser(boolean isDraft);

    ItemDto createItem(ItemDto itemDto);
    List<String> getCategoryByUser();
    void deleteUserItemById(Long id);
    ItemDto getUserItemById(Long id);

    ItemDto editUserItem(ItemDto itemDto);

    ItemDto getItemByVendorCode(String vendorCode);

}
