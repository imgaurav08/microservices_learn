package com.gaurav.userservice.userserviceDemo.service;

import com.gaurav.userservice.userserviceDemo.dto.UserRequestDTO;
import com.gaurav.userservice.userserviceDemo.dto.UserResponseDTO;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO dto);
    UserResponseDTO getUserByID(Long id);
}
