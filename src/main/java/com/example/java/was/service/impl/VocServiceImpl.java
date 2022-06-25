package com.example.java.was.service.impl;

import java.util.HashMap;
import java.util.List;

import com.example.java.was.domain.ParamSet;
import com.example.java.was.domain.VocDto;
import com.example.java.was.valueset.ResponseCode;

public interface VocServiceImpl {

	public HashMap<String, Object> setVoc(VocDto vocDto);
	public HashMap<String, Object> getVocList();
	public HashMap<String, Object> getVoc(Long vocId) throws Exception;
	public VocDto getVoc();
}
