package com.enesselvi.kafkaproducerservice.controller;

import com.enesselvi.kafkaproducerservice.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    private KafkaProducerService kafkaProducerService;

    @Autowired
    public KafkaProducerController(KafkaProducerService kafkaProducerService){
        this.kafkaProducerService=kafkaProducerService;
    } //dependency injection

    @PostMapping("/sendmessage")
    public  String sendMessage(@RequestBody String message){
        try {
            kafkaProducerService.sendMessage(message);
            return "OK";
        } catch (Exception e) {
            e.printStackTrace();
            return "NOK";
        }
    }
}
