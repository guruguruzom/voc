package com.example.java.was.service;

import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.was.domain.CompensationDto;
import com.example.java.was.entity.CompensationVo;
import com.example.java.was.repository.CompensationRepository;
import com.example.java.was.service.impl.CompensationServiceImpl;
import com.example.java.was.util.DataTimeUtil;
import com.example.java.was.util.ResponseMap;
import com.example.java.was.valueset.ResponseCode;

@Service
public class CompensationService implements CompensationServiceImpl{
	
	private static Logger logger = LoggerFactory.getLogger(CompensationService.class);
	
	@Autowired CompensationRepository compensationRepository; 
	
	public HashMap<String, Object> setCompensation(Long vocId, CompensationDto compensationDto) {
		
    	CompensationVo compensationVo = CompensationVo.builder()
							.id(vocId)
							.reparations(compensationDto.getReparations())
							.comment(compensationDto.getComment())
							.createAt(DataTimeUtil.getTime(LocalDateTime.now()))
							.build();
		
		compensationRepository.save(compensationVo);
		
		return ResponseMap.getResponseMap(ResponseCode.SUCCESS);
        
	}	
	
	public HashMap<String, Object> getCompensationList() throws Exception{
		
		List<CompensationVo> CompensationVos = compensationRepository.findAll(); 
		
		return ResponseMap.getResponseMap(ResponseCode.SUCCESS, CompensationVos);
	}
}
