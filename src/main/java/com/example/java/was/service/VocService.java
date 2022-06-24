package com.example.java.was.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.was.domain.ParamSet;
import com.example.java.was.domain.VocDto;
import com.example.java.was.entity.PenaltyVo;
import com.example.java.was.entity.VocVo;
import com.example.java.was.repository.PenaltyRepository;
import com.example.java.was.repository.VocRepository;
import com.example.java.was.service.impl.VocServiceImpl;
import com.example.java.was.util.ResponseMap;
import com.example.java.was.valueset.SuccessState;

@Service
public class VocService implements VocServiceImpl{
	
	@Autowired VocRepository vocRepository;
	@Autowired PenaltyRepository penaltyRepository;
	
	public SuccessState setVoc(VocDto vocDto) {
		
		VocVo vocVo = VocVo.builder()
					.userKey(vocDto.getUserKey())
					.reason(vocDto.getReason())
					.target(vocDto.getTarget())
					.workerId(vocDto.getWorkerId())
					.vendorId(vocDto.getVendorId())
					.build();
		
		vocRepository.save(vocVo);
		return SuccessState.SUCCESS;
	}
	
	public HashMap<String, Object> getVocList() {
		List<PenaltyVo> vocVos = penaltyRepository.findAll();
		
		return ResponseMap.getResponseMap(SuccessState.SUCCESS, vocVos);
	}
	
	public HashMap<String, Object> getVoc(Long vocId) {
		return null;
	}
	
	public VocDto getVoc() {
		return null;
	}
}
