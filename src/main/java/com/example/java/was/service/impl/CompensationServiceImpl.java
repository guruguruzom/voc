package com.example.java.was.service.impl;

import com.example.java.was.domain.CompensationDto;
import com.example.java.was.valueset.SuccessState;

public interface CompensationServiceImpl {
	public SuccessState setCompensation(CompensationDto compensationDto);
}
