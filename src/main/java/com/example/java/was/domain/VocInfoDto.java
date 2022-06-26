package com.example.java.was.domain;

import java.util.Date;

import com.example.java.was.entity.CompensationVo;
import com.example.java.was.entity.CourierVo;
import com.example.java.was.entity.VendorVo;
import com.example.java.was.entity.VocVo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VocInfoDto extends VocDto{
	/**
	 * voc DB조회를 위한 Dto (배송정보, 고객사, 배송사 정보는 vo를 참조합니다.)
	 * id:voc고유번호
	 * userKey:유저 고유키(이 프로젝트에선 아직 사용하지 않습니다)
	 * state:배상 대상 확인 여부 및 이의 제기 상태(PenaltyState enum)
	 * createAt:생성일
	 * compensation:배상 정보
	 * vendor:고객사 정보
	 * courier:배송사 정보
	 * */
	
	private Long id;
	private String userKey;
	private String state;
	private Date createAt;
	private CompensationVo compensation;
	private VendorVo vendor;
	private CourierVo courier;
	
	public VocInfoDto(VocVo vocVo, VendorVo vendorVo, CourierVo courierVo) {
		this.id = vocVo.getId();
		this.reason = vocVo.getReason();
		this.target = vocVo.getTarget();
		this.state = vocVo.getState();
		this.createAt = vocVo.getCreateAt();
		this.compensation = vocVo.getCompensation();
		this.vendor = vendorVo;
		this.courier = courierVo;
	}
	
	
}
