package com.gaurav.orderServiceDemo.orderServiceDemo.dto;

public record OrderResponseDTO(String message) {
    public OrderResponseDTO() {
        this(null);
    }
}
