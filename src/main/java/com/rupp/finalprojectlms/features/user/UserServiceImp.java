package com.rupp.finalprojectlms.features.user;

import com.rupp.finalprojectlms.domain.User;
import com.rupp.finalprojectlms.features.user.dto.CreateUser;
import com.rupp.finalprojectlms.features.user.dto.UserResponse;
import com.rupp.finalprojectlms.mapper.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::toUserResponse).orElse(null);
    }

    @Override
    public UserResponse createUser(UserResponse userResponse) {
        // Convert UserResponse to User entity
        User user = userMapper.toUser(userResponse);

        // Save the User entity
        User savedUser = userRepository.save(user);

        // Map the saved User entity back to UserResponse
        return userMapper.toUserResponse(savedUser);
    }

    @Override
    public UserResponse updateUser(Long id, CreateUser createUser) {
        // Find the existing User entity by ID
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));

        // Update the User entity with data from CreateUser, only if non-null and non-empty
        if (createUser.getName() != null && !createUser.getName().isEmpty()) {
            existingUser.setName(createUser.getName());
        }
        if (createUser.getEmail() != null && !createUser.getEmail().isEmpty()) {
            existingUser.setEmail(createUser.getEmail());
        }

        // Save the updated User entity
        User updatedUser = userRepository.save(existingUser);

        // Map the updated User entity back to UserResponse
        return userMapper.toUserResponse(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found with id " + id);
        }
        userRepository.deleteById(id);
    }
    }


