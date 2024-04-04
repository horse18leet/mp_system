package org.vyatsu.localApiModule.mapper;

import org.mapstruct.*;
import org.vyatsu.localApiModule.dto.WalletTransactionDto;
import org.vyatsu.localApiModule.entity.contractor.WalletTransaction;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface WalletTransactionMapper {
    WalletTransaction toEntity(WalletTransactionDto walletTransactionDto);

    WalletTransactionDto toDto(WalletTransaction walletTransaction);

    List<WalletTransactionDto> toDtoList(List<WalletTransaction> walletTransaction);

    List<WalletTransaction> toEntityList(List<WalletTransactionDto> walletTransactionDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    WalletTransaction partialUpdate(WalletTransactionDto walletTransactionDto, @MappingTarget WalletTransaction walletTransaction);
}