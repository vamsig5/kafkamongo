package com.exilant.kafkatemp.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaReceiver {

	@KafkaListener(topics="test", groupId = "vamsi")
	public void recieve(String message) {
		System.out.println("recieve topic: "+message);
	}
}
