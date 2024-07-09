package org.vyatsu.localApiModule.service;

import jakarta.servlet.http.HttpServletRequest;
import org.vyatsu.localApiModule.dto.response.api.DashboardDTO;
import org.vyatsu.localApiModule.entity.user.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {

    User getUserByEmail(String email);
    User saveUser(User user);
    DashboardDTO getUserDashboard(HttpServletRequest req, LocalDateTime dateFrom, LocalDateTime dateTo);

    List<User> getAllUsers();
}
