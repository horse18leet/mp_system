package org.vyatsu.localApiModule.mapper;

import org.mapstruct.*;
import org.vyatsu.localApiModule.dto.response.api.TokenDto;
import org.vyatsu.localApiModule.entity.user.Token;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TokenMapper {
    Token toEntity(TokenDto tokenDto);

    TokenDto toDto(Token token);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Token partialUpdate(TokenDto tokenDto, @MappingTarget Token token);
}