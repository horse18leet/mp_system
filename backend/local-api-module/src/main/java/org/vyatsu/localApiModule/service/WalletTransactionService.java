package org.vyatsu.localApiModule.service;

import org.vyatsu.localApiModule.dto.WalletTransactionDto;
import org.vyatsu.localApiModule.dto.response.api.WalletDto;
<<<<<<< Updated upstream

=======
import org.vyatsu.localApiModule.entity.contractor.WalletTransaction;

import java.time.LocalDateTime;
>>>>>>> Stashed changes
import java.util.List;

public interface WalletTransactionService {

    List<WalletTransactionDto> getWalletTransactionsByItemId(Long id);
    List<WalletTransactionDto> getWalletTransactionsByWallet(WalletDto walletDto);

    Object createWalletTransactionByItemId(Long id, WalletTransactionDto walletTransactionDto);

    boolean deleteByWalletTransaction(Long id);

    List<WalletTransactionDto> getWalletTransactionsByContractor(Long id);

    Object createWalletTransactionByContractorId(Long idContractor, WalletTransactionDto walletTransactionDto);
<<<<<<< Updated upstream
=======

    List<WalletTransactionDto> getWalletTransactionsByUserAndDateFrom(LocalDateTime dateFrom, LocalDateTime dateTo);

    void createWalletTransactions(List<WalletTransaction> walletTransactions);
>>>>>>> Stashed changes
}
