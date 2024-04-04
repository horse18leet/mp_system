package org.vyatsu.localApiModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vyatsu.localApiModule.entity.contractor.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Wallet findWalletByContractorsId(Long id);
}
