package com.gaurav.userservice.userserviceDemo.controller;

import com.gaurav.userservice.userserviceDemo.dto.UserRequestDTO;
import com.gaurav.userservice.userserviceDemo.dto.UserResponseDTO;
import com.gaurav.userservice.userserviceDemo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService =userService;
    }

    @PostMapping("/create")
    public UserResponseDTO createUser(@RequestBody UserRequestDTO dto){
        return  userService.createUser(dto);
    }

    @GetMapping("/{id}")
    public  UserResponseDTO getUserById(@PathVariable Long id){
      return userService.getUserByID(id);
    }

}
