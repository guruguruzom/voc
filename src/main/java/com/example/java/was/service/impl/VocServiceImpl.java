package com.example.java.was.service.impl;

import java.util.HashMap;
import java.util.List;

import com.example.java.was.domain.ParamSet;
import com.example.java.was.domain.RegistDto;
import com.example.java.was.domain.VocDto;
import com.example.java.was.valueset.ResponseCode;

public interface VocServiceImpl {
	public HashMap<String, Object> getRegistInfo()  throws Exception;
	public HashMap<String, Object> setVoc(RegistDto registDto) throws Exception;
	public HashMap<String, Object> getVocList() throws Exception;
	public HashMap<String, Object> getVoc(Long vocId) throws Exception;
	public HashMap<String, Object> setState(Long vocId, String stateCode) throws Exception;
}
