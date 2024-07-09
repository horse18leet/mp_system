package org.vyatsu.localApiModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vyatsu.localApiModule.entity.purchase.ContractorPurchaseItem;

public interface ContractorPurchaseItemRepository extends JpaRepository<ContractorPurchaseItem, Long> {
}