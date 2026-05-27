package com.gaurav.orderServiceDemo.feign;

import com.gaurav.userservice.userserviceDemo.dto.UserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {

    @GetMapping("/api/users/{id}")
    UserResponseDTO getUserById(Long id);
}
