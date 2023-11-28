package org.vyatsu.localApiModule.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.vyatsu.localApiModule.dto.response.api.ApiKeyDto;
import org.vyatsu.localApiModule.entity.enums.ApiKeyType;
import org.vyatsu.localApiModule.entity.user.ApiKey;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-28T17:12:18+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ApiKeyMapperImpl implements ApiKeyMapper {

    @Override
    public ApiKey toEntity(ApiKeyDto apiKeyDto) {
        if ( apiKeyDto == null ) {
            return null;
        }

        ApiKey.ApiKeyBuilder apiKey = ApiKey.builder();

        apiKey.id( apiKeyDto.getId() );
        apiKey.key( apiKeyDto.getKey() );
        apiKey.type( apiKeyDto.getType() );
        apiKey.createdAt( apiKeyDto.getCreatedAt() );

        return apiKey.build();
    }

    @Override
    public ApiKeyDto toDto(ApiKey apiKey) {
        if ( apiKey == null ) {
            return null;
        }

        Long id = null;
        String key = null;
        ApiKeyType type = null;
        LocalDateTime createdAt = null;

        id = apiKey.getId();
        key = apiKey.getKey();
        type = apiKey.getType();
        createdAt = apiKey.getCreatedAt();

        ApiKeyDto apiKeyDto = new ApiKeyDto( id, key, type, createdAt );

        return apiKeyDto;
    }

    @Override
    public List<ApiKeyDto> toDtoList(List<ApiKey> apiKeys) {
        if ( apiKeys == null ) {
            return null;
        }

        List<ApiKeyDto> list = new ArrayList<ApiKeyDto>( apiKeys.size() );
        for ( ApiKey apiKey : apiKeys ) {
            list.add( toDto( apiKey ) );
        }

        return list;
    }

    @Override
    public ApiKey partialUpdate(ApiKeyDto apiKeyDto, ApiKey apiKey) {
        if ( apiKeyDto == null ) {
            return apiKey;
        }

        if ( apiKeyDto.getId() != null ) {
            apiKey.setId( apiKeyDto.getId() );
        }
        if ( apiKeyDto.getKey() != null ) {
            apiKey.setKey( apiKeyDto.getKey() );
        }
        if ( apiKeyDto.getType() != null ) {
            apiKey.setType( apiKeyDto.getType() );
        }
        if ( apiKeyDto.getCreatedAt() != null ) {
            apiKey.setCreatedAt( apiKeyDto.getCreatedAt() );
        }

        return apiKey;
    }
}
