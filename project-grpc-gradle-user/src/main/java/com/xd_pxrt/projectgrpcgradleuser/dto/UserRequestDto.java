package com.xd_pxrt.projectgrpcgradleuser.dto;

import com.xd_pxrt.projectgrpcgradleuser.dto.validation.UserValidation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    @NotNull(groups = UserValidation.onCreate.class)
    @Size(min = 5, max = 15, groups = {UserValidation.onCreate.class, UserValidation.onUpdate.class})
    private String username;

    @NotNull(groups = UserValidation.onCreate.class)
    @Size(min = 8, max = 15, groups = {UserValidation.onCreate.class, UserValidation.onUpdate.class})
    private String password;

    @NotNull(groups = UserValidation.onCreate.class)
    @Email(groups = {UserValidation.onCreate.class, UserValidation.onUpdate.class})
    private String email;

    @NotNull(groups = UserValidation.onCreate.class)
    @Past(groups = {UserValidation.onCreate.class, UserValidation.onUpdate.class})
    private LocalDate birthday;

}
