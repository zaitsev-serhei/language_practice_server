package com.language_practice_server.server_demo.service.impl;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = "tasks-events", groupId = "task-group")
public class KafkaConsumerService {
    @KafkaHandler
    public void consume(String message) {
        System.out.println("Received: " + message);
    }
}
