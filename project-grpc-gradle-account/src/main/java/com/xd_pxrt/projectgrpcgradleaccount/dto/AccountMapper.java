package com.xd_pxrt.projectgrpcgradleaccount.dto;

import com.xd_pxrt.projectgrpcgradleaccount.data.model.Account;
import org.mapstruct.Mapper;
import reactor.core.publisher.Mono;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account toAccount(AccountDto accountDto);

    AccountDto toAccountDto(Account account);

    default Mono<AccountDto> toMonoAccountDto(Mono<Account> account) {
        return account.map(this::toAccountDto);
    }

}
