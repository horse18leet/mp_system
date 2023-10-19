package org.vyatsu.localApiModule.mapper;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.vyatsu.localApiModule.dto.response.api.ItemDto;
import org.vyatsu.localApiModule.entity.item.Item;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-19T19:18:26+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item toEntity(ItemDto itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        Item.ItemBuilder item = Item.builder();

        item.id( itemDto.getId() );
        item.title( itemDto.getTitle() );
        item.description( itemDto.getDescription() );
        item.firstPrice( itemDto.getFirstPrice() );
        item.category( itemDto.getCategory() );
        item.mpLink( itemDto.getMpLink() );
        item.isActive( itemDto.getIsActive() );
        item.createdAt( itemDto.getCreatedAt() );

        return item.build();
    }

    @Override
    public ItemDto toDto(Item item) {
        if ( item == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String description = null;
        Double firstPrice = null;
        String category = null;
        String mpLink = null;
        Boolean isActive = null;
        LocalDate createdAt = null;

        id = item.getId();
        title = item.getTitle();
        description = item.getDescription();
        firstPrice = item.getFirstPrice();
        category = item.getCategory();
        mpLink = item.getMpLink();
        isActive = item.getIsActive();
        createdAt = item.getCreatedAt();

        ItemDto itemDto = new ItemDto( id, title, description, firstPrice, category, mpLink, isActive, createdAt );

        return itemDto;
    }

    @Override
    public Item partialUpdate(ItemDto itemDto, Item item) {
        if ( itemDto == null ) {
            return item;
        }

        if ( itemDto.getId() != null ) {
            item.setId( itemDto.getId() );
        }
        if ( itemDto.getTitle() != null ) {
            item.setTitle( itemDto.getTitle() );
        }
        if ( itemDto.getDescription() != null ) {
            item.setDescription( itemDto.getDescription() );
        }
        if ( itemDto.getFirstPrice() != null ) {
            item.setFirstPrice( itemDto.getFirstPrice() );
        }
        if ( itemDto.getCategory() != null ) {
            item.setCategory( itemDto.getCategory() );
        }
        if ( itemDto.getMpLink() != null ) {
            item.setMpLink( itemDto.getMpLink() );
        }
        if ( itemDto.getIsActive() != null ) {
            item.setIsActive( itemDto.getIsActive() );
        }
        if ( itemDto.getCreatedAt() != null ) {
            item.setCreatedAt( itemDto.getCreatedAt() );
        }

        return item;
    }
}
