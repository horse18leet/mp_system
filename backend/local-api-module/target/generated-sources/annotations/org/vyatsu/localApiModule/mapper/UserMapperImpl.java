package org.vyatsu.localApiModule.mapper;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Component;
import org.vyatsu.localApiModule.dto.response.api.ApiKeyDto;
import org.vyatsu.localApiModule.dto.response.api.PurchaseDto;
import org.vyatsu.localApiModule.dto.response.api.RoleDto;
import org.vyatsu.localApiModule.dto.response.api.ToDoTaskDto;
import org.vyatsu.localApiModule.dto.response.api.TokenDto;
import org.vyatsu.localApiModule.dto.response.api.UserDto;
import org.vyatsu.localApiModule.dto.response.api.item.ItemDto;
import org.vyatsu.localApiModule.dto.response.api.item.SimpleUserDto;
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
    date = "2023-11-15T12:06:56+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    private final DatatypeFactory datatypeFactory;

    public UserMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public User toEntity(UserDto userDto) {
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

    @Override
    public SimpleUserDto toSimpleUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        SimpleUserDto.SimpleUserDtoBuilder simpleUserDto = SimpleUserDto.builder();

        simpleUserDto.id( user.getId() );

        return simpleUserDto.build();
    }

    @Override
    public UserDto toDto(User user) {
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
        LocalDateTime createdAt = null;
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

    @Override
    public User partialUpdate(UserDto userDto, User user) {
        if ( userDto == null ) {
            return user;
        }

        if ( userDto.getId() != null ) {
            user.setId( userDto.getId() );
        }
        if ( userDto.getEmail() != null ) {
            user.setEmail( userDto.getEmail() );
        }
        if ( userDto.getPassword() != null ) {
            user.setPassword( userDto.getPassword() );
        }
        if ( userDto.getFirstName() != null ) {
            user.setFirstName( userDto.getFirstName() );
        }
        if ( userDto.getSecondName() != null ) {
            user.setSecondName( userDto.getSecondName() );
        }
        if ( userDto.getPhoneNum() != null ) {
            user.setPhoneNum( userDto.getPhoneNum() );
        }
        if ( userDto.getIsActive() != null ) {
            user.setIsActive( userDto.getIsActive() );
        }
        if ( userDto.getCreatedAt() != null ) {
            user.setCreatedAt( userDto.getCreatedAt() );
        }
        if ( user.getUserPreferences() != null ) {
            Set<UserPreference> set = userDto.getUserPreferences();
            if ( set != null ) {
                user.getUserPreferences().clear();
                user.getUserPreferences().addAll( set );
            }
        }
        else {
            Set<UserPreference> set = userDto.getUserPreferences();
            if ( set != null ) {
                user.setUserPreferences( new LinkedHashSet<UserPreference>( set ) );
            }
        }
        if ( user.getUserSubscriptions() != null ) {
            Set<UserSubscription> set1 = userDto.getUserSubscriptions();
            if ( set1 != null ) {
                user.getUserSubscriptions().clear();
                user.getUserSubscriptions().addAll( set1 );
            }
        }
        else {
            Set<UserSubscription> set1 = userDto.getUserSubscriptions();
            if ( set1 != null ) {
                user.setUserSubscriptions( new LinkedHashSet<UserSubscription>( set1 ) );
            }
        }
        if ( user.getUserFromMessages() != null ) {
            Set<Message> set2 = userDto.getUserFromMessages();
            if ( set2 != null ) {
                user.getUserFromMessages().clear();
                user.getUserFromMessages().addAll( set2 );
            }
        }
        else {
            Set<Message> set2 = userDto.getUserFromMessages();
            if ( set2 != null ) {
                user.setUserFromMessages( new LinkedHashSet<Message>( set2 ) );
            }
        }
        if ( user.getUserToMessages() != null ) {
            Set<Message> set3 = userDto.getUserToMessages();
            if ( set3 != null ) {
                user.getUserToMessages().clear();
                user.getUserToMessages().addAll( set3 );
            }
        }
        else {
            Set<Message> set3 = userDto.getUserToMessages();
            if ( set3 != null ) {
                user.setUserToMessages( new LinkedHashSet<Message>( set3 ) );
            }
        }
        if ( user.getItems() != null ) {
            Set<Item> set4 = itemDtoSetToItemSet( userDto.getItems() );
            if ( set4 != null ) {
                user.getItems().clear();
                user.getItems().addAll( set4 );
            }
        }
        else {
            Set<Item> set4 = itemDtoSetToItemSet( userDto.getItems() );
            if ( set4 != null ) {
                user.setItems( set4 );
            }
        }
        if ( user.getPurchases() != null ) {
            Set<Purchase> set5 = purchaseDtoSetToPurchaseSet( userDto.getPurchases() );
            if ( set5 != null ) {
                user.getPurchases().clear();
                user.getPurchases().addAll( set5 );
            }
        }
        else {
            Set<Purchase> set5 = purchaseDtoSetToPurchaseSet( userDto.getPurchases() );
            if ( set5 != null ) {
                user.setPurchases( set5 );
            }
        }
        if ( user.getToDoTasks() != null ) {
            Set<ToDoTask> set6 = toDoTaskDtoSetToToDoTaskSet( userDto.getToDoTasks() );
            if ( set6 != null ) {
                user.getToDoTasks().clear();
                user.getToDoTasks().addAll( set6 );
            }
        }
        else {
            Set<ToDoTask> set6 = toDoTaskDtoSetToToDoTaskSet( userDto.getToDoTasks() );
            if ( set6 != null ) {
                user.setToDoTasks( set6 );
            }
        }
        if ( user.getApiKeys() != null ) {
            Set<ApiKey> set7 = apiKeyDtoSetToApiKeySet( userDto.getApiKeys() );
            if ( set7 != null ) {
                user.getApiKeys().clear();
                user.getApiKeys().addAll( set7 );
            }
        }
        else {
            Set<ApiKey> set7 = apiKeyDtoSetToApiKeySet( userDto.getApiKeys() );
            if ( set7 != null ) {
                user.setApiKeys( set7 );
            }
        }
        if ( user.getTokens() != null ) {
            Set<Token> set8 = tokenDtoSetToTokenSet( userDto.getTokens() );
            if ( set8 != null ) {
                user.getTokens().clear();
                user.getTokens().addAll( set8 );
            }
        }
        else {
            Set<Token> set8 = tokenDtoSetToTokenSet( userDto.getTokens() );
            if ( set8 != null ) {
                user.setTokens( set8 );
            }
        }
        if ( userDto.getRole() != null ) {
            if ( user.getRole() == null ) {
                user.setRole( Role.builder().build() );
            }
            roleDtoToRole1( userDto.getRole(), user.getRole() );
        }

        linkUserPreferences( user );
        linkUserSubscriptions( user );
        linkUserFromMessages( user );
        linkUserToMessages( user );
        linkItems( user );
        linkPurchases( user );
        linkToDoTasks( user );
        linkApiKeys( user );
        linkTokens( user );

        return user;
    }

    private XMLGregorianCalendar localDateToXmlGregorianCalendar( LocalDate localDate ) {
        if ( localDate == null ) {
            return null;
        }

        return datatypeFactory.newXMLGregorianCalendarDate(
            localDate.getYear(),
            localDate.getMonthValue(),
            localDate.getDayOfMonth(),
            DatatypeConstants.FIELD_UNDEFINED );
    }

    private XMLGregorianCalendar localDateTimeToXmlGregorianCalendar( LocalDateTime localDateTime ) {
        if ( localDateTime == null ) {
            return null;
        }

        return datatypeFactory.newXMLGregorianCalendar(
            localDateTime.getYear(),
            localDateTime.getMonthValue(),
            localDateTime.getDayOfMonth(),
            localDateTime.getHour(),
            localDateTime.getMinute(),
            localDateTime.getSecond(),
            localDateTime.get( ChronoField.MILLI_OF_SECOND ),
            DatatypeConstants.FIELD_UNDEFINED );
    }

    private static LocalDate xmlGregorianCalendarToLocalDate( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        return LocalDate.of( xcal.getYear(), xcal.getMonth(), xcal.getDay() );
    }

    private static LocalDateTime xmlGregorianCalendarToLocalDateTime( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        if ( xcal.getYear() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMonth() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getDay() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getHour() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMinute() != DatatypeConstants.FIELD_UNDEFINED
        ) {
            if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED
                && xcal.getMillisecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond(),
                    Duration.ofMillis( xcal.getMillisecond() ).getNano()
                );
            }
            else if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond()
                );
            }
            else {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute()
                );
            }
        }
        return null;
    }

    protected User simpleUserDtoToUser(SimpleUserDto simpleUserDto) {
        if ( simpleUserDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( simpleUserDto.getId() );

        return user.build();
    }

    protected Item itemDtoToItem(ItemDto itemDto) {
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

    protected Set<Item> itemDtoSetToItemSet(Set<ItemDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Item> set1 = new LinkedHashSet<Item>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ItemDto itemDto : set ) {
            set1.add( itemDtoToItem( itemDto ) );
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
        toDoTask.dueDate( xmlGregorianCalendarToLocalDate( localDateTimeToXmlGregorianCalendar( toDoTaskDto.getDueDate() ) ) );
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

    protected ItemDto itemToItemDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto.ItemDtoBuilder itemDto = ItemDto.builder();

        itemDto.id( item.getId() );
        itemDto.title( item.getTitle() );
        itemDto.description( item.getDescription() );
        itemDto.firstPrice( item.getFirstPrice() );
        itemDto.user( toSimpleUserDto( item.getUser() ) );
        itemDto.category( item.getCategory() );
        itemDto.mpLink( item.getMpLink() );
        itemDto.isActive( item.getIsActive() );
        itemDto.createdAt( item.getCreatedAt() );

        return itemDto.build();
    }

    protected Set<ItemDto> itemSetToItemDtoSet(Set<Item> set) {
        if ( set == null ) {
            return null;
        }

        Set<ItemDto> set1 = new LinkedHashSet<ItemDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Item item : set ) {
            set1.add( itemToItemDto( item ) );
        }

        return set1;
    }

    protected PurchaseDto purchaseToPurchaseDto(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        Long id = null;
        double cost = 0.0d;
        LocalDateTime createdAt = null;

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
        LocalDateTime dueDate = null;
        Boolean isCompleted = null;
        LocalDateTime createdAt = null;

        id = toDoTask.getId();
        title = toDoTask.getTitle();
        description = toDoTask.getDescription();
        dueDate = xmlGregorianCalendarToLocalDateTime( localDateToXmlGregorianCalendar( toDoTask.getDueDate() ) );
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
        LocalDateTime createdAt = null;

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

    protected void roleDtoToRole1(RoleDto roleDto, Role mappingTarget) {
        if ( roleDto == null ) {
            return;
        }

        mappingTarget.setId( roleDto.getId() );
        mappingTarget.setName( roleDto.getName() );
    }
}
