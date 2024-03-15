package org.vyatsu.localApiModule.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.vyatsu.localApiModule.dto.response.api.UserDto;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.exception.AppException;
import org.vyatsu.localApiModule.exception.UserNotFoundException;
import org.vyatsu.localApiModule.mapper.UserMapper;
import org.vyatsu.localApiModule.repository.UserRepository;
import org.vyatsu.localApiModule.security.JwtAuthenticationService;
import org.vyatsu.localApiModule.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final JwtAuthenticationService jwtAuthenticationService;

    private final UserMapper userMapper;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
    }

    public User saveUser(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new AppException("Пользователь с таким логином существует", HttpStatus.BAD_REQUEST);
        }
        return userRepository.save(user);
    }

    public UserDto getUser(HttpServletRequest request) {
        User user = getUserByReq(request);
        return userMapper.toDto(user);
    }

    private User getUserByReq(HttpServletRequest req) {
        User user = null;
        final String authHeader = req.getHeader(HttpHeaders.AUTHORIZATION);
        final String jwt;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) return null;

        jwt = authHeader.substring(7);
        String email = jwtAuthenticationService.extractUsername(jwt);
        if (email != null) user = getUserByEmail(email);
        return user;
    }
}
