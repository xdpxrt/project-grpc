package com.xd_pxrt.projectgrpcgradleaccount.controller;

import com.xd_pxrt.projectgrpcgradleaccount.dto.validation.AccountValidation;
import com.xd_pxrt.projectgrpcgradleaccount.dto.AccountDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/account")
public interface AccountController {

    @PostMapping
    Mono<AccountDto> addAccount(@RequestBody @Validated(value = AccountValidation.onCreate.class) AccountDto dto);

    @GetMapping("/{id}")
    Mono<AccountDto> getAccount(@PathVariable String id);

    @GetMapping("/client/{clientId}")
    Flux<AccountDto> getAllAccountsOfClient(@PathVariable String clientId);

    @GetMapping()
    Flux<AccountDto> getAllAccounts();

}
