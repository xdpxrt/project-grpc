package com.xd_pxrt.projectgrpcgradleuser.dto;

import com.xd_pxrt.grpccommon.UserResponse;
import com.xd_pxrt.projectgrpcgradleuser.data.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toUser(UserRequestDto dto);

    UserResponseDto toUserResponseDto(User user);

    UserResponse toUserResponse(UserResponseDto dto);

}
