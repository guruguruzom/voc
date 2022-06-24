package com.example.java.was.service.impl;

import com.example.java.was.dto.VocDto;
import com.example.java.was.valueset.SuccessState;

public interface VocServiceImpl {

	public SuccessState setVoc(VocDto vocDto);
	public VocDto getVoc();
}
