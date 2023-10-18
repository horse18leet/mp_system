package org.vyatsu.localApiModule.service;

import org.springframework.http.HttpStatus;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.exception.AppException;
import org.vyatsu.localApiModule.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vyatsu.localApiModule.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /**
     * Получает пользователя по его адресу электронной почты.
     *
     * @param email Адрес электронной почты пользователя.
     * @return Пользователь, если он найден, в противном случае выбрасывает исключение.
     * @throws UserNotFoundException Исключение, возникающее при отсутствии пользователя с указанным адресом электронной почты.
     */
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    /**
     * Сохраняет пользователя в базе данных.
     *
     * @param user Пользователь для сохранения.
     * @return Пользователь, если успешно сохранен
     */
    public User saveUser(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }
        return userRepository.save(user);
    }
}
