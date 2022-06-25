package com.example.java.was.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.was.domain.CompensationDto;
import com.example.java.was.entity.CompensationVo;
import com.example.java.was.repository.CompensationRepository;
import com.example.java.was.service.impl.CompensationServiceImpl;
import com.example.java.was.util.ResponseMap;
import com.example.java.was.valueset.ResponseCode;

@Service
public class CompensationService implements CompensationServiceImpl{
	
	@Autowired CompensationRepository compensationRepository; 
	
	public HashMap<String, Object> setCompensation(CompensationDto compensationDto) {
		
		if(compensationRepository.findByVocIdAndPenaltyId(compensationDto.getVocId(),compensationDto.getPenaltyId()).isEmpty()) { // 값 존재여부 확인
            return ResponseMap.getResponseMap(ResponseCode.FAILED_EXISTS);
        } else {
        	CompensationVo compensationVo = CompensationVo.builder()
								.vocId(compensationDto.getVocId())
								.penaltyId(compensationDto.getPenaltyId())
								.reparations(compensationDto.getReparations())
								.comment(compensationDto.getComment())
								.build();
			
			compensationRepository.save(compensationVo);
			
			return ResponseMap.getResponseMap(ResponseCode.SUCCESS);
        }
		
		
	}		
}
