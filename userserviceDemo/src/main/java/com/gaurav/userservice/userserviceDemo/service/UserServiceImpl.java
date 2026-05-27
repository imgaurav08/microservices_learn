package com.gaurav.userservice.userserviceDemo.service;

import com.gaurav.userservice.userserviceDemo.dto.UserRequestDTO;
import com.gaurav.userservice.userserviceDemo.dto.UserResponseDTO;
import com.gaurav.userservice.userserviceDemo.entity.User;
import com.gaurav.userservice.userserviceDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
User  user = new User();
user.setName(dto.name());
user.setEmail(dto.email());
return mapToResponseDTO(userRepository.save(user));
    }

    @Override
    public UserResponseDTO getUserByID(Long id) {
User user =userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found with id:" + id));
return mapToResponseDTO(user);
    }


    private UserResponseDTO mapToResponseDTO(User user){
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }

}
