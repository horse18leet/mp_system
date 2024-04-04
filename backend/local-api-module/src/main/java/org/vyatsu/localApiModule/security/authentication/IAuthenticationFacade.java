package org.vyatsu.localApiModule.security.authentication;

import org.springframework.security.core.Authentication;
import org.vyatsu.localApiModule.entity.user.User;

public interface IAuthenticationFacade {
    Authentication getAuthentication();

    User getAuthenticationUser();
}
