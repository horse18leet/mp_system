package org.vyatsu.localApiModule.mapper;

import org.mapstruct.*;
import org.vyatsu.localApiModule.dto.response.api.ItemDto;
import org.vyatsu.localApiModule.entity.item.Item;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ItemMapper {
    Item toEntity(ItemDto itemDto);

    ItemDto toDto(Item item);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Item partialUpdate(ItemDto itemDto, @MappingTarget Item item);
}