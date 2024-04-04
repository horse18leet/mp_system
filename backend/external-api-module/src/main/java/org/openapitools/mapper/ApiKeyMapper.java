package org.openapitools.mapper;

import org.mapstruct.*;
import org.openapitools.dto.ApiKeyDto;
import org.openapitools.entity.ApiKey;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApiKeyMapper {
    ApiKey toEntity(ApiKeyDto apiKeyDto);

    ApiKeyDto toDto(ApiKey apiKey);

    List<ApiKey> toEntityList(List<ApiKeyDto> apiKeyDto);

    List<ApiKeyDto> toDtoList(List<ApiKey> apiKey);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ApiKey partialUpdate(ApiKeyDto apiKeyDto, @MappingTarget ApiKey apiKey);
}