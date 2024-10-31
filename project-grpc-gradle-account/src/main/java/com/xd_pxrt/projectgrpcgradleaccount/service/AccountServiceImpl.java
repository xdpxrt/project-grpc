package com.xd_pxrt.projectgrpcgradleaccount.service;

import com.xd_pxrt.grpccommon.UserRequest;
import com.xd_pxrt.projectgrpcgradleaccount.data.model.Account;
import com.xd_pxrt.projectgrpcgradleaccount.data.repository.AccountRepository;
import com.xd_pxrt.projectgrpcgradleaccount.dto.AccountDto;
import com.xd_pxrt.projectgrpcgradleaccount.dto.AccountMapper;
import com.xd_pxrt.projectgrpcgradleaccount.excpetion.NotFoundException;
import com.xd_pxrt.projectgrpcgradleaccount.grpc.UserGrpcServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    private final UserGrpcServiceImpl userService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Mono<AccountDto> addAccount(AccountDto accountDto) {
        try {
            userService.getUser(UserRequest
                    .newBuilder()
                    .setId(accountDto.getClientId())
                    .build());
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }

        Account account = accountMapper.toAccount(accountDto);
        Mono<Account> savedAccount = accountRepository.save(account);
        return savedAccount.map(accountMapper::toAccountDto);
    }

    @Override
    public Mono<AccountDto> getAccount(UUID id) {
        return accountRepository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException(String.format("Account ID %s not found", id))))
                .map(accountMapper::toAccountDto);
    }

    @Override
    public Flux<AccountDto> getAllAccountsOfClient(UUID clientId) {
        return accountRepository.findByClientId(clientId)
                .map(accountMapper::toAccountDto);
    }

    @Override
    public Flux<AccountDto> getAllAccounts() {
        return accountRepository.findAll().map(accountMapper::toAccountDto);
    }

}
