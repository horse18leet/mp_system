package org.vyatsu.localApiModule.service.impl;

<<<<<<< Updated upstream
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
=======
import lombok.AllArgsConstructor;
>>>>>>> Stashed changes
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.vyatsu.localApiModule.dto.WalletTransactionDto;
import org.vyatsu.localApiModule.dto.request.api.ContractorDto;
import org.vyatsu.localApiModule.dto.response.api.WalletDto;
import org.vyatsu.localApiModule.entity.contractor.Contractor;
import org.vyatsu.localApiModule.entity.contractor.Wallet;
import org.vyatsu.localApiModule.entity.contractor.WalletTransaction;
import org.vyatsu.localApiModule.entity.item.Item;
import org.vyatsu.localApiModule.entity.user.User;
import org.vyatsu.localApiModule.exception.AppException;
import org.vyatsu.localApiModule.mapper.ContractorMapper;
import org.vyatsu.localApiModule.mapper.ItemMapper;
import org.vyatsu.localApiModule.mapper.WalletTransactionMapper;
<<<<<<< Updated upstream
import org.vyatsu.localApiModule.repository.ContractorRepository;
import org.vyatsu.localApiModule.repository.ItemRepository;
import org.vyatsu.localApiModule.repository.WalletRepository;
import org.vyatsu.localApiModule.repository.WalletTransactionRepository;
=======
import org.vyatsu.localApiModule.repository.*;
>>>>>>> Stashed changes
import org.vyatsu.localApiModule.security.authentication.impl.AuthenticationFacade;
import org.vyatsu.localApiModule.service.WalletService;
import org.vyatsu.localApiModule.service.WalletTransactionService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final AuthenticationFacade authenticationFacade;

    private final WalletService walletService;

    private final ContractorRepository contractorRepository;
    private final WalletTransactionRepository walletTransactionRepository;
    private final WalletRepository walletRepository;
    private final ItemRepository itemRepository;

    private final WalletTransactionMapper walletTransactionMapper;
    private final ItemMapper itemMapper;
    private final ContractorMapper contractorMapper;
<<<<<<< Updated upstream
=======
    private final UserRepository userRepository;
>>>>>>> Stashed changes

    @Override
    public List<WalletTransactionDto> getWalletTransactionsByItemId(Long id) {
        List<WalletTransaction> walletTransactions = walletTransactionRepository.findByItemId(id);
        List<WalletTransactionDto> walletTransactionDto = new ArrayList<>();

        // тут формируется список транзакций с подрядчиком
        for (WalletTransaction walletTransaction : walletTransactions) {
            Contractor contractor = contractorRepository.findByWalletId(walletTransaction.getWallet().getId());
            Item item = itemRepository.findById(id).get();
            WalletTransactionDto walletTransactionDto1 = WalletTransactionDto
                    .builder()
                    .id(walletTransaction.getId())
                    .contractorDto(contractorMapper.toDto(contractor))
                    .itemDto(itemMapper.toDto(item))
                    .type(walletTransaction.getType())
                    .amount(walletTransaction.getAmount())
                    .description(walletTransaction.getDescription())
                    .implDate(walletTransaction.getImplDate())
                    .createdAt(LocalDateTime.now())
                    .build();

            walletTransactionDto.add(walletTransactionDto1);
        }

        return walletTransactionDto;
    }

    @Override
    public List<WalletTransactionDto> getWalletTransactionsByWallet(WalletDto walletDto) {
        List<WalletTransaction> walletTransactions = walletTransactionRepository.findByWalletId(walletDto.getId());
        return walletTransactionMapper.toDtoList(walletTransactions);
    }

    @Override
    public boolean deleteByWalletTransaction(Long id) {
        WalletTransaction walletTransaction = walletTransactionRepository.findById(id).get();
        User user = authenticationFacade.getAuthenticationUser();

        if(user == walletTransaction.getUser()){
            walletTransactionRepository.delete(walletTransaction);
            return true;
        }

        return false;
    }

    /*
    * Получение фин операций по подрядчику
    * */
    @Override
    public List<WalletTransactionDto> getWalletTransactionsByContractor(Long id) {
        Contractor contractor = contractorRepository.findById(id).get();
        ContractorDto contractorDto = contractorMapper.toDto(contractor);
        contractorDto.setPaymentNum(walletRepository.findWalletByContractorsId(contractorDto.getId()).getPaymentNum());

        List<WalletTransaction> walletTransactions = walletTransactionRepository.findByWalletId(contractor.getWallet().getId());
        List<WalletTransactionDto> walletTransactionDto = new ArrayList<>();

        for(WalletTransaction walletTransaction : walletTransactions){
            WalletTransactionDto walletTransactionDto1 = new WalletTransactionDto();
            walletTransactionDto1.setId(walletTransaction.getId());
            walletTransactionDto1.setContractorDto(contractorDto);
            walletTransactionDto1.setType(walletTransaction.getType());
            walletTransactionDto1.setDescription(walletTransaction.getDescription());
            walletTransactionDto1.setAmount(walletTransaction.getAmount());
            walletTransactionDto1.setImplDate(walletTransaction.getImplDate());
            walletTransactionDto1.setItemDto(itemMapper.toDto(walletTransaction.getItem()));
            walletTransactionDto1.setCreatedAt(walletTransaction.getCreatedAt());
            walletTransactionDto.add(walletTransactionDto1);
        }
        return walletTransactionDto;
    }
    @Override
    public Object createWalletTransactionByItemId(Long id, WalletTransactionDto walletTransactionDto) {
        Item item = itemRepository.findById(id).get();
        Wallet wallet = walletService.getContractorWalletByContractorId(walletTransactionDto.getContractorDto().getId());
        return createWalletTransaction(walletTransactionDto, item, wallet);
    }
    @Override
    public Object createWalletTransactionByContractorId(Long idContractor, WalletTransactionDto walletTransactionDto) {
        Item item = itemMapper.toEntity(walletTransactionDto.getItemDto());
        Wallet wallet = walletService.getContractorWalletByContractorId(idContractor);
        return createWalletTransaction(walletTransactionDto, item, wallet);
    }

<<<<<<< Updated upstream
=======
    @Override
    public List<WalletTransactionDto> getWalletTransactionsByUserAndDateFrom(LocalDateTime dateFrom, LocalDateTime dateTo) {
        User user = authenticationFacade.getAuthenticationUser();
        List<WalletTransaction> walletTransactions = walletTransactionRepository.findByUserAndInterval(user.getId(), dateFrom, dateTo);
        return walletTransactionMapper.toDtoList(walletTransactions);
    }

    @Override
    public void createWalletTransactions(List<WalletTransaction> walletTransactions) {
        walletTransactionRepository.saveAll(walletTransactions);
    }

>>>>>>> Stashed changes
    private Object createWalletTransaction(WalletTransactionDto walletTransactionDto, Item item, Wallet wallet){
        WalletTransaction walletTransaction = new WalletTransaction();
        walletTransaction.setAmount(walletTransactionDto.getAmount());
        walletTransaction.setType(walletTransactionDto.getType());
        walletTransaction.setDescription(walletTransactionDto.getDescription());
        walletTransaction.setCreatedAt(LocalDateTime.now());
        walletTransaction.setImplDate(LocalDateTime.now());
        walletTransaction.setUser(authenticationFacade.getAuthenticationUser());
        walletTransaction.setItem(item);
        walletTransaction.setWallet(wallet);

        try{
            walletTransaction = walletTransactionRepository.save(walletTransaction);
            walletTransactionDto.setId(walletTransaction.getId());
            walletTransactionDto.setCreatedAt(walletTransaction.getCreatedAt());
            walletTransactionDto.setImplDate(walletTransaction.getImplDate());

            return walletTransactionDto;
        }
        catch(DataIntegrityViolationException e){
            return new AppException("Проверьте правильность введенных данных. Дублирование данных", HttpStatus.BAD_REQUEST).getMessage();
        }
    }
}
