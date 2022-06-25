package com.example.java.was.service.impl;

import java.util.HashMap;

import com.example.java.was.domain.PenaltyDto;
import com.example.java.was.valueset.ResponseCode;

public interface PenaltyServiceImpl {
	
	public HashMap<String, Object> setPenalty(Long vocId, PenaltyDto penaltyDto) throws Exception ;
	public HashMap<String, Object> setState(Long vocId, String stateCode) throws Exception;
}
