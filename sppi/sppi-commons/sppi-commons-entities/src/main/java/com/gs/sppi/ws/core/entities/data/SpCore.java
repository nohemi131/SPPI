package com.gs.sppi.ws.core.entities.data;

public class SpCore {

	private int code;
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "SpCore [code=" + code + ", message=" + message + "]";
	}
	
}
