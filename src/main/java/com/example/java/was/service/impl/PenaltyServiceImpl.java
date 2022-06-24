package com.example.java.was.service.impl;

import com.example.java.was.domain.PenaltyDto;
import com.example.java.was.valueset.SuccessState;

public interface PenaltyServiceImpl {
	
	public SuccessState setPenalty(Long vocId);
	
	public SuccessState setState(Long vocId, String stateCode);
}
