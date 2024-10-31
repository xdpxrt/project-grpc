package com.xd_pxrt.projectgrpcgradleaccount.controller;

import com.xd_pxrt.projectgrpcgradleaccount.dto.AccountDto;
import com.xd_pxrt.projectgrpcgradleaccount.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AccountControllerImpl implements AccountController {

    private final AccountService accountService;

    @Override
    public Mono<AccountDto> addAccount(AccountDto accountDto) {
        return accountService.addAccount(accountDto);
    }

    @Override
    public Mono<AccountDto> getAccount(String id) {
        return accountService.getAccount(UUID.fromString(id));
    }

    @Override
    public Flux<AccountDto> getAllAccountsOfClient(String clientId) {
        return accountService.getAllAccountsOfClient(UUID.fromString(clientId));
    }

    @Override
    public Flux<AccountDto> getAllAccounts() {
        return accountService.getAllAccounts();
    }

}
