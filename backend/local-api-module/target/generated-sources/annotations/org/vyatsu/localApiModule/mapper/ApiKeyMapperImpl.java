package org.vyatsu.localApiModule.mapper;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.vyatsu.localApiModule.dto.response.api.ApiKeyDto;
import org.vyatsu.localApiModule.entity.user.ApiKey;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-19T19:18:26+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
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
        LocalDate createdAt = null;

        id = apiKey.getId();
        key = apiKey.getKey();
        createdAt = apiKey.getCreatedAt();

        ApiKeyDto apiKeyDto = new ApiKeyDto( id, key, createdAt );

        return apiKeyDto;
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
        if ( apiKeyDto.getCreatedAt() != null ) {
            apiKey.setCreatedAt( apiKeyDto.getCreatedAt() );
        }

        return apiKey;
    }
}
