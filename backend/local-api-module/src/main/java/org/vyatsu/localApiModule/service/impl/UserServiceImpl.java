package org.vyatsu.localApiModule.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.vyatsu.localApiModule.dto.response.api.DashboardDTO;
import org.vyatsu.localApiModule.dto.response.api.UserDto;
import org.vyatsu.localApiModule.entity.contractor.WalletTransaction;
import org.vyatsu.localApiModule.entity.enums.WalletTransactionType;
import org.vyatsu.localApiModule.entity.item.Order;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.exception.AppException;
import org.vyatsu.localApiModule.exception.UserNotFoundException;
import org.vyatsu.localApiModule.mapper.OrderMapper;
import org.vyatsu.localApiModule.mapper.UserMapper;
import org.vyatsu.localApiModule.mapper.WalletTransactionMapper;
import org.vyatsu.localApiModule.repository.OrderRepository;
import org.vyatsu.localApiModule.repository.UserRepository;
import org.vyatsu.localApiModule.repository.WalletTransactionRepository;
import org.vyatsu.localApiModule.security.JwtAuthenticationService;
import org.vyatsu.localApiModule.security.authentication.impl.AuthenticationFacade;
import org.vyatsu.localApiModule.service.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final WalletTransactionRepository walletTransactionRepository;

    private final JwtAuthenticationService jwtAuthenticationService;

    private final UserMapper userMapper;
    private final WalletTransactionMapper walletTransactionMapper;
    private final OrderMapper orderMapper;

    private final OrderRepository orderRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
    }

    public User saveUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new AppException("Пользователь с таким логином существует", HttpStatus.BAD_REQUEST);
        }
        return userRepository.save(user);
    }

    @Override
    public DashboardDTO getUserDashboard(HttpServletRequest req, LocalDateTime dateFrom, LocalDateTime dateTo) {
        User user = getUserByReq(req);

        List<WalletTransaction> walletTransactions = walletTransactionRepository.findByUserAndInterval(user.getId(), dateFrom, dateTo.plusDays(1));

        List<Order> orders = orderRepository.findOrdersByUserAndCreatedAtBetween(user.getId(), dateFrom, dateTo);

        Double sumPriceOrder = orders.stream().mapToDouble(Order::getPrice).sum();

        Double orderProfit = orders.stream()
                .filter(x -> x.getTakedAt() != null)
                .mapToDouble(Order::getPrice)
                .sum();

        Map<LocalDate, Long> ordersPerInterval = new TreeMap<>(orders.stream()
                .collect(Collectors.groupingBy(order -> order.getCreatedAt().toLocalDate(), Collectors.counting())));


        Double walletTransactionExpenses = walletTransactions.stream()
                .filter(x -> x.getType() == WalletTransactionType.Расход)
                .mapToDouble(WalletTransaction::getAmount)
                .sum();

        Double walletTransactionIncome = walletTransactions.stream()
                .filter(x -> x.getType() == WalletTransactionType.Приход)
                .mapToDouble(WalletTransaction::getAmount)
                .sum();

        Double income = orderProfit + walletTransactionIncome;
        Double expense = walletTransactionExpenses;
        Double profit = income - expense;


        return DashboardDTO.builder()
                .dateFrom(dateFrom)
                .dateTo(dateTo)
                .walletTransactions(walletTransactionMapper.toDtoList(walletTransactions))
                .orders(orderMapper.toListDto(orders))
                .ordersPerInterval(ordersPerInterval)
                .sumPriceOrder(sumPriceOrder)
                .intervalProfit(profit)
                .sumIncome(income)
                .sumExpense(expense)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
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

    public UserDto editUser(HttpServletRequest req, UserDto userDto) {
        User authUser = getUserByReq(req);
        User user = userRepository.findById(userDto.getId()).get();

<<<<<<< Updated upstream
        if(authUser != null && authUser.getId().equals(user.getId())){
=======
        if (authUser != null && authUser.getId().equals(user.getId())) {
>>>>>>> Stashed changes
            user.setFirstName(userDto.getFirstName());
            user.setSecondName(userDto.getSecondName());
            user.setEmail(userDto.getEmail());
            user.setPassword(user.getPassword());
            user = userRepository.save(user);
        }

        return userMapper.toDto(user);
    }
<<<<<<< Updated upstream
=======


>>>>>>> Stashed changes
}
