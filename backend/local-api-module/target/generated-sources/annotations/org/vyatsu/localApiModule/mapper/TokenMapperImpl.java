package org.vyatsu.localApiModule.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.vyatsu.localApiModule.dto.response.api.TokenDto;
import org.vyatsu.localApiModule.entity.enums.TokenType;
import org.vyatsu.localApiModule.entity.user.Token;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-19T19:18:26+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class TokenMapperImpl implements TokenMapper {

    @Override
    public Token toEntity(TokenDto tokenDto) {
        if ( tokenDto == null ) {
            return null;
        }

        Token.TokenBuilder token = Token.builder();

        token.id( tokenDto.getId() );
        token.token( tokenDto.getToken() );
        token.type( tokenDto.getType() );
        token.revoked( tokenDto.isRevoked() );
        token.expired( tokenDto.isExpired() );

        return token.build();
    }

    @Override
    public TokenDto toDto(Token token) {
        if ( token == null ) {
            return null;
        }

        Long id = null;
        String token1 = null;
        TokenType type = null;
        boolean revoked = false;
        boolean expired = false;

        id = token.getId();
        token1 = token.getToken();
        type = token.getType();
        revoked = token.isRevoked();
        expired = token.isExpired();

        TokenDto tokenDto = new TokenDto( id, token1, type, revoked, expired );

        return tokenDto;
    }

    @Override
    public Token partialUpdate(TokenDto tokenDto, Token token) {
        if ( tokenDto == null ) {
            return token;
        }

        if ( tokenDto.getId() != null ) {
            token.setId( tokenDto.getId() );
        }
        if ( tokenDto.getToken() != null ) {
            token.setToken( tokenDto.getToken() );
        }
        if ( tokenDto.getType() != null ) {
            token.setType( tokenDto.getType() );
        }
        token.setRevoked( tokenDto.isRevoked() );
        token.setExpired( tokenDto.isExpired() );

        return token;
    }
}
