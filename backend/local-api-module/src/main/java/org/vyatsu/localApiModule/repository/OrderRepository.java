package org.vyatsu.localApiModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.vyatsu.localApiModule.entity.item.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByItemId(Long id);

    boolean existsBySrid(String srid);

    Order findBySrid(String srid);

    @Query("SELECT o FROM Order o INNER JOIN Item i ON o.item.id = i.id WHERE i.user.id = :userId AND o.createdAt BETWEEN :dateFrom AND :dateTo")
    List<Order> findOrdersByUserAndCreatedAtBetween(
            @Param("userId") Long userId,
            @Param("dateFrom") LocalDateTime dateFrom,
            @Param("dateTo") LocalDateTime dateTo
    );
}
