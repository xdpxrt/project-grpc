package com.xd_pxrt.projectgrpcgradleuser.data.repository;

import com.xd_pxrt.projectgrpcgradleuser.data.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import java.util.UUID;

public interface UserRepository extends ReactiveCrudRepository<User, UUID> {
}
