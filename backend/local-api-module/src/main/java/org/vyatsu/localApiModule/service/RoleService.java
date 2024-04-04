package org.vyatsu.localApiModule.service;

import org.vyatsu.localApiModule.entity.enums.RoleType;
import org.vyatsu.localApiModule.entity.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.vyatsu.localApiModule.repository.RoleRepository;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoleService {
    private final RoleRepository roleRepository;

    /**
     * Получает роль по ее имени.
     *
     * @param name Название роли.
     * @return Объект роли, если она найдена, в противном случае выбрасывает исключение.
     * @throws RoleNotFoundException Исключение, возникающее при отсутствии роли с указанным именем.
     */
    public Role getRole(RoleType name) throws RoleNotFoundException {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new RoleNotFoundException("Role not found"));
    }

    /**
     * Получает список разрешений (permissions) в форме SimpleGrantedAuthority для пользователя с указанным идентификатором.
     *
     * @param userId Идентификатор пользователя.
     * @return Список разрешений пользователя, включая его роль, в форме SimpleGrantedAuthority.
     * @throws RoleNotFoundException Исключение, возникающее при отсутствии роли пользователя.
     */
    public List<SimpleGrantedAuthority> getAuthorities(Long userId) throws RoleNotFoundException {
        Role role = roleRepository.findByUserId(userId)
                .orElseThrow(() -> new RoleNotFoundException("Role not found"));

        // ? Добавляет все полномочия у конкретной роли
        List<SimpleGrantedAuthority> authorities = role.getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                .collect(Collectors.toList());

        // ? Непосредственно добавляет роль пользователя
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));

        return authorities;
    }
}