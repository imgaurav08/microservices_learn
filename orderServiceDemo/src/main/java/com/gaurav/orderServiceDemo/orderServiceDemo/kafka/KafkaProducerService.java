package com.gaurav.orderServiceDemo.orderServiceDemo.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {


    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    private final String TOPIC = "order-topic";

    public void sendMessage(String message){
        kafkaTemplate.send(TOPIC,message);
        System.out.println("Message sent to kafka topic:" + message);
    }

}
