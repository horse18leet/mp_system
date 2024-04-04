package org.vyatsu.localApiModule.mapper;

import org.mapstruct.*;
import org.vyatsu.localApiModule.entity.contractor.Wallet;
import org.vyatsu.localApiModule.dto.response.api.WalletDto;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface WalletMapper {
    Wallet toEntity(WalletDto walletDto);

    WalletDto toDto(Wallet wallet);

    List<Wallet> toEntityList(List<WalletDto> walletDto);

    List<WalletDto> toDtoList(List<Wallet> wallet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Wallet partialUpdate(WalletDto walletDto, @MappingTarget Wallet wallet);
}