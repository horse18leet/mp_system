package org.vyatsu.localApiModule.dto.response.api;

import lombok.Value;
import org.vyatsu.localApiModule.entity.enums.TokenType;

import java.io.Serializable;

/**
 * DTO for {@link org.vyatsu.localApiModule.entity.user.Token}
 */
@Value
public class TokenDto implements Serializable {
    Long id;
    String token;
    TokenType type;
    boolean revoked;
    boolean expired;
}