package com.example.java.was.service.impl;

import java.util.HashMap;

import com.example.java.was.domain.CompensationDto;
import com.example.java.was.valueset.ResponseCode;

public interface CompensationServiceImpl {
	
	public HashMap<String, Object> setCompensation(Long vocId, CompensationDto compensationDto) throws Exception;
	public HashMap<String, Object> getCompensationList() throws Exception;
	
}
