package com.franco.apirfstockmanager.util;

public class Message {
	private String type;
	private String message;
	
	public Message (String type, String message) {
		this.type = type;
		this.message = message;
	}
	
	public static Message error(String message) {
		return new Message("Error", message);
	}
	public static Message warning(String message) {
		return new Message("Advertencia", message);
	}

	public static Message exeption(String message) {
		return new Message("Ecepción", message );
	}
	
	public static Message succes(String Message) {
		return new Message("Éxito", Message);
	}
	
    public String getType() {
        return type;
    }

	public String getMessage() {
		return message;
	}

}
