package org.vyatsu.localApiModule.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.vyatsu.localApiModule.dto.response.api.ApiKeyDto;
import org.vyatsu.localApiModule.dto.response.api.ItemDto;
import org.vyatsu.localApiModule.dto.response.api.PurchaseDto;
import org.vyatsu.localApiModule.dto.response.api.RoleDto;
import org.vyatsu.localApiModule.dto.response.api.ToDoTaskDto;
import org.vyatsu.localApiModule.dto.response.api.TokenDto;
import org.vyatsu.localApiModule.dto.response.api.UserDto;
import org.vyatsu.localApiModule.entity.enums.RoleType;
import org.vyatsu.localApiModule.entity.enums.TokenType;
import org.vyatsu.localApiModule.entity.item.Item;
import org.vyatsu.localApiModule.entity.msg.Message;
import org.vyatsu.localApiModule.entity.purchase.Purchase;
import org.vyatsu.localApiModule.entity.role.Role;
import org.vyatsu.localApiModule.entity.sub.UserSubscription;
import org.vyatsu.localApiModule.entity.user.ApiKey;
import org.vyatsu.localApiModule.entity.user.ToDoTask;
import org.vyatsu.localApiModule.entity.user.Token;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.entity.user.UserPreference;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-22T19:23:12+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
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
        item.setUser( userDtoToUser( itemDto.getUser() ) );
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

        ItemDto itemDto = new ItemDto();

        itemDto.setId( item.getId() );
        itemDto.setTitle( item.getTitle() );
        itemDto.setDescription( item.getDescription() );
        itemDto.setFirstPrice( item.getFirstPrice() );
        itemDto.setUser( userToUserDto( item.getUser() ) );
        itemDto.setCategory( item.getCategory() );
        itemDto.setMpLink( item.getMpLink() );
        itemDto.setIsActive( item.getIsActive() );
        itemDto.setCreatedAt( item.getCreatedAt() );

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
        if ( itemDto.getUser() != null ) {
            if ( item.getUser() == null ) {
                item.setUser( User.builder().build() );
            }
            userDtoToUser1( itemDto.getUser(), item.getUser() );
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

    protected Set<Item> itemDtoSetToItemSet(Set<ItemDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Item> set1 = new LinkedHashSet<Item>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ItemDto itemDto : set ) {
            set1.add( toEntity( itemDto ) );
        }

        return set1;
    }

    protected Purchase purchaseDtoToPurchase(PurchaseDto purchaseDto) {
        if ( purchaseDto == null ) {
            return null;
        }

        Purchase.PurchaseBuilder purchase = Purchase.builder();

        purchase.id( purchaseDto.getId() );
        purchase.cost( purchaseDto.getCost() );
        purchase.createdAt( purchaseDto.getCreatedAt() );

        return purchase.build();
    }

    protected Set<Purchase> purchaseDtoSetToPurchaseSet(Set<PurchaseDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Purchase> set1 = new LinkedHashSet<Purchase>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PurchaseDto purchaseDto : set ) {
            set1.add( purchaseDtoToPurchase( purchaseDto ) );
        }

        return set1;
    }

    protected ToDoTask toDoTaskDtoToToDoTask(ToDoTaskDto toDoTaskDto) {
        if ( toDoTaskDto == null ) {
            return null;
        }

        ToDoTask.ToDoTaskBuilder toDoTask = ToDoTask.builder();

        toDoTask.id( toDoTaskDto.getId() );
        toDoTask.title( toDoTaskDto.getTitle() );
        toDoTask.description( toDoTaskDto.getDescription() );
        toDoTask.dueDate( toDoTaskDto.getDueDate() );
        toDoTask.isCompleted( toDoTaskDto.getIsCompleted() );
        toDoTask.createdAt( toDoTaskDto.getCreatedAt() );

        return toDoTask.build();
    }

    protected Set<ToDoTask> toDoTaskDtoSetToToDoTaskSet(Set<ToDoTaskDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<ToDoTask> set1 = new LinkedHashSet<ToDoTask>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ToDoTaskDto toDoTaskDto : set ) {
            set1.add( toDoTaskDtoToToDoTask( toDoTaskDto ) );
        }

        return set1;
    }

    protected ApiKey apiKeyDtoToApiKey(ApiKeyDto apiKeyDto) {
        if ( apiKeyDto == null ) {
            return null;
        }

        ApiKey.ApiKeyBuilder apiKey = ApiKey.builder();

        apiKey.id( apiKeyDto.getId() );
        apiKey.key( apiKeyDto.getKey() );
        apiKey.createdAt( apiKeyDto.getCreatedAt() );

        return apiKey.build();
    }

    protected Set<ApiKey> apiKeyDtoSetToApiKeySet(Set<ApiKeyDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<ApiKey> set1 = new LinkedHashSet<ApiKey>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ApiKeyDto apiKeyDto : set ) {
            set1.add( apiKeyDtoToApiKey( apiKeyDto ) );
        }

        return set1;
    }

    protected Token tokenDtoToToken(TokenDto tokenDto) {
        if ( tokenDto == null ) {
            return null;
        }

        Token.TokenBuilder token = Token.builder();

        token.id( tokenDto.getId() );
        token.token( tokenDto.getToken() );
        token.type( tokenDto.getType() );
        token.revoked( tokenDto.isRevoked() );
        token.expired( tokenDto.isExpired() );

        return token.build();
    }

    protected Set<Token> tokenDtoSetToTokenSet(Set<TokenDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Token> set1 = new LinkedHashSet<Token>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TokenDto tokenDto : set ) {
            set1.add( tokenDtoToToken( tokenDto ) );
        }

        return set1;
    }

    protected Role roleDtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.id( roleDto.getId() );
        role.name( roleDto.getName() );

        return role.build();
    }

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userDto.getId() );
        user.email( userDto.getEmail() );
        user.password( userDto.getPassword() );
        user.firstName( userDto.getFirstName() );
        user.secondName( userDto.getSecondName() );
        user.phoneNum( userDto.getPhoneNum() );
        user.isActive( userDto.getIsActive() );
        user.createdAt( userDto.getCreatedAt() );
        Set<UserPreference> set = userDto.getUserPreferences();
        if ( set != null ) {
            user.userPreferences( new LinkedHashSet<UserPreference>( set ) );
        }
        Set<UserSubscription> set1 = userDto.getUserSubscriptions();
        if ( set1 != null ) {
            user.userSubscriptions( new LinkedHashSet<UserSubscription>( set1 ) );
        }
        Set<Message> set2 = userDto.getUserFromMessages();
        if ( set2 != null ) {
            user.userFromMessages( new LinkedHashSet<Message>( set2 ) );
        }
        Set<Message> set3 = userDto.getUserToMessages();
        if ( set3 != null ) {
            user.userToMessages( new LinkedHashSet<Message>( set3 ) );
        }
        user.items( itemDtoSetToItemSet( userDto.getItems() ) );
        user.purchases( purchaseDtoSetToPurchaseSet( userDto.getPurchases() ) );
        user.toDoTasks( toDoTaskDtoSetToToDoTaskSet( userDto.getToDoTasks() ) );
        user.apiKeys( apiKeyDtoSetToApiKeySet( userDto.getApiKeys() ) );
        user.tokens( tokenDtoSetToTokenSet( userDto.getTokens() ) );
        user.role( roleDtoToRole( userDto.getRole() ) );

        return user.build();
    }

    protected Set<ItemDto> itemSetToItemDtoSet(Set<Item> set) {
        if ( set == null ) {
            return null;
        }

        Set<ItemDto> set1 = new LinkedHashSet<ItemDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Item item : set ) {
            set1.add( toDto( item ) );
        }

        return set1;
    }

    protected PurchaseDto purchaseToPurchaseDto(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        Long id = null;
        double cost = 0.0d;
        LocalDate createdAt = null;

        id = purchase.getId();
        cost = purchase.getCost();
        createdAt = purchase.getCreatedAt();

        PurchaseDto purchaseDto = new PurchaseDto( id, cost, createdAt );

        return purchaseDto;
    }

    protected Set<PurchaseDto> purchaseSetToPurchaseDtoSet(Set<Purchase> set) {
        if ( set == null ) {
            return null;
        }

        Set<PurchaseDto> set1 = new LinkedHashSet<PurchaseDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Purchase purchase : set ) {
            set1.add( purchaseToPurchaseDto( purchase ) );
        }

        return set1;
    }

    protected ToDoTaskDto toDoTaskToToDoTaskDto(ToDoTask toDoTask) {
        if ( toDoTask == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String description = null;
        LocalDate dueDate = null;
        Boolean isCompleted = null;
        LocalDate createdAt = null;

        id = toDoTask.getId();
        title = toDoTask.getTitle();
        description = toDoTask.getDescription();
        dueDate = toDoTask.getDueDate();
        isCompleted = toDoTask.getIsCompleted();
        createdAt = toDoTask.getCreatedAt();

        ToDoTaskDto toDoTaskDto = new ToDoTaskDto( id, title, description, dueDate, isCompleted, createdAt );

        return toDoTaskDto;
    }

    protected Set<ToDoTaskDto> toDoTaskSetToToDoTaskDtoSet(Set<ToDoTask> set) {
        if ( set == null ) {
            return null;
        }

        Set<ToDoTaskDto> set1 = new LinkedHashSet<ToDoTaskDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ToDoTask toDoTask : set ) {
            set1.add( toDoTaskToToDoTaskDto( toDoTask ) );
        }

        return set1;
    }

    protected ApiKeyDto apiKeyToApiKeyDto(ApiKey apiKey) {
        if ( apiKey == null ) {
            return null;
        }

        Long id = null;
        String key = null;
        LocalDate createdAt = null;

        id = apiKey.getId();
        key = apiKey.getKey();
        createdAt = apiKey.getCreatedAt();

        ApiKeyDto apiKeyDto = new ApiKeyDto( id, key, createdAt );

        return apiKeyDto;
    }

    protected Set<ApiKeyDto> apiKeySetToApiKeyDtoSet(Set<ApiKey> set) {
        if ( set == null ) {
            return null;
        }

        Set<ApiKeyDto> set1 = new LinkedHashSet<ApiKeyDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ApiKey apiKey : set ) {
            set1.add( apiKeyToApiKeyDto( apiKey ) );
        }

        return set1;
    }

    protected TokenDto tokenToTokenDto(Token token) {
        if ( token == null ) {
            return null;
        }

        Long id = null;
        String token1 = null;
        TokenType type = null;
        boolean revoked = false;
        boolean expired = false;

        id = token.getId();
        token1 = token.getToken();
        type = token.getType();
        revoked = token.isRevoked();
        expired = token.isExpired();

        TokenDto tokenDto = new TokenDto( id, token1, type, revoked, expired );

        return tokenDto;
    }

    protected Set<TokenDto> tokenSetToTokenDtoSet(Set<Token> set) {
        if ( set == null ) {
            return null;
        }

        Set<TokenDto> set1 = new LinkedHashSet<TokenDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Token token : set ) {
            set1.add( tokenToTokenDto( token ) );
        }

        return set1;
    }

    protected RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        Long id = null;
        RoleType name = null;

        id = role.getId();
        name = role.getName();

        RoleDto roleDto = new RoleDto( id, name );

        return roleDto;
    }

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        Set<UserPreference> userPreferences = null;
        Set<UserSubscription> userSubscriptions = null;
        Set<Message> userFromMessages = null;
        Set<Message> userToMessages = null;
        Set<ItemDto> items = null;
        Set<PurchaseDto> purchases = null;
        Set<ToDoTaskDto> toDoTasks = null;
        Set<ApiKeyDto> apiKeys = null;
        Set<TokenDto> tokens = null;
        Long id = null;
        String email = null;
        String password = null;
        String firstName = null;
        String secondName = null;
        String phoneNum = null;
        Boolean isActive = null;
        LocalDate createdAt = null;
        RoleDto role = null;

        Set<UserPreference> set = user.getUserPreferences();
        if ( set != null ) {
            userPreferences = new LinkedHashSet<UserPreference>( set );
        }
        Set<UserSubscription> set1 = user.getUserSubscriptions();
        if ( set1 != null ) {
            userSubscriptions = new LinkedHashSet<UserSubscription>( set1 );
        }
        Set<Message> set2 = user.getUserFromMessages();
        if ( set2 != null ) {
            userFromMessages = new LinkedHashSet<Message>( set2 );
        }
        Set<Message> set3 = user.getUserToMessages();
        if ( set3 != null ) {
            userToMessages = new LinkedHashSet<Message>( set3 );
        }
        items = itemSetToItemDtoSet( user.getItems() );
        purchases = purchaseSetToPurchaseDtoSet( user.getPurchases() );
        toDoTasks = toDoTaskSetToToDoTaskDtoSet( user.getToDoTasks() );
        apiKeys = apiKeySetToApiKeyDtoSet( user.getApiKeys() );
        tokens = tokenSetToTokenDtoSet( user.getTokens() );
        id = user.getId();
        email = user.getEmail();
        password = user.getPassword();
        firstName = user.getFirstName();
        secondName = user.getSecondName();
        phoneNum = user.getPhoneNum();
        isActive = user.getIsActive();
        createdAt = user.getCreatedAt();
        role = roleToRoleDto( user.getRole() );

        UserDto userDto = new UserDto( id, email, password, firstName, secondName, phoneNum, isActive, createdAt, userPreferences, userSubscriptions, userFromMessages, userToMessages, items, purchases, toDoTasks, apiKeys, tokens, role );

        return userDto;
    }

    protected void roleDtoToRole1(RoleDto roleDto, Role mappingTarget) {
        if ( roleDto == null ) {
            return;
        }

        mappingTarget.setId( roleDto.getId() );
        mappingTarget.setName( roleDto.getName() );
    }

    protected void userDtoToUser1(UserDto userDto, User mappingTarget) {
        if ( userDto == null ) {
            return;
        }

        mappingTarget.setId( userDto.getId() );
        mappingTarget.setEmail( userDto.getEmail() );
        mappingTarget.setPassword( userDto.getPassword() );
        mappingTarget.setFirstName( userDto.getFirstName() );
        mappingTarget.setSecondName( userDto.getSecondName() );
        mappingTarget.setPhoneNum( userDto.getPhoneNum() );
        mappingTarget.setIsActive( userDto.getIsActive() );
        mappingTarget.setCreatedAt( userDto.getCreatedAt() );
        if ( mappingTarget.getUserPreferences() != null ) {
            Set<UserPreference> set = userDto.getUserPreferences();
            if ( set != null ) {
                mappingTarget.getUserPreferences().clear();
                mappingTarget.getUserPreferences().addAll( set );
            }
            else {
                mappingTarget.setUserPreferences( null );
            }
        }
        else {
            Set<UserPreference> set = userDto.getUserPreferences();
            if ( set != null ) {
                mappingTarget.setUserPreferences( new LinkedHashSet<UserPreference>( set ) );
            }
        }
        if ( mappingTarget.getUserSubscriptions() != null ) {
            Set<UserSubscription> set1 = userDto.getUserSubscriptions();
            if ( set1 != null ) {
                mappingTarget.getUserSubscriptions().clear();
                mappingTarget.getUserSubscriptions().addAll( set1 );
            }
            else {
                mappingTarget.setUserSubscriptions( null );
            }
        }
        else {
            Set<UserSubscription> set1 = userDto.getUserSubscriptions();
            if ( set1 != null ) {
                mappingTarget.setUserSubscriptions( new LinkedHashSet<UserSubscription>( set1 ) );
            }
        }
        if ( mappingTarget.getUserFromMessages() != null ) {
            Set<Message> set2 = userDto.getUserFromMessages();
            if ( set2 != null ) {
                mappingTarget.getUserFromMessages().clear();
                mappingTarget.getUserFromMessages().addAll( set2 );
            }
            else {
                mappingTarget.setUserFromMessages( null );
            }
        }
        else {
            Set<Message> set2 = userDto.getUserFromMessages();
            if ( set2 != null ) {
                mappingTarget.setUserFromMessages( new LinkedHashSet<Message>( set2 ) );
            }
        }
        if ( mappingTarget.getUserToMessages() != null ) {
            Set<Message> set3 = userDto.getUserToMessages();
            if ( set3 != null ) {
                mappingTarget.getUserToMessages().clear();
                mappingTarget.getUserToMessages().addAll( set3 );
            }
            else {
                mappingTarget.setUserToMessages( null );
            }
        }
        else {
            Set<Message> set3 = userDto.getUserToMessages();
            if ( set3 != null ) {
                mappingTarget.setUserToMessages( new LinkedHashSet<Message>( set3 ) );
            }
        }
        if ( mappingTarget.getItems() != null ) {
            Set<Item> set4 = itemDtoSetToItemSet( userDto.getItems() );
            if ( set4 != null ) {
                mappingTarget.getItems().clear();
                mappingTarget.getItems().addAll( set4 );
            }
            else {
                mappingTarget.setItems( null );
            }
        }
        else {
            Set<Item> set4 = itemDtoSetToItemSet( userDto.getItems() );
            if ( set4 != null ) {
                mappingTarget.setItems( set4 );
            }
        }
        if ( mappingTarget.getPurchases() != null ) {
            Set<Purchase> set5 = purchaseDtoSetToPurchaseSet( userDto.getPurchases() );
            if ( set5 != null ) {
                mappingTarget.getPurchases().clear();
                mappingTarget.getPurchases().addAll( set5 );
            }
            else {
                mappingTarget.setPurchases( null );
            }
        }
        else {
            Set<Purchase> set5 = purchaseDtoSetToPurchaseSet( userDto.getPurchases() );
            if ( set5 != null ) {
                mappingTarget.setPurchases( set5 );
            }
        }
        if ( mappingTarget.getToDoTasks() != null ) {
            Set<ToDoTask> set6 = toDoTaskDtoSetToToDoTaskSet( userDto.getToDoTasks() );
            if ( set6 != null ) {
                mappingTarget.getToDoTasks().clear();
                mappingTarget.getToDoTasks().addAll( set6 );
            }
            else {
                mappingTarget.setToDoTasks( null );
            }
        }
        else {
            Set<ToDoTask> set6 = toDoTaskDtoSetToToDoTaskSet( userDto.getToDoTasks() );
            if ( set6 != null ) {
                mappingTarget.setToDoTasks( set6 );
            }
        }
        if ( mappingTarget.getApiKeys() != null ) {
            Set<ApiKey> set7 = apiKeyDtoSetToApiKeySet( userDto.getApiKeys() );
            if ( set7 != null ) {
                mappingTarget.getApiKeys().clear();
                mappingTarget.getApiKeys().addAll( set7 );
            }
            else {
                mappingTarget.setApiKeys( null );
            }
        }
        else {
            Set<ApiKey> set7 = apiKeyDtoSetToApiKeySet( userDto.getApiKeys() );
            if ( set7 != null ) {
                mappingTarget.setApiKeys( set7 );
            }
        }
        if ( mappingTarget.getTokens() != null ) {
            Set<Token> set8 = tokenDtoSetToTokenSet( userDto.getTokens() );
            if ( set8 != null ) {
                mappingTarget.getTokens().clear();
                mappingTarget.getTokens().addAll( set8 );
            }
            else {
                mappingTarget.setTokens( null );
            }
        }
        else {
            Set<Token> set8 = tokenDtoSetToTokenSet( userDto.getTokens() );
            if ( set8 != null ) {
                mappingTarget.setTokens( set8 );
            }
        }
        if ( userDto.getRole() != null ) {
            if ( mappingTarget.getRole() == null ) {
                mappingTarget.setRole( Role.builder().build() );
            }
            roleDtoToRole1( userDto.getRole(), mappingTarget.getRole() );
        }
        else {
            mappingTarget.setRole( null );
        }
    }
}
