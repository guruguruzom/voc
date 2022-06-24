package com.example.java.was.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.java.was.dto.CompensationDto;
import com.example.java.was.entity.CompensationVo;
import com.example.java.was.repository.CompensationRepository;
import com.example.java.was.service.impl.CompensationServiceImpl;

public class CompensationService implements CompensationServiceImpl{
	
	@Autowired CompensationRepository compensationRepository; 
	
	public void setCompensation(CompensationDto compensationDto) {
		CompensationVo compensationVo = CompensationVo.builder()
										.vocId(compensationDto.getId())
										.penaltyId(compensationDto.getPenaltyId())
										.reparations(compensationDto.getReparations())
										.comment(compensationDto.getComment())
										.build();
		
		compensationRepository.save(compensationVo);
		
	}		
}
