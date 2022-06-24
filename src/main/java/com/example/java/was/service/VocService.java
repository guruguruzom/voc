package com.example.java.was.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.was.dto.VocDto;
import com.example.java.was.entity.VocVo;
import com.example.java.was.repository.VocRepository;
import com.example.java.was.service.impl.VocServiceImpl;

@Service
public class VocService implements VocServiceImpl{
	
	@Autowired VocRepository vocRepository;
	
	public void setVoc(VocDto vocDto) {

		VocVo vocVo = VocVo.builder()
					.userKey(vocDto.getUserKey())
					.reason(vocDto.getReason())
					.target(vocDto.getTarget())
					.workerId(vocDto.getWorkerId())
					.vendorId(vocDto.getVendorId())
					.build();
		
		vocRepository.save(vocVo);
	}
	
	public VocDto getVoc() {
		return null;
	}
}
