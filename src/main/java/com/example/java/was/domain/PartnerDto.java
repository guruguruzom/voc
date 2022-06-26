package com.example.java.was.domain;

import java.util.List;

import com.example.java.was.entity.CourierVo;
import com.example.java.was.entity.VendorVo;
import com.example.java.was.entity.WorkerVo;

import lombok.Data;

@Data
public class PartnerDto {
	List<VendorVo> vendors;
	List<WorkerVo> workers;
	
	public PartnerDto(List<VendorVo> vendors, List<WorkerVo> workers) {
		this.vendors = vendors;
		this.workers = workers;
	}
}

