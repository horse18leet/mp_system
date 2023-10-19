package org.vyatsu.localApiModule.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.vyatsu.localApiModule.dto.request.SignUpDto;
import org.vyatsu.localApiModule.dto.request.SignInDto;
import org.vyatsu.localApiModule.dto.response.AuthResponse;
import org.vyatsu.localApiModule.dto.response.api.UserDto;
import org.vyatsu.localApiModule.entity.enums.TokenType;
import org.vyatsu.localApiModule.entity.user.Token;
import org.vyatsu.localApiModule.entity.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.vyatsu.localApiModule.mapper.UserMapper;
import org.vyatsu.localApiModule.security.UserDetailsImpl;
import org.vyatsu.localApiModule.security.JwtAuthenticationService;

import javax.management.relation.RoleNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final JwtAuthenticationService jwtAuthenticationService;
    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;
    private final RoleService roleService;
    private final UserService userService;

    private final UserMapper userMapper;

    /**
     * Метод регистрации нового пользователя.
     *
     * @param request Запрос на регистрацию пользователя.
     */
    public UserDto signUp(SignUpDto request) throws RoleNotFoundException {
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(roleService.getRole(request.getRoleType()))
                .createdAt(LocalDate.now())
                .isActive(true)
                .firstName(request.getFirstName())
                .build();

        return userMapper.toDto(userService.saveUser(user));
    }

    /**
     * Метод входа пользователя.
     *
     * @param request Запрос на вход пользователя.
     * @return Ответ с авторизационными токенами (Access Token и Refresh Token).
     */
    public AuthResponse signIn(SignInDto request) throws RoleNotFoundException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userService.getUserByEmail(request.getEmail());
        List<SimpleGrantedAuthority> authorities = roleService.getAuthorities(user.getId());

        UserDetailsImpl userDetails = new UserDetailsImpl(user.getEmail(), user.getPassword(), authorities);

        String accessToken = jwtAuthenticationService.generateAccessToken(userDetails);
        String refreshToken = jwtAuthenticationService.generateRefreshToken(userDetails);

        revokeAllUserTokens(user);
        saveUserToken(user, accessToken);

        return new AuthResponse(accessToken, refreshToken);
    }

    // TODO Добавить метод для отзыва токенов через endpoint

    /**
     * Метод обновления Access Token на основе Refresh Token.
     *
     * @param request  Запрос, содержащий Refresh Token.
     * @param response Ответ, в который будет записан новый Access Token.
     * @throws IOException Если произойдут ошибки при записи в ответ.
     */
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, RoleNotFoundException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String email;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) return;

        refreshToken = authHeader.substring(7);
        email = jwtAuthenticationService.extractUsername(refreshToken);

        if (email != null) {
            User user = userService.getUserByEmail(email);

            List<SimpleGrantedAuthority> authorities = roleService.getAuthorities(user.getId());

            UserDetailsImpl userDetails = new UserDetailsImpl(user.getEmail(), user.getPassword(), authorities);

            if (jwtAuthenticationService.isTokenValid(refreshToken, userDetails)) {
                String accessToken = jwtAuthenticationService.generateAccessToken(userDetails);

                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);

                AuthResponse authResponse = new AuthResponse(accessToken, refreshToken);

                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

    /**
     * Сохраняет токен пользователя в базе данных.
     *
     * @param user Пользователь, которому принадлежит токен.
     * @param accessToken Access Token для сохранения.
     */
    private void saveUserToken(User user, String accessToken) {
        Token token = Token.builder()
                .user(user)
                .token(accessToken)
                .type(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();

        tokenService.saveToken(token);
    }

    /**
     * Отзывает все токены пользователя и сохраняет изменения в базе данных.
     *
     * @param user Пользователь, чьи токены отзываются.
     */
    private void revokeAllUserTokens(User user) {
        List<Token> tokens = tokenService.getAllValidTokens(user.getId());

        if (tokens.isEmpty()) return;

        tokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });

        tokenService.saveAllTokens(tokens);
    }
}