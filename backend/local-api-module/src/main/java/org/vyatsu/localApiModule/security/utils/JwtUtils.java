package org.vyatsu.localApiModule.security.utils;

import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.security.JwtAuthenticationService;
import org.vyatsu.localApiModule.service.UserService;

@Service
@AllArgsConstructor
public class JwtUtils {
    private final JwtAuthenticationService jwtAuthenticationService;
    private final UserService userService;

    public User getUserByReq(HttpServletRequest req) {
        User user = null;
        final String authHeader = req.getHeader(HttpHeaders.AUTHORIZATION);
        final String jwt;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) return null;

        jwt = authHeader.substring(7);
        String email = jwtAuthenticationService.extractUsername(jwt);
        if (email != null) user = userService.getUserByEmail(email);
        return user;
    }
}