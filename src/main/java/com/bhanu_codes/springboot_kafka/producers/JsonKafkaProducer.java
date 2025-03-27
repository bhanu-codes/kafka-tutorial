package com.bhanu_codes.springboot_kafka.producers;

import com.bhanu_codes.springboot_kafka.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaProducer {

    @Autowired
    private KafkaTemplate<String, User> userKafkaTemplate;

    public void sendMessage(User userDetails){
        Message<User> message = MessageBuilder
                .withPayload(userDetails)
                .setHeader(KafkaHeaders.TOPIC, "bhanu-codes")
                .build();
        userKafkaTemplate.send(message);
        log.info("message sent {}", message.toString());
    }
}
