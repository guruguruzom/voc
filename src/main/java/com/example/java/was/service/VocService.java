package com.example.java.was.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.was.domain.ParamSet;
import com.example.java.was.domain.VocDto;
import com.example.java.was.entity.CourierVo;
import com.example.java.was.entity.PenaltyVo;
import com.example.java.was.entity.VendorVo;
import com.example.java.was.entity.VocVo;
import com.example.java.was.entity.WorkerVo;
import com.example.java.was.repository.CourierRepository;
import com.example.java.was.repository.PenaltyRepository;
import com.example.java.was.repository.VendorRepository;
import com.example.java.was.repository.VocRepository;
import com.example.java.was.service.impl.VocServiceImpl;
import com.example.java.was.util.ResponseMap;
import com.example.java.was.valueset.ResponseCode;
import com.example.java.was.valueset.TargetCode;

@Service
public class VocService implements VocServiceImpl{
	
	@Autowired VocRepository vocRepository;
	@Autowired PenaltyRepository penaltyRepository;
	@Autowired CourierRepository courierRepository; 
	@Autowired VendorRepository vendorRepository;
	
	public HashMap<String, Object> setVoc(VocDto vocDto) {
		
		VocVo vocVo = VocVo.builder()
					.userKey(vocDto.getUserKey())
					.reason(vocDto.getReason())
					.target(vocDto.getTarget())
					.workerId(vocDto.getWorkerId())
					.vendorId(vocDto.getVendorId())
					.build();
		
		vocRepository.save(vocVo);
		return ResponseMap.getResponseMap(ResponseCode.SUCCESS);
	}
	
	public HashMap<String, Object> getVocList() {
		List<VocVo> vocVos = vocRepository.findAll();
		
		return ResponseMap.getResponseMap(ResponseCode.SUCCESS, vocVos);
	}
	
	public HashMap<String, Object> getVoc(Long vocId) throws Exception {
		Optional<VocVo> vocVo = vocRepository.findById(vocId);
		
		if(vocVo.isEmpty()) {
			return  ResponseMap.getResponseMap(ResponseCode.FAILED_NOT_FOUND);
		} 
		
		TargetCode targetCode = TargetCode.getEnumFromString(vocVo.get().getTarget());
		/* COURIER:택배사 과실, VENDOR:고객사 과실 */
		if(targetCode == TargetCode.COURIER) {
			Optional<CourierVo> courierVo = courierRepository.findByIdworker(vocVo.get().getWorkerId());
			return ResponseMap.getResponseMap(ResponseCode.SUCCESS, courierVo);
		} else {
			Optional<VendorVo> vendorVo = vendorRepository.findById(vocVo.get().getVendorId());
			return ResponseMap.getResponseMap(ResponseCode.SUCCESS, vendorVo);
		}
	}
	
	public VocDto getVoc() {
		return null;
	}
}
