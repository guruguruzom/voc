package com.example.java.was.domain;

import java.util.List;

import com.example.java.was.entity.VendorVo;
import com.example.java.was.entity.WorkerVo;

import lombok.Data;

@Data
public class PartnerDto {
	/**
	 * voc 등록 시 배송기사 및 고객사를 등록하기 위한 Dto
	 * vendors : 고객사 전체 목록
	 * workers : 배송기사 전체 목록
	 */
	List<VendorVo> vendors;
	List<WorkerVo> workers;
	
	public PartnerDto(List<VendorVo> vendors, List<WorkerVo> workers) {
		this.vendors = vendors;
		this.workers = workers;
	}
}

