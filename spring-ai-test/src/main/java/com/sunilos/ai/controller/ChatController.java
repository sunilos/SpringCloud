package com.sunilos.ai.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunilos.ai.form.ChatRequest;
import com.sunilos.ai.service.ChatService;

@RestController
@RequestMapping("/api")
public class ChatController {

	private final ChatService chatService;

	public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}

	@PostMapping("/ask")
	public String ask(@RequestBody ChatRequest request) {
		String ans = chatService.ask(request.getQuestion());
		System.out.println("Answer: " + ans);
		return ans;
	}
}
