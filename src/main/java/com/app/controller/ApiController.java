package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@GetMapping("/")
	public String home() {
		return "Web Socket Start!!";
	}

	@GetMapping("/test")
	public Boolean test() {
		String msg = "똥고앵이 김짜짜";
		messagingTemplate.convertAndSend("/topic/bean", msg);
		return true;
	}
	
}
