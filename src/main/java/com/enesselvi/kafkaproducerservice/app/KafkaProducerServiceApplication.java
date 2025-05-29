package com.enesselvi.kafkaproducerservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.enesselvi.*"})
public class KafkaProducerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerServiceApplication.class, args);
	}

}
