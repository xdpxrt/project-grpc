package com.xd_pxrt.projectgrpcgradleaccount.dto;

import com.xd_pxrt.projectgrpcgradleaccount.dto.validation.AccountValidation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    @Null(groups = AccountValidation.onCreate.class)
    @NotNull(groups = AccountValidation.onUpdate.class)
    private UUID id;

    @NotNull(groups = AccountValidation.onCreate.class)
    private String clientId;

    @NotNull(groups = AccountValidation.onCreate.class)
    private String currency;

    @Min(value = 0)
    @NotNull(groups = AccountValidation.onCreate.class)
    private BigDecimal balance;

}
