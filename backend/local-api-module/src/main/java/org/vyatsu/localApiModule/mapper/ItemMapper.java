package org.vyatsu.localApiModule.mapper;

import org.mapstruct.*;
import org.vyatsu.localApiModule.dto.response.api.item.ItemDto;
import org.vyatsu.localApiModule.entity.item.Item;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ItemMapper {
    Item toEntity(ItemDto itemDto);

    ItemDto toDto(Item item);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Item partialUpdate(ItemDto itemDto, @MappingTarget Item item);

    List<Item> toEntityList(List<ItemDto> itemDtoList);

    List<ItemDto> toDtoList(List<Item> itemList);
}