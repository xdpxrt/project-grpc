package com.xd_pxrt.projectgrpcgradleuser.grpc;

import com.xd_pxrt.grpccommon.UserProtoServiceGrpc;
import com.xd_pxrt.grpccommon.UserRequest;
import com.xd_pxrt.grpccommon.UserResponse;
import com.xd_pxrt.projectgrpcgradleuser.dto.UserMapper;
import com.xd_pxrt.projectgrpcgradleuser.dto.UserResponseDto;
import com.xd_pxrt.projectgrpcgradleuser.exception.NotFoundException;
import com.xd_pxrt.projectgrpcgradleuser.service.UserService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import reactor.core.publisher.Mono;
import java.util.UUID;

@Slf4j
@GrpcService
@RequiredArgsConstructor
public class UserGrpcServiceExt extends UserProtoServiceGrpc.UserProtoServiceImplBase {

    private final UserService userService;

    private final UserMapper userMapper;

    @Override
    public void getUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        try {
            Mono<UserResponseDto> user = userService.getUser(UUID.fromString(request.getId()));
            responseObserver.onNext(user.map(userMapper::toUserResponse).block());
            responseObserver.onCompleted();
        } catch (NotFoundException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asException());
        }
    }

}
