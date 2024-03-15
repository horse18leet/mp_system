package org.vyatsu.localApiModule.controller;

import com.sun.security.auth.UserPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vyatsu.localApiModule.dto.response.api.UserDto;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.mapper.UserMapper;
import org.vyatsu.localApiModule.security.UserDetailsImpl;
import org.vyatsu.localApiModule.security.authentication.impl.AuthenticationFacade;
import org.vyatsu.localApiModule.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final AuthenticationFacade authenticationFacade;

    private final UserMapper userMapper;
    @GetMapping
    private ResponseEntity<UserDto> getUser(){
        UserDetailsImpl authentication = (UserDetailsImpl) authenticationFacade.getAuthentication().getPrincipal();
        User user = userService.getUserByEmail(authentication.getUsername());
        return ResponseEntity.ok(userMapper.toDto(user));
    }

}
