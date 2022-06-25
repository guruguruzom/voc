package com.example.java.was.service;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.was.domain.PenaltyDto;
import com.example.java.was.entity.PenaltyVo;
import com.example.java.was.repository.PenaltyRepository;
import com.example.java.was.service.impl.PenaltyServiceImpl;
import com.example.java.was.util.ResponseMap;
import com.example.java.was.valueset.PenaltyState;
import com.example.java.was.valueset.ResponseCode;

@Service
public class PenaltyService implements PenaltyServiceImpl{
	
	@Autowired PenaltyRepository penaltyRepository;
	
	public HashMap<String, Object> setPenalty(Long vocId) {

		if(!penaltyRepository.findByVocId(vocId).isEmpty()) { // 값 존재여부 확인
            return ResponseMap.getResponseMap(ResponseCode.FAILED_EXISTS);
        } else {
        	PenaltyVo penaltyVo = PenaltyVo.builder()
    				.vocId(vocId)
    				.state(PenaltyState.NONE.getCode())
    				.build();

        	PenaltyVo success = penaltyRepository.save(penaltyVo);
            
    		return ResponseMap.getResponseMap(ResponseCode.SUCCESS);
        }
	}
	
	public HashMap<String, Object> setState(Long vocId, String stateCode) {
		
		if(penaltyRepository.findById(vocId).isEmpty()) { // 값 존재여부 확인
            return ResponseMap.getResponseMap(ResponseCode.FAILED_NOT_FOUND);
        } else {
        	PenaltyVo penaltyVo = PenaltyVo.builder()
								.vocId(vocId)
								.state(stateCode)
								.build();
			
			penaltyRepository.save(penaltyVo);
			
			return ResponseMap.getResponseMap(ResponseCode.SUCCESS);
        }
		
		
	}
}
