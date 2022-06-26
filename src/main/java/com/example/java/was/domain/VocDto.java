package com.example.java.was.domain;

import lombok.Data;

@Data
public class VocDto {
	/**
	 * voc 등록을 위한 Dto
	 * reason:voc 발생 사유
	 * target:배상 대상 (TargetCode enum)
	 * workerId:배송기사 고유번호
	 * vendorId:고객사 고유번호
	 * */
	protected String reason;
	protected String target;
	protected Long workerId;
	protected Long vendorId;
}
