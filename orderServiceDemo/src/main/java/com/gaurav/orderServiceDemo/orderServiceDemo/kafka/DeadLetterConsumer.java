package com.gaurav.orderServiceDemo.orderServiceDemo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeadLetterConsumer {

@KafkaListener(topics = "order-dlt", groupId = "dlt-group")
    public void consumeDeadLetter(String message){
        System.out.println("Message received from dead letter topic" + message);
    }
}
