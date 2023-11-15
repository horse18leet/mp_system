package org.vyatsu.localApiModule.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.vyatsu.localApiModule.dto.response.api.item.ItemDto;
import org.vyatsu.localApiModule.dto.response.api.item.SimpleUserDto;
import org.vyatsu.localApiModule.entity.item.Item;
import org.vyatsu.localApiModule.entity.user.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-15T12:06:56+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item toEntity(ItemDto itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        Item item = new Item();

        item.setId( itemDto.getId() );
        item.setTitle( itemDto.getTitle() );
        item.setDescription( itemDto.getDescription() );
        item.setFirstPrice( itemDto.getFirstPrice() );
        item.setUser( simpleUserDtoToUser( itemDto.getUser() ) );
        item.setCategory( itemDto.getCategory() );
        item.setMpLink( itemDto.getMpLink() );
        item.setIsActive( itemDto.getIsActive() );
        item.setCreatedAt( itemDto.getCreatedAt() );

        return item;
    }

    @Override
    public ItemDto toDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto.ItemDtoBuilder itemDto = ItemDto.builder();

        itemDto.id( item.getId() );
        itemDto.title( item.getTitle() );
        itemDto.description( item.getDescription() );
        itemDto.firstPrice( item.getFirstPrice() );
        itemDto.user( userToSimpleUserDto( item.getUser() ) );
        itemDto.category( item.getCategory() );
        itemDto.mpLink( item.getMpLink() );
        itemDto.isActive( item.getIsActive() );
        itemDto.createdAt( item.getCreatedAt() );

        return itemDto.build();
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
        if ( itemDto.getUser() != null ) {
            if ( item.getUser() == null ) {
                item.setUser( User.builder().build() );
            }
            simpleUserDtoToUser1( itemDto.getUser(), item.getUser() );
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

    @Override
    public List<Item> toEntityList(List<ItemDto> itemDtoList) {
        if ( itemDtoList == null ) {
            return null;
        }

        List<Item> list = new ArrayList<Item>( itemDtoList.size() );
        for ( ItemDto itemDto : itemDtoList ) {
            list.add( toEntity( itemDto ) );
        }

        return list;
    }

    @Override
    public List<ItemDto> toDtoList(List<Item> itemList) {
        if ( itemList == null ) {
            return null;
        }

        List<ItemDto> list = new ArrayList<ItemDto>( itemList.size() );
        for ( Item item : itemList ) {
            list.add( toDto( item ) );
        }

        return list;
    }

    protected User simpleUserDtoToUser(SimpleUserDto simpleUserDto) {
        if ( simpleUserDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( simpleUserDto.getId() );

        return user.build();
    }

    protected SimpleUserDto userToSimpleUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        SimpleUserDto.SimpleUserDtoBuilder simpleUserDto = SimpleUserDto.builder();

        simpleUserDto.id( user.getId() );

        return simpleUserDto.build();
    }

    protected void simpleUserDtoToUser1(SimpleUserDto simpleUserDto, User mappingTarget) {
        if ( simpleUserDto == null ) {
            return;
        }

        mappingTarget.setId( simpleUserDto.getId() );
    }
}
