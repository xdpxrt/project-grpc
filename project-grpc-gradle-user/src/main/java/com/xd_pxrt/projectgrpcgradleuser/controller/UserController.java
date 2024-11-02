package com.xd_pxrt.projectgrpcgradleuser.controller;

import com.xd_pxrt.projectgrpcgradleuser.dto.UserRequestDto;
import com.xd_pxrt.projectgrpcgradleuser.dto.UserResponseDto;
import com.xd_pxrt.projectgrpcgradleuser.dto.validation.UserValidation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/user")
public interface UserController {

    @PostMapping
    Mono<UserResponseDto> addUser(@RequestBody @Validated(UserValidation.onCreate.class) UserRequestDto userRequestDto);

    @GetMapping("/{id}")
    Mono<UserResponseDto> getUser(@PathVariable String id);

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<UserResponseDto> getUsers();

}
