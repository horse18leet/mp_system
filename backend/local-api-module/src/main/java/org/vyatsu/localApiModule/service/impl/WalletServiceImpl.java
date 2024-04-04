package org.vyatsu.localApiModule.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.vyatsu.localApiModule.entity.contractor.Wallet;
import org.vyatsu.localApiModule.mapper.WalletMapper;
import org.vyatsu.localApiModule.repository.WalletRepository;
import org.vyatsu.localApiModule.security.authentication.impl.AuthenticationFacade;
import org.vyatsu.localApiModule.service.WalletService;

@Service
@AllArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final AuthenticationFacade authenticationFacade;

    private final WalletRepository walletRepository;

    private final WalletMapper walletMapper;

    public Wallet getContractorWalletByContractorId(Long id) {
        return walletRepository.findWalletByContractorsId(id);
    }

}
