package org.vyatsu.localApiModule.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.vyatsu.localApiModule.dto.request.api.ContractorWork;
import org.vyatsu.localApiModule.dto.request.api.PurchaseCreateDTO;
import org.vyatsu.localApiModule.entity.purchase.ContractorPurchaseItem;
import org.vyatsu.localApiModule.repository.ContractorPurchaseItemRepository;
import org.vyatsu.localApiModule.entity.purchase.Purchase;
import org.vyatsu.localApiModule.entity.purchase.PurchaseItem;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.repository.ContractorRepository;
import org.vyatsu.localApiModule.repository.ItemRepository;
import org.vyatsu.localApiModule.repository.PurchaseItemRepository;
import org.vyatsu.localApiModule.repository.PurchaseRepository;
import org.vyatsu.localApiModule.security.authentication.impl.AuthenticationFacade;
import org.vyatsu.localApiModule.service.PurchaseService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
    private AuthenticationFacade authenticationFacade;

    private final PurchaseRepository purchaseRepository;
    private final ContractorRepository contractorRepository;
    private final ItemRepository itemRepository;
    private final PurchaseItemRepository purchaseItemRepository;
    private final ContractorPurchaseItemRepository contractorPurchaseItemRepository;

    @Override
    public Purchase createPurchase(PurchaseCreateDTO purchaseCreateDTO) {
        User user = authenticationFacade.getAuthenticationUser();
        Purchase purchase;
        if (purchaseCreateDTO.getPurchaseId() == null) {
            purchase = Purchase
                    .builder()
                    .cost(0.0)
                    .createdAt(LocalDateTime.now())
                    .user(user)
                    .build();
        } else {
            purchase = purchaseRepository.findById(purchaseCreateDTO.getPurchaseId()).get();
        }

        purchase = purchaseRepository.save(purchase);

        PurchaseItem purchaseItem = PurchaseItem
                .builder()
                .item(itemRepository.findById(purchaseCreateDTO.getItemId()).get())
                .quantity(purchaseCreateDTO.getQuantity())
                .purchase(purchase)
                .build();
        purchaseItem = purchaseItemRepository.save(purchaseItem);

        Double sumCost = 0.0;
        List<ContractorPurchaseItem> contractorsPurchaseItem = new ArrayList<>();
        for (ContractorWork contractorWork : purchaseCreateDTO.getContractorsWork()) {
            ContractorPurchaseItem contractorPurchaseItem = ContractorPurchaseItem
                    .builder()
                    .cost(contractorWork.getCost())
                    .deadline(contractorWork.getDeadline())
                    .contractor(contractorRepository.findById(contractorWork.getContractorId()).get())
                    .purchaseItem(purchaseItem)
                    .build();

            contractorsPurchaseItem.add(contractorPurchaseItem);
            sumCost += contractorWork.getCost();
        }
        purchase.setCost(purchase.getCost() + sumCost);
        contractorPurchaseItemRepository.saveAll(contractorsPurchaseItem);


        return purchaseRepository.save(purchase);
    }
}
