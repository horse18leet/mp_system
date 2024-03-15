package org.vyatsu.localApiModule.service;

import jakarta.servlet.http.HttpServletRequest;
import org.vyatsu.localApiModule.dto.request.api.ItemReqDto;
import org.vyatsu.localApiModule.dto.response.api.item.ItemDto;
import org.vyatsu.localApiModule.entity.user.User;

import java.util.List;


public interface ItemService {
    List<ItemDto> getItemsByUser(boolean isDraft);

    ItemDto createItem(ItemDto itemDto);
    List<String> getCategoryByUser();
    void deleteUserItemById(ItemReqDto itemReqDto);
    ItemDto getUserItemById(Long id);

    ItemDto editUserItem(ItemDto itemDto);

    ItemDto getItemByVendorCode(String vendorCode);

}
