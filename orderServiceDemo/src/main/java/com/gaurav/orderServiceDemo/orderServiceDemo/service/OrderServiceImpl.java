package com.gaurav.orderServiceDemo.orderServiceDemo.service;

import com.gaurav.orderServiceDemo.orderServiceDemo.dto.OrderResponseDTO;
import com.gaurav.orderServiceDemo.feign.UserClient;
import com.gaurav.userservice.userserviceDemo.dto.UserResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl  implements OrderService{


    private  final UserClient userClient;

    public OrderServiceImpl(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public OrderResponseDTO createOrder(Long userID) {
        UserResponseDTO dto = userClient.getUserById(userID);
        return new OrderResponseDTO("Order for user is created :" + dto.name());
    }
}
