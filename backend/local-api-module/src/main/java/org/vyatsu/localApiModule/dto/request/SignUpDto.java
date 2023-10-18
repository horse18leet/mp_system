package org.vyatsu.localApiModule.dto.request;

import org.vyatsu.localApiModule.entity.enums.RoleType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String email;

    @NotEmpty
    private CharSequence password;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private RoleType roleType = RoleType.USER;
}
