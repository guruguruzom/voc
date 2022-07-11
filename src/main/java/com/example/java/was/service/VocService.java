package com.example.java.was.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.was.domain.PartnerDto;
import com.example.java.was.domain.VocDto;
import com.example.java.was.domain.VocInfoDto;
import com.example.java.was.entity.CourierVo;
import com.example.java.was.entity.VendorVo;
import com.example.java.was.entity.VocVo;
import com.example.java.was.entity.WorkerVo;
import com.example.java.was.repository.CourierRepository;
import com.example.java.was.repository.VendorRepository;
import com.example.java.was.repository.VocRepository;
import com.example.java.was.repository.WorkerRepository;
import com.example.java.was.service.impl.VocServiceImpl;
import com.example.java.was.util.ResponseMap;
import com.example.java.was.valueset.ResponseCode;

@Service
public class VocService implements VocServiceImpl{
	
	private static Logger logger = LoggerFactory.getLogger(VocService.class);
	
	@Autowired VocRepository vocRepository;
	@Autowired CourierRepository courierRepository; 
	@Autowired VendorRepository vendorRepository;
	@Autowired WorkerRepository workerRepository;
	
	public HashMap<String, Object> getRegistInfo()  throws Exception {
		
		List<VendorVo> vendors = vendorRepository.findAll();
		List<WorkerVo> workers = workerRepository.findAll();
		PartnerDto registDto = new PartnerDto(vendors,workers);
		
		return ResponseMap.getResponseMap(ResponseCode.SUCCESS, registDto);
	}
	
	
	public HashMap<String, Object> setVoc(VocDto vocDto)  throws Exception {
		
		VocVo vocVo = VocVo.builder()
					.reason(vocDto.getReason())
					.target(vocDto.getTarget())
					.workerId(vocDto.getWorkerId())
					.vendorId(vocDto.getVendorId())
					.build();
		
		vocRepository.save(vocVo);
		return ResponseMap.getResponseMap(ResponseCode.SUCCESS);
	}
	
	
	public HashMap<String, Object> getVocList()  throws Exception {
		
		List<VocVo> vocVos = vocRepository.findAll();
		
		return ResponseMap.getResponseMap(ResponseCode.SUCCESS, vocVos);
	}
	
	
	public HashMap<String, Object> getVoc(Long vocId)  throws Exception {
		
		Optional<VocVo> vocVo = vocRepository.findById(vocId);
		
		/*vocId입력 오류 처리*/
		if(vocVo.isEmpty()) {
			return  ResponseMap.getResponseMap(ResponseCode.FAILED_NOT_FOUND);
		} 
		
		/*join 문사용하지않고 여러번 접근(jpa 사용 미숙으로 인한 처리)
		 *충돌 발생 시 문제점이 없어보여 트랜젝션을 사용하지 않았습니다.
		 * */
		Optional<VendorVo> vendorVo = vendorRepository.findById(vocVo.get().getVendorId());
		List<CourierVo> courierVo = courierRepository.findByIdworker(vocVo.get().getWorkerId());
		
		
		VocInfoDto vocDto = new VocInfoDto(vocVo.get(), vendorVo.get(), courierVo.get(0));
		
		
		return ResponseMap.getResponseMap(ResponseCode.SUCCESS, vocDto);
	}
	
	
	public HashMap<String, Object> setState(Long vocId, String stateCode) throws Exception {
		/*vocId입력 오류 처리*/
		
		if(vocRepository.findById(vocId).isEmpty()) {
            return ResponseMap.getResponseMap(ResponseCode.FAILED_NOT_FOUND);
        } else {
        	VocVo vocVo = VocVo.builder()
								.id(vocId)
								.state(stateCode)
								.build();
			
        	vocRepository.save(vocVo);
			
			return ResponseMap.getResponseMap(ResponseCode.SUCCESS);
        }
	}
}
