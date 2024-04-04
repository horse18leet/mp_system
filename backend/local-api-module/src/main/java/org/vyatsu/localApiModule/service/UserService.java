package org.vyatsu.localApiModule.service;

import org.springframework.http.HttpStatus;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.exception.AppException;
import org.vyatsu.localApiModule.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vyatsu.localApiModule.repository.UserRepository;

public interface UserService {

    public User getUserByEmail(String email);

    public User saveUser(User user);
}
