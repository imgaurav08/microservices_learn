package com.gaurav.orderServiceDemo.orderServiceDemo.service;

import com.gaurav.orderServiceDemo.orderServiceDemo.dto.OrderResponseDTO;

public interface OrderService {

    OrderResponseDTO createOrder(Long userID);
}
