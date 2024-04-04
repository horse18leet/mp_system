package org.vyatsu.localApiModule.mapper;

import org.mapstruct.*;
import org.vyatsu.localApiModule.dto.response.api.UserDto;
import org.vyatsu.localApiModule.dto.response.api.item.SimpleUserDto;
import org.vyatsu.localApiModule.entity.user.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(UserDto userDto);

    SimpleUserDto toSimpleUserDto(User user);

    @AfterMapping
    default void linkUserPreferences(@MappingTarget User user) {
        user.getUserPreferences().forEach(userPreference -> userPreference.setUser(user));
    }

    @AfterMapping
    default void linkUserSubscriptions(@MappingTarget User user) {
        user.getUserSubscriptions().forEach(userSubscription -> userSubscription.setUser(user));
    }

    @AfterMapping
    default void linkUserFromMessages(@MappingTarget User user) {
        user.getUserFromMessages().forEach(userFromMessage -> userFromMessage.setUserFrom(user));
    }

    @AfterMapping
    default void linkUserToMessages(@MappingTarget User user) {
        user.getUserToMessages().forEach(userToMessage -> userToMessage.setUserTo(user));
    }

    @AfterMapping
    default void linkItems(@MappingTarget User user) {
        user.getItems().forEach(item -> item.setUser(user));
    }

    @AfterMapping
    default void linkPurchases(@MappingTarget User user) {
        user.getPurchases().forEach(purchase -> purchase.setUser(user));
    }

    @AfterMapping
    default void linkToDoTasks(@MappingTarget User user) {
        user.getToDoTasks().forEach(toDoTask -> toDoTask.setUser(user));
    }

    @AfterMapping
    default void linkApiKeys(@MappingTarget User user) {
        user.getApiKeys().forEach(apiKey -> apiKey.setUser(user));
    }

    @AfterMapping
    default void linkTokens(@MappingTarget User user) {
        user.getTokens().forEach(token -> token.setUser(user));
    }

    UserDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDto, @MappingTarget User user);
}