package com.example.java.was.service.impl;

import java.util.HashMap;

import com.example.java.was.domain.PenaltyDto;
import com.example.java.was.valueset.ResponseCode;

public interface PenaltyServiceImpl {
	
	public HashMap<String, Object> setPenalty(Long vocId);
	public HashMap<String, Object> setState(Long vocId, String stateCode);
}
