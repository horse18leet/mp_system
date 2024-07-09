package org.vyatsu.localApiModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< Updated upstream
import org.vyatsu.localApiModule.dto.WalletTransactionDto;
import org.vyatsu.localApiModule.entity.contractor.WalletTransaction;

=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.vyatsu.localApiModule.dto.WalletTransactionDto;
import org.vyatsu.localApiModule.entity.contractor.WalletTransaction;
import org.vyatsu.localApiModule.entity.item.Order;

import java.time.LocalDateTime;
>>>>>>> Stashed changes
import java.util.List;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {
    List<WalletTransaction> findByItemId(Long id);

    List<WalletTransaction> findByWalletId(Long id);
<<<<<<< Updated upstream
=======

    @Query("SELECT w FROM WalletTransaction w WHERE w.user.id = :userId AND w.createdAt BETWEEN :dateFrom AND :dateTo")
    List<WalletTransaction> findByUserAndInterval(
            @Param("userId") Long userId,
            @Param("dateFrom") LocalDateTime dateFrom,
            @Param("dateTo") LocalDateTime dateTo
    );
>>>>>>> Stashed changes
}
