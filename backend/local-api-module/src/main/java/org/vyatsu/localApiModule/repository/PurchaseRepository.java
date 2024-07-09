package org.vyatsu.localApiModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vyatsu.localApiModule.entity.purchase.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
