package com.language_practice_server.server_demo.web.controller;

import com.language_practice_server.server_demo.service.impl.KafkaProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final KafkaProducerService service;

    public KafkaController(KafkaProducerService service) {
        this.service = service;
    }
    @GetMapping("/send")
    public String send(@RequestParam (defaultValue = "test1") String msg) {
        service.sendMessage("tasks-events", msg);
        return "Message sent: " + msg;
    }
}
