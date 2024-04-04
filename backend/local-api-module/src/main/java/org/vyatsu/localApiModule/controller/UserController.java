package org.vyatsu.localApiModule.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vyatsu.localApiModule.dto.response.api.UserDto;
import org.vyatsu.localApiModule.mapper.UserMapper;
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
    private ResponseEntity<UserDto> getUser(HttpServletRequest req){
        UserDto user = userService.getUser(req);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/edit")
    private ResponseEntity<UserDto> editUser(HttpServletRequest req, @RequestBody UserDto userDto){
        userDto = userService.editUser(req, userDto);
        return ResponseEntity.ok(userDto);
    }

}
