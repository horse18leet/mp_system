package org.vyatsu.localApiModule.mapper;

import org.mapstruct.*;
import org.vyatsu.localApiModule.dto.response.api.ApiKeyDto;
import org.vyatsu.localApiModule.entity.user.ApiKey;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApiKeyMapper {
    ApiKey toEntity(ApiKeyDto apiKeyDto);

    ApiKeyDto toDto(ApiKey apiKey);

    List<ApiKeyDto> toDtoList(List<ApiKey> apiKeys);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ApiKey partialUpdate(ApiKeyDto apiKeyDto, @MappingTarget ApiKey apiKey);
}