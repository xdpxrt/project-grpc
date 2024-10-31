package com.xd_pxrt.projectgrpcgradleaccount.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    private UUID id;

    @Column(value = "client_id")
    private UUID clientId;

    private CurrencyType currency;

    private BigDecimal balance;

}
