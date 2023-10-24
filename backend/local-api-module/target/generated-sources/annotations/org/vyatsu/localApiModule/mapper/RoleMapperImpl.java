package org.vyatsu.localApiModule.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.vyatsu.localApiModule.dto.response.api.RoleDto;
import org.vyatsu.localApiModule.entity.enums.RoleType;
import org.vyatsu.localApiModule.entity.role.Role;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-24T20:22:00+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toEntity(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.id( roleDto.getId() );
        role.name( roleDto.getName() );

        return role.build();
    }

    @Override
    public RoleDto toDto(Role role) {
        if ( role == null ) {
            return null;
        }

        Long id = null;
        RoleType name = null;

        id = role.getId();
        name = role.getName();

        RoleDto roleDto = new RoleDto( id, name );

        return roleDto;
    }

    @Override
    public Role partialUpdate(RoleDto roleDto, Role role) {
        if ( roleDto == null ) {
            return role;
        }

        if ( roleDto.getId() != null ) {
            role.setId( roleDto.getId() );
        }
        if ( roleDto.getName() != null ) {
            role.setName( roleDto.getName() );
        }

        return role;
    }
}
