package com.rupp.finalprojectlms.mapper;

import com.rupp.finalprojectlms.domain.User;
import com.rupp.finalprojectlms.features.user.dto.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toUserResponse(User user);
    User toUser(UserResponse userResponse);
}
