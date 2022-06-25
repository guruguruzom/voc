package com.example.java.was.valueset;

public enum ResponseCode {
	SUCCESS(100,"success"),
	FAILED_NOT_FOUND(200,"failed not found"),
	FAILED_EXISTS(201,"failed exists");
	
	int code;
	String message;
	
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean isSuccess(int code) {
		return code == 100;
	}
	
	ResponseCode(int code, String message){
		this.code = code;
		this.message = message;
	}
	
	public static ResponseCode getEnumFromString(int code) throws Exception {
		for(ResponseCode ps : ResponseCode.values()) {
			if(ps.getCode() == code) {
				return ps;
			}
		}
		
		throw new Exception("Invalid PenaltyStateCode");
	}
}
