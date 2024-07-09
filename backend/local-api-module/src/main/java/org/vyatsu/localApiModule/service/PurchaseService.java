package org.vyatsu.localApiModule.service;

import org.vyatsu.localApiModule.dto.request.api.PurchaseCreateDTO;
import org.vyatsu.localApiModule.entity.purchase.Purchase;

public interface PurchaseService {

    Purchase createPurchase(PurchaseCreateDTO purchaseCreateDTO);
}
