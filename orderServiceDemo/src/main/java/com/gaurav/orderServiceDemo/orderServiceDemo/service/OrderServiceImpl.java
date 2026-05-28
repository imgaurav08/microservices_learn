package com.gaurav.orderServiceDemo.orderServiceDemo.service;

import com.gaurav.orderServiceDemo.orderServiceDemo.dto.OrderResponseDTO;
import com.gaurav.orderServiceDemo.orderServiceDemo.feign.UserClient;
import com.gaurav.orderServiceDemo.orderServiceDemo.kafka.KafkaProducerService;
import com.gaurav.userservice.userserviceDemo.dto.UserResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl  implements OrderService{


    private  final UserClient userClient;
    private  final KafkaProducerService kafkaProducerService;

    public OrderServiceImpl(UserClient userClient,KafkaProducerService kafkaProducerService) {
        this.userClient = userClient;
        this.kafkaProducerService= kafkaProducerService;
    }

    @Override
    @CircuitBreaker(name="userServiceCircuitBreaker" , fallbackMethod = "fallbackCreateOrder")
    public OrderResponseDTO createOrder(Long userID) {
        UserResponseDTO dto = userClient.getUserById(userID);
        String message = "Order for user is created :" + dto.name();
        kafkaProducerService.sendMessage(message);
        return new OrderResponseDTO(message);
    }


    public OrderResponseDTO fallbackCreateOrder(Long id, Exception ex){
        return  new OrderResponseDTO("User service is down. Please try later" + id);

    }
}
