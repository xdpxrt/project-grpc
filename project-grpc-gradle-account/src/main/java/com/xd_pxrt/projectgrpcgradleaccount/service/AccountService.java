package com.xd_pxrt.projectgrpcgradleaccount.service;

import com.xd_pxrt.projectgrpcgradleaccount.dto.AccountDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.UUID;

public interface AccountService {

    Mono<AccountDto> addAccount(AccountDto accountDto);

    Mono<AccountDto> getAccount(UUID accountId);

    Flux<AccountDto> getAllAccountsOfClient(UUID clientId);

    Flux<AccountDto> getAllAccounts();

}
