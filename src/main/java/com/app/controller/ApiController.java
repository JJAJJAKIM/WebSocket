package com.app.controller;

import com.app.dto.ChannelDTO;
import com.app.mapper.ChannelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@Autowired
	private ChannelMapper channelMapper;

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

	@PostMapping("/getChannel")
	public List<ChannelDTO> getChannel() {
		return channelMapper.getChannel();
	}
}
