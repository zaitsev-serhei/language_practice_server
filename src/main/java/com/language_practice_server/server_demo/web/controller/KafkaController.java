package com.language_practice_server.server_demo.web.controller;

import com.language_practice_server.server_demo.kafka.KafkaEventProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
//    private final KafkaEventProducer service;
//
//    public KafkaController(KafkaEventProducer service) {
//        this.service = service;
//    }
//    @GetMapping("/send")
//    public String send(@RequestParam (defaultValue = "test1") String msg) {
//        service.publish("tasks-events", msg);
//        return "Message sent: " + msg;
//    }
}
