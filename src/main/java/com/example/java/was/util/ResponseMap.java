package com.example.java.was.util;

import java.util.HashMap;

import com.example.java.was.valueset.ResponseCode;

public class ResponseMap {
	public static HashMap<String, Object> getResponseMap(ResponseCode successState, Object object) {
		
		HashMap<String, Object> responseMap = new HashMap<>();
		HashMap<String, Object> responseCode = new HashMap<>();
		
		responseCode.put("code", successState.getCode());
		responseCode.put("message", successState.getMessage());
		
		responseMap.put("header", responseCode);
		responseMap.put("body", object);
		
		return responseMap; 
	}
	
	public static HashMap<String, Object> getResponseMap(ResponseCode successState) {
		HashMap<String, Object> responseMap = new HashMap<>();
		
		HashMap<String, Object> responseCode = new HashMap<>();
		
		responseCode.put("code", successState.getCode());
		responseCode.put("message",  successState.getMessage());
		
		responseMap.put("header", responseCode);
		
		return responseMap; 
	}
}
