package com.xd_pxrt.projectgrpcgradleaccount.data.repository;

import com.xd_pxrt.projectgrpcgradleaccount.data.model.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<Account, UUID> {

    Flux<Account> findByClientId(UUID clientId);
}
