package com.example.java.was.service;

import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.was.controller.PenaltyController;
import com.example.java.was.domain.PenaltyDto;
import com.example.java.was.entity.PenaltyVo;
import com.example.java.was.repository.PenaltyRepository;
import com.example.java.was.service.impl.PenaltyServiceImpl;
import com.example.java.was.util.LogManager;
import com.example.java.was.util.ResponseMap;
import com.example.java.was.valueset.PenaltyState;
import com.example.java.was.valueset.ResponseCode;
import com.example.java.was.valueset.TargetCode;

@Service
public class PenaltyService implements PenaltyServiceImpl{
	
	private static Logger logger = LoggerFactory.getLogger(PenaltyService.class);
	
	@Autowired PenaltyRepository penaltyRepository;
	
	public HashMap<String, Object> setPenalty(Long vocId, PenaltyDto penaltyDto) throws Exception {

		penaltyRepository.findByVocId(vocId);
		if(!penaltyRepository.findByVocId(vocId).isEmpty()) { // �� ���翩�� Ȯ��
            return ResponseMap.getResponseMap(ResponseCode.FAILED_EXISTS);
        } else {
        	//FCM 가상
        	//TargetCode.COURIER ��ۻ� å��
        	//TargetCode.VENDOR ���� å��
        	if(TargetCode.getEnumFromString(penaltyDto.getTarget()) == TargetCode.COURIER) {
        		penaltyDto.getTarget();
        		
        		logger.info(LogManager.getLogMessage("push target : ", 
        					new String[] {penaltyDto.getTarget(),penaltyDto.getTargetId().toString()}));
        	} else {
        		penaltyDto.getTarget();
        		
        		logger.info(LogManager.getLogMessage("push target : ", 
    					new String[] {penaltyDto.getTarget(),penaltyDto.getTargetId().toString()}));
        	}
        	
        	
        	PenaltyVo penaltyVo = PenaltyVo.builder()
    				.vocId(vocId)
    				.state(PenaltyState.NONE.getCode())
    				.build();

        	penaltyRepository.save(penaltyVo);
            
    		return ResponseMap.getResponseMap(ResponseCode.SUCCESS);
        }
	}
	
	public HashMap<String, Object> setState(Long vocId, String stateCode) throws Exception{
		
		if(penaltyRepository.findById(vocId).isEmpty()) { // �� ���翩�� Ȯ��
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
