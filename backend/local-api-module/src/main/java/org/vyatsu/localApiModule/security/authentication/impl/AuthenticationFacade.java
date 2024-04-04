package org.vyatsu.localApiModule.security.authentication.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.security.UserDetailsImpl;
import org.vyatsu.localApiModule.security.authentication.IAuthenticationFacade;
import org.vyatsu.localApiModule.service.impl.UserServiceImpl;

@Component
@AllArgsConstructor
public class AuthenticationFacade implements IAuthenticationFacade {

    private final UserServiceImpl userService;
    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public User getAuthenticationUser() {
        return userService.getUserByEmail(((UserDetailsImpl) getAuthentication().getPrincipal()).getUsername());
    }
}
