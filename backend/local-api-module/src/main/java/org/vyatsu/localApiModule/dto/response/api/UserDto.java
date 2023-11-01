package org.vyatsu.localApiModule.dto.response.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;
import org.vyatsu.localApiModule.dto.response.api.item.ItemDto;
import org.vyatsu.localApiModule.entity.msg.Message;
import org.vyatsu.localApiModule.entity.sub.UserSubscription;
import org.vyatsu.localApiModule.entity.user.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for {@link User}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto implements Serializable {
    Long id;
    String email;
    String password;
    String firstName;
    String secondName;
    String phoneNum;
    Boolean isActive;
    LocalDateTime createdAt;
    Set<UserPreference> userPreferences;
    Set<UserSubscription> userSubscriptions;
    Set<Message> userFromMessages;
    Set<Message> userToMessages;
    Set<ItemDto> items;
    Set<PurchaseDto> purchases;
    Set<ToDoTaskDto> toDoTasks;
    Set<ApiKeyDto> apiKeys;
    Set<TokenDto> tokens;
    RoleDto role;
}