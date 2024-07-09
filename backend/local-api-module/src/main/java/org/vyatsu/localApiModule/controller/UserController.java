package org.vyatsu.localApiModule.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< Updated upstream
=======
import org.vyatsu.localApiModule.dto.response.api.DashboardDTO;
>>>>>>> Stashed changes
import org.vyatsu.localApiModule.dto.response.api.UserDto;
import org.vyatsu.localApiModule.mapper.UserMapper;
import org.vyatsu.localApiModule.security.authentication.impl.AuthenticationFacade;
import org.vyatsu.localApiModule.service.impl.UserServiceImpl;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationFacade authenticationFacade;

    private final UserServiceImpl userService;

    private final UserMapper userMapper;

    @GetMapping
<<<<<<< Updated upstream
    private ResponseEntity<UserDto> getUser(HttpServletRequest req){
=======
    private ResponseEntity<UserDto> getUser(HttpServletRequest req) {
>>>>>>> Stashed changes
        UserDto user = userService.getUser(req);
        return ResponseEntity.ok(user);
    }

<<<<<<< Updated upstream
    @PutMapping("/edit")
    private ResponseEntity<UserDto> editUser(HttpServletRequest req, @RequestBody UserDto userDto){
=======
    @GetMapping("/dashboard")
    private ResponseEntity<DashboardDTO> getUserDashboard(HttpServletRequest req, @RequestParam("dateFrom") LocalDateTime dateFrom, @RequestParam("dateTo") LocalDateTime dateTo) {
        DashboardDTO dashboard = userService.getUserDashboard(req, dateFrom, dateTo);
        return ResponseEntity.ok(dashboard);
    }

    @PutMapping("/edit")
    private ResponseEntity<UserDto> editUser(HttpServletRequest req, @RequestBody UserDto userDto) {
>>>>>>> Stashed changes
        userDto = userService.editUser(req, userDto);
        return ResponseEntity.ok(userDto);
    }

}
