package com.example.java.was.domain;

import java.util.Date;

import com.example.java.was.entity.CourierVo;
import com.example.java.was.entity.VendorVo;
import com.example.java.was.entity.VocVo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VocDto {
	
	private String userKey;
	private String reason;
	private String target;
	private Long workerId;
	private Long vendorId;
	private Date createAt;
	private VendorVo vendor;
	private CourierVo courier;
	
	public VocDto(VocVo vocVo, VendorVo vendorVo, CourierVo courierVo) {
		this.reason = vocVo.getReason();
		this.target = vocVo.getTarget();
		this.createAt = vocVo.getCreateAt();
		this.vendor = vendorVo;
		this.courier = courierVo;
	}
	
	
}
