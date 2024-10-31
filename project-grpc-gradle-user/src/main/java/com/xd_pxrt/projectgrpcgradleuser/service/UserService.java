package com.xd_pxrt.projectgrpcgradleuser.service;

import com.xd_pxrt.projectgrpcgradleuser.dto.UserRequestDto;
import com.xd_pxrt.projectgrpcgradleuser.dto.UserResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.UUID;

public interface UserService {

    Mono<UserResponseDto> addUser(UserRequestDto userRequestDto);

    Mono<UserResponseDto> getUser(UUID id);

    Flux<UserResponseDto> getAllUsers();

}
