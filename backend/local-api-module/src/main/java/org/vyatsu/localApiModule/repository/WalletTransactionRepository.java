package org.vyatsu.localApiModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vyatsu.localApiModule.dto.WalletTransactionDto;
import org.vyatsu.localApiModule.entity.contractor.WalletTransaction;

import java.util.List;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {
    List<WalletTransaction> findByItemId(Long id);

    List<WalletTransaction> findByWalletId(Long id);
}
