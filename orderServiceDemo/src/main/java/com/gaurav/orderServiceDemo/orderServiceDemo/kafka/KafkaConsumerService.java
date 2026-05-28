package com.gaurav.orderServiceDemo.orderServiceDemo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "order-topic", groupId = "order-group")
    public void consumer(String message){
        System.out.println("Message received from kafka topic:" + message);

        if (message.contains("FAIL")){
            throw  new RuntimeException("Kafka message failed");
        }

        System.out.println("Message Process successfully");

    }

}
