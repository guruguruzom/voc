package com.example.java.was.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.was.domain.CompensationDto;
import com.example.java.was.entity.CompensationVo;
import com.example.java.was.repository.CompensationRepository;
import com.example.java.was.service.impl.CompensationServiceImpl;
import com.example.java.was.valueset.SuccessState;

@Service
public class CompensationService implements CompensationServiceImpl{
	
	@Autowired CompensationRepository compensationRepository; 
	
	public SuccessState setCompensation(CompensationDto compensationDto) {
		
		if(compensationRepository.findByVocIdAndPenaltyId(compensationDto.getVocId(),compensationDto.getPenaltyId()).isEmpty()) { // 값 존재여부 확인
            return SuccessState.FAILED_EXISTS;
        } else {
        	CompensationVo compensationVo = CompensationVo.builder()
								.vocId(compensationDto.getVocId())
								.penaltyId(compensationDto.getPenaltyId())
								.reparations(compensationDto.getReparations())
								.comment(compensationDto.getComment())
								.build();
			
			compensationRepository.save(compensationVo);
			
			return SuccessState.SUCCESS;
        }
		
		
	}		
}
