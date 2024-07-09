package org.vyatsu.localApiModule.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.vyatsu.localApiModule.dto.response.api.UserDto;

public record AuthResponse(
        @JsonProperty("access_token") String accessToken,
        @JsonProperty("refresh_token") String refreshToken,
        @JsonProperty("userDto")UserDto userDto
        ) { }