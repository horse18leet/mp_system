package org.openapitools.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.openapitools.dto.ApiKeyDto;
import org.openapitools.entity.ApiKey;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< Updated upstream
    date = "2024-04-04T11:55:55+0300",
=======
    date = "2024-05-03T15:22:05+0300",
>>>>>>> Stashed changes
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ApiKeyMapperImpl implements ApiKeyMapper {

    @Override
    public ApiKey toEntity(ApiKeyDto apiKeyDto) {
        if ( apiKeyDto == null ) {
            return null;
        }

        ApiKey apiKey = new ApiKey();

        apiKey.setId( apiKeyDto.getId() );
        apiKey.setKey( apiKeyDto.getKey() );
        apiKey.setClientId( apiKeyDto.getClientId() );
        apiKey.setType( apiKeyDto.getType() );
        apiKey.setUserId( apiKeyDto.getUserId() );

        return apiKey;
    }

    @Override
    public ApiKeyDto toDto(ApiKey apiKey) {
        if ( apiKey == null ) {
            return null;
        }

        ApiKeyDto.ApiKeyDtoBuilder apiKeyDto = ApiKeyDto.builder();

        apiKeyDto.id( apiKey.getId() );
        apiKeyDto.key( apiKey.getKey() );
        apiKeyDto.clientId( apiKey.getClientId() );
        apiKeyDto.type( apiKey.getType() );
        apiKeyDto.userId( apiKey.getUserId() );

        return apiKeyDto.build();
    }

    @Override
    public List<ApiKey> toEntityList(List<ApiKeyDto> apiKeyDto) {
        if ( apiKeyDto == null ) {
            return null;
        }

        List<ApiKey> list = new ArrayList<ApiKey>( apiKeyDto.size() );
        for ( ApiKeyDto apiKeyDto1 : apiKeyDto ) {
            list.add( toEntity( apiKeyDto1 ) );
        }

        return list;
    }

    @Override
    public List<ApiKeyDto> toDtoList(List<ApiKey> apiKey) {
        if ( apiKey == null ) {
            return null;
        }

        List<ApiKeyDto> list = new ArrayList<ApiKeyDto>( apiKey.size() );
        for ( ApiKey apiKey1 : apiKey ) {
            list.add( toDto( apiKey1 ) );
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
        if ( apiKeyDto.getClientId() != null ) {
            apiKey.setClientId( apiKeyDto.getClientId() );
        }
        if ( apiKeyDto.getType() != null ) {
            apiKey.setType( apiKeyDto.getType() );
        }
        apiKey.setUserId( apiKeyDto.getUserId() );

        return apiKey;
    }
}
