package org.vyatsu.localApiModule.service;

import org.vyatsu.localApiModule.dto.WalletTransactionDto;
import org.vyatsu.localApiModule.dto.response.api.WalletDto;

import java.util.List;

public interface WalletTransactionService {

    List<WalletTransactionDto> getWalletTransactionsByItemId(Long id);
    List<WalletTransactionDto> getWalletTransactionsByWallet(WalletDto walletDto);

    Object createWalletTransactionByItemId(Long id, WalletTransactionDto walletTransactionDto);

    boolean deleteByWalletTransaction(Long id);

    List<WalletTransactionDto> getWalletTransactionsByContractor(Long id);

    Object createWalletTransactionByContractorId(Long idContractor, WalletTransactionDto walletTransactionDto);
}
