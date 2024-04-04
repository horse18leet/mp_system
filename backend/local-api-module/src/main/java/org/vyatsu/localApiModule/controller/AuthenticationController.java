package org.vyatsu.localApiModule.controller;

import org.vyatsu.localApiModule.dto.request.SignInDto;
import org.vyatsu.localApiModule.dto.request.SignUpDto;
import org.vyatsu.localApiModule.dto.response.AuthResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vyatsu.localApiModule.dto.response.api.UserDto;
import org.vyatsu.localApiModule.service.AuthenticationService;

import javax.management.relation.RoleNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto request) throws RoleNotFoundException {
        UserDto user = authenticationService.signUp(request);

        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(@RequestBody SignInDto request) throws RoleNotFoundException {
        return ResponseEntity.ok(authenticationService.signIn(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, RoleNotFoundException {
        authenticationService.refreshToken(request, response);
    }
}