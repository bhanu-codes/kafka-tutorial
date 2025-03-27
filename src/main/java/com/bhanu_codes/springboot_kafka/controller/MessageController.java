package com.bhanu_codes.springboot_kafka.controller;

import com.bhanu_codes.springboot_kafka.entity.User;
import com.bhanu_codes.springboot_kafka.producers.JsonKafkaProducer;
import com.bhanu_codes.springboot_kafka.producers.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    //http://localhost:8080/api/v1/kafka/publish?message=hi bhanu
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }

    @PostMapping("/publish-user")
    public ResponseEntity<String> publishUser(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
