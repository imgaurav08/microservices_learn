package com.gaurav.orderServiceDemo.orderServiceDemo.controller;

import com.gaurav.orderServiceDemo.orderServiceDemo.dto.OrderResponseDTO;
import com.gaurav.orderServiceDemo.orderServiceDemo.service.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private  final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{userID}")
    public OrderResponseDTO createOrder(@PathVariable Long userID){
       return orderService.createOrder(userID);
    }

}
