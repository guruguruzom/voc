package com.example.java.was.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.was.domain.VocDto;
import com.example.java.was.entity.CourierVo;
import com.example.java.was.entity.VendorVo;
import com.example.java.was.entity.VocVo;
import com.example.java.was.repository.CourierRepository;
import com.example.java.was.repository.PenaltyRepository;
import com.example.java.was.repository.VendorRepository;
import com.example.java.was.repository.VocRepository;
import com.example.java.was.service.impl.VocServiceImpl;
import com.example.java.was.util.ResponseMap;
import com.example.java.was.valueset.ResponseCode;

@Service
public class VocService implements VocServiceImpl{
	
	private static Logger logger = LoggerFactory.getLogger(VocService.class);
	
	@Autowired VocRepository vocRepository;
	@Autowired PenaltyRepository penaltyRepository;
	@Autowired CourierRepository courierRepository; 
	@Autowired VendorRepository vendorRepository;
	
	public HashMap<String, Object> setVoc(VocDto vocDto)  throws Exception{
		
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
	
	public HashMap<String, Object> getVocList()  throws Exception{
		List<VocVo> vocVos = vocRepository.findAll();
		
		return ResponseMap.getResponseMap(ResponseCode.SUCCESS, vocVos);
	}
	
	public HashMap<String, Object> getVoc(Long vocId)  throws Exception{
		Optional<VocVo> vocVo = vocRepository.findById(vocId);
		
		if(vocVo.isEmpty()) {
			return  ResponseMap.getResponseMap(ResponseCode.FAILED_NOT_FOUND);
		} 
		
		/*join 문이 아닌 개별 처리*/
		Optional<VendorVo> vendorVo = vendorRepository.findById(vocVo.get().getVendorId());
		Optional<CourierVo> courierVo = courierRepository.findByIdworker(vocVo.get().getWorkerId());
		
		VocDto vocDto = new VocDto(vocVo.get(), vendorVo.get(), courierVo.get());
		
		return ResponseMap.getResponseMap(ResponseCode.SUCCESS, vocDto);
	}
}
