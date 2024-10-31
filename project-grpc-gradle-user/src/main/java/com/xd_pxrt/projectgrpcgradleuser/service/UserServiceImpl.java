package com.xd_pxrt.projectgrpcgradleuser.service;

import com.xd_pxrt.projectgrpcgradleuser.data.model.User;
import com.xd_pxrt.projectgrpcgradleuser.data.repository.UserRepository;
import com.xd_pxrt.projectgrpcgradleuser.dto.UserMapper;
import com.xd_pxrt.projectgrpcgradleuser.dto.UserRequestDto;
import com.xd_pxrt.projectgrpcgradleuser.dto.UserResponseDto;
import com.xd_pxrt.projectgrpcgradleuser.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public Mono<UserResponseDto> addUser(UserRequestDto userRequestDto) {
        User user = userMapper.toUser(userRequestDto);
        Mono<User> savedUser = userRepository.save(user);
        return savedUser.map(userMapper::toUserResponseDto);
    }

    @Override
    public Mono<UserResponseDto> getUser(UUID id) {
        Mono<User> userMono = userRepository.findById(id);
        return userMono
                .switchIfEmpty(Mono.error(new NotFoundException(String.format("User ID %s not found", id))))
                .map(userMapper::toUserResponseDto);
    }

    @Override
    public Flux<UserResponseDto> getAllUsers() {
        return userRepository.findAll().map(userMapper::toUserResponseDto);
    }

}
