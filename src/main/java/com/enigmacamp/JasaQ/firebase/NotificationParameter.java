package com.enigmacamp.JasaQ.firebase;

public enum NotificationParameter {
	SOUND("default"),
	COLOR("#FFFF00");
	
	private String value;
	
	private NotificationParameter(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	

}
