package org.vyatsu.localApiModule.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.vyatsu.localApiModule.dto.response.api.ItemDto;

import java.util.List;


public interface ItemService {
    List<ItemDto> getItemsByUser(HttpServletRequest request, HttpServletResponse response);
}
