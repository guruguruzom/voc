package com.example.java.was.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.java.was.dto.PenaltyDto;
import com.example.java.was.entity.PenaltyVo;
import com.example.java.was.repository.PenaltyRepository;
import com.example.java.was.service.impl.PenaltyServiceImpl;
import com.example.java.was.valueset.PenaltyState;

public class PenaltyService implements PenaltyServiceImpl{
	
	@Autowired PenaltyRepository penaltyRepository;
	
	public void setPenalty(PenaltyDto penaltyDto) {

		PenaltyVo penaltyVo = PenaltyVo.builder()
							.workerId(penaltyDto.getWorkerId())
							.state(PenaltyState.NONE.getCode())
							.build();
		
		penaltyRepository.save(penaltyVo);
	}
}
