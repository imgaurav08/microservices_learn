package com.gaurav.orderServiceDemo.orderServiceDemo.kafka;

import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaErrorHandlerConfig {

    public DefaultErrorHandler kafkaErrorHandler(
            KafkaTemplate<String,String> kafkaTemplate
    )
    {
        DeadLetterPublishingRecoverer recoverer = new DeadLetterPublishingRecoverer(
                kafkaTemplate,(record,ex)-> new TopicPartition("order-dlt", record.partition())
        );
        FixedBackOff backOff = new FixedBackOff(2000,3);
        return new DefaultErrorHandler(recoverer,backOff);
    }

}
