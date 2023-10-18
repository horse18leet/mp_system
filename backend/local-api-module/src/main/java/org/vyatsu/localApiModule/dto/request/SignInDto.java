package org.vyatsu.localApiModule.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInDto {

    @NotEmpty
    private String email;

    @NotEmpty
    private CharSequence password;
}
