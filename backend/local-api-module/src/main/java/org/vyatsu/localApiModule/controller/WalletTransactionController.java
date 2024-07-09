package org.vyatsu.localApiModule.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vyatsu.localApiModule.dto.WalletTransactionDto;
import org.vyatsu.localApiModule.mapper.WalletTransactionMapper;
import org.vyatsu.localApiModule.service.WalletTransactionService;

<<<<<<< Updated upstream
=======
import java.time.LocalDateTime;
>>>>>>> Stashed changes
import java.util.List;

@RestController
@RequestMapping("/walletTransactions")
@RequiredArgsConstructor
public class WalletTransactionController {

    private final WalletTransactionService walletTransactionService;

    private final WalletTransactionMapper walletTransactionMapper;

    @GetMapping("/item/{id}")
    private ResponseEntity<List<WalletTransactionDto>> getWalletTransactionsByItem(@PathVariable Long id){
        List<WalletTransactionDto> itemWalletTransactionsDto = walletTransactionService.getWalletTransactionsByItemId(id);
        return ResponseEntity.ok(itemWalletTransactionsDto);
    }

    @GetMapping("/contractor/{id}")
    private ResponseEntity<List<WalletTransactionDto>> getWalletTransactionsByContractor(@PathVariable Long id){
        List<WalletTransactionDto> itemWalletTransactionsDto = walletTransactionService.getWalletTransactionsByContractor(id);
        return ResponseEntity.ok(itemWalletTransactionsDto);
    }

<<<<<<< Updated upstream
=======
    @GetMapping("/user")
    private ResponseEntity<List<WalletTransactionDto>> getWalletTransactionsByUserAndDateFrom(@RequestParam("dateFrom") LocalDateTime dateFrom, @RequestParam("dateTo") LocalDateTime dateTo){
        List<WalletTransactionDto> walletTransactionDto = walletTransactionService.getWalletTransactionsByUserAndDateFrom(dateFrom, dateTo);
        return ResponseEntity.ok(walletTransactionDto);
    }

>>>>>>> Stashed changes
    @PostMapping("/item/{idItem}")
    private ResponseEntity<Object> createWalletTransactionByItem(@PathVariable Long idItem, @RequestBody WalletTransactionDto walletTransactionDto){
        Object result = walletTransactionService.createWalletTransactionByItemId(idItem, walletTransactionDto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/contractor/{idContractor}")
    private ResponseEntity<Object> createWalletTransactionByContractor(@PathVariable Long idContractor, @RequestBody WalletTransactionDto walletTransactionDto){
        Object result = walletTransactionService.createWalletTransactionByContractorId(idContractor, walletTransactionDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
<<<<<<< Updated upstream
    private ResponseEntity<Void> deleteWalletTransaction(@RequestBody Long id){
=======
    private ResponseEntity<Void> deleteWalletTransaction(@PathVariable Long id){
>>>>>>> Stashed changes
        boolean isSuccessful = walletTransactionService.deleteByWalletTransaction(id);
        if(isSuccessful) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
