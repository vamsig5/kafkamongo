package com.exilant.kafkatemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exilant.kafkatemp.service.KafkaSender;

@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	private KafkaSender kafkaSender;
	@PostMapping("/kafka/{topicName}")
	public String sendtotopic(@PathVariable String topicName, @RequestBody String message) {
	
		kafkaSender.send(topicName, message);
		
		return message;
		
	}
}
