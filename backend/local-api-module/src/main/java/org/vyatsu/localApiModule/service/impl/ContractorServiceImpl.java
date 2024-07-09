package org.vyatsu.localApiModule.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.vyatsu.localApiModule.dto.request.api.ContractorDto;
import org.vyatsu.localApiModule.entity.contractor.Contractor;
import org.vyatsu.localApiModule.entity.contractor.Wallet;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.exception.AppException;
import org.vyatsu.localApiModule.mapper.ContractorMapper;
import org.vyatsu.localApiModule.repository.ContractorRepository;
import org.vyatsu.localApiModule.repository.WalletRepository;
import org.vyatsu.localApiModule.security.authentication.impl.AuthenticationFacade;
import org.vyatsu.localApiModule.service.ContractorService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContractorServiceImpl implements ContractorService {

    private final AuthenticationFacade authenticationFacade;

    private final ContractorRepository contractorRepository;
    private final WalletRepository walletRepository;

    private final ContractorMapper contractorMapper;

    @Override
    public List<ContractorDto> getContractorsByUser() {
        User user = authenticationFacade.getAuthenticationUser();
        List<Contractor> contractors = contractorRepository.findByUserId(user.getId())
                .stream()
                .filter(Contractor::getIsActive)
                .toList();

        List<ContractorDto> contractorsDto = contractorMapper.toDto(contractors);
        for (ContractorDto dto : contractorsDto) {
            String cardNum = walletRepository.findWalletByContractorsId(dto.getId()).getPaymentNum();
            dto.setPaymentNum(cardNum);
        }
        return contractorsDto;
    }

    @Override
    public ContractorDto getContractorById(Long id) {
        Contractor contractor = contractorRepository.findById(id).get();
        Wallet wallet = walletRepository.findWalletByContractorsId(id);
        ContractorDto contractorDto = contractorMapper.toDto(contractor);
        contractorDto.setPaymentNum(wallet.getPaymentNum());
        return contractorDto;
    }

    @Override
    @Transactional
    public ContractorDto createContractor(ContractorDto contractorDto) {
        User user = authenticationFacade.getAuthenticationUser();

<<<<<<< Updated upstream
        Wallet wallet = Wallet
                .builder()
                .createdAt(LocalDateTime.now())
                .paymentNum(contractorDto.getPaymentNum())
                .build();

        wallet = walletRepository.save(wallet);

        Contractor contractor = Contractor
                .builder()
                .name(contractorDto.getName())
                .description(contractorDto.getDescription())
                .email(contractorDto.getEmail())
                .actualAddress(contractorDto.getActualAddress())
                .type(contractorDto.getType())
                .createdAt(LocalDateTime.now())
                .isActive(true)
                .user(user)
                .wallet(wallet)
                .build();

        contractor = contractorRepository.save(contractor);
=======
        Contractor contractor = contractorRepository.findByName(contractorDto.getName());
        if (contractor == null || contractor.getIsHidden()) {
            Wallet wallet = Wallet
                    .builder()
                    .createdAt(LocalDateTime.now())
                    .paymentNum(contractorDto.getPaymentNum())
                    .build();

            wallet = walletRepository.save(wallet);

            contractor = Contractor
                    .builder()
                    .name(contractorDto.getName())
                    .description(contractorDto.getDescription())
                    .email(contractorDto.getEmail())
                    .actualAddress(contractorDto.getActualAddress())
                    .phoneNum(contractorDto.getPhoneNum())
                    .type(contractorDto.getType())
                    .createdAt(LocalDateTime.now())
                    .isHidden(false)
                    .isActive(true)
                    .user(user)
                    .wallet(wallet)
                    .build();

            contractor = contractorRepository.save(contractor);
        }
>>>>>>> Stashed changes

        return contractorMapper.toDto(contractor);
    }

    @Override
    public void deleteContractor(Long id) {
        User user = authenticationFacade.getAuthenticationUser();

        Optional<Contractor> optionalContractor = contractorRepository.findById(id);
        Contractor contractor = optionalContractor.orElseThrow(() -> new AppException("Подрядчик id=" + id + " не существует", HttpStatus.NOT_FOUND));

<<<<<<< Updated upstream
        if (!contractor.getIsActive()) throw new AppException("Подрядчик id=" + id + " был удален", HttpStatus.BAD_REQUEST);
        if (!user.equals(contractor.getUser()))  throw new AppException("Недостаточно прав для удаления id=" + id, HttpStatus.FORBIDDEN);
=======
        if (!contractor.getIsActive())
            throw new AppException("Подрядчик id=" + id + " был удален", HttpStatus.BAD_REQUEST);
        if (!user.equals(contractor.getUser()))
            throw new AppException("Недостаточно прав для удаления id=" + id, HttpStatus.FORBIDDEN);
>>>>>>> Stashed changes

        contractor.setIsActive(false);
        contractorRepository.save(contractor);

        throw new AppException("Подрядчик id=" + id + " успешно удален", HttpStatus.OK);
    }


    @Override
    public ContractorDto editContractor(ContractorDto contractorDto) {
        Contractor contractor = contractorRepository.findById(contractorDto.getId()).get();
        contractor.setName(contractorDto.getName());
        contractor.setEmail(contractorDto.getEmail());
        contractor.setDescription(contractorDto.getDescription());
        contractor.setType(contractorDto.getType());
        contractor.setActualAddress(contractorDto.getActualAddress());
        contractor.setIsActive(contractorDto.getIsActive());
        contractorRepository.save(contractor);

        return getContractorById(contractor.getId());
    }

}
