package com.enesselvi.kafkaproducerservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);
    private KafkaTemplate<String , String> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String , String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("KafkaProducerService | '%s' message is received" , message));

        Message<String> kafkaMessage = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC , "predictionRequests")
                .setHeader(KafkaHeaders.TIMESTAMP, System.currentTimeMillis())
                .build();
        kafkaTemplate.send(kafkaMessage);
    }
}
