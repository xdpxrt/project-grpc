package com.xd_pxrt.projectgrpcgradleuser.controller;

import com.xd_pxrt.projectgrpcgradleuser.dto.UserRequestDto;
import com.xd_pxrt.projectgrpcgradleuser.dto.UserResponseDto;
import com.xd_pxrt.projectgrpcgradleuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public Mono<UserResponseDto> addUser(UserRequestDto userRequestDto) {
        return userService.addUser(userRequestDto);
    }

    @Override
    public Mono<UserResponseDto> getUser(String id) {
        return userService.getUser(UUID.fromString(id));
    }

    @Override
    public Flux<UserResponseDto> getUsers() {
        return userService.getAllUsers();
    }

}
