package com.enigmacamp.JasaQ.entity;

public class PushNotificationRequest {
	private String title;
	private String topic;
	private String message;
	private String token;
	
	public PushNotificationRequest() {
		// TODO Auto-generated constructor stub
	}

	public PushNotificationRequest(String title, String topic, String message) {
		this.title = title;
		this.topic = topic;
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
