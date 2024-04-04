package org.vyatsu.localApiModule.service;

import org.vyatsu.localApiModule.entity.contractor.Wallet;

public interface WalletService {
    Wallet getContractorWalletByContractorId(Long id);
}
