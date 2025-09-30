package com.sunilos.ai.form;

public class ChatRequest {

	private String question;

	public ChatRequest() {
		// Default constructor
	}

	public ChatRequest(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
