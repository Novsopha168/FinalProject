package com.rupp.finalprojectlms.features.user;


import com.rupp.finalprojectlms.domain.User;
import com.rupp.finalprojectlms.features.user.dto.CreateUser;
import com.rupp.finalprojectlms.features.user.dto.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

interface UserService {
    List<UserResponse > getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse createUser(UserResponse userResponse);
    UserResponse updateUser(Long id, CreateUser createUser);
    void deleteUser(Long id);
}
