package com.xd_pxrt.projectgrpcgradleaccount.grpc;

import com.xd_pxrt.grpccommon.UserProtoServiceGrpc;
import com.xd_pxrt.grpccommon.UserRequest;
import com.xd_pxrt.grpccommon.UserResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class UserGrpcServiceImpl extends UserProtoServiceGrpc.UserProtoServiceImplBase {

    @GrpcClient(value = "user-service")
    private UserProtoServiceGrpc.UserProtoServiceBlockingStub blockingStub;

    public UserResponse getUser(UserRequest request) {
        return blockingStub.getUser(request);
    }

}
