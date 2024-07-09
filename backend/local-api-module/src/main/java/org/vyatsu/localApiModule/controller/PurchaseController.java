package org.vyatsu.localApiModule.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vyatsu.localApiModule.dto.request.api.PurchaseCreateDTO;
import org.vyatsu.localApiModule.dto.response.api.PurchaseDto;
import org.vyatsu.localApiModule.entity.purchase.Purchase;
import org.vyatsu.localApiModule.mapper.PurchaseMapper;
import org.vyatsu.localApiModule.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    private final PurchaseMapper purchaseMapper;

    @PostMapping("/create")
    public ResponseEntity<PurchaseDto> CreateApiKey(@RequestBody PurchaseCreateDTO purchaseCreateDTO) {
        Purchase purchase = purchaseService.createPurchase(purchaseCreateDTO);
        return ResponseEntity.ok(purchaseMapper.toDto(purchase));
    }
}
