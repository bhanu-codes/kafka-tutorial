package com.bhanu_codes.springboot_kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "bhanu-codes", groupId = "kafkaGroup")
    public void consumer(String message){
        log.info("message received {}", message);
    }
}
