package com.example.java.was.util;

public class LogManager {
	
	public static String getLogMessage(String message,String[] value) {
		StringBuilder sb = new StringBuilder().append(message);
		
		for(String i : value) {
			sb.append(":").append(i);
		}
		
		return sb.toString();
	}
}
