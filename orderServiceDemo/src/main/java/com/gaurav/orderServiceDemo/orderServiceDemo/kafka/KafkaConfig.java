package com.gaurav.orderServiceDemo.orderServiceDemo.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic orderTopic(){
       return    new NewTopic("order-topic", 3,(short) 3);
    }

    @Bean
public NewTopic deadLetterTopic(){
        return    new NewTopic("order-dlt", 3,(short) 3);

}

}
