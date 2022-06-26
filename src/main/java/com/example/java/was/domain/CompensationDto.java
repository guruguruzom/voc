package com.example.java.was.domain;

import lombok.Data;

@Data
public class CompensationDto {
	/**
	 * 배상 목록을 전송하기 위한 Dto
	 * id:배상 정보 고유번호
	 * vocId:voc 고유번호
	 * reparations:배상금액
	 * comment:관리자 메시지
	 * */
	private Long id;
	private Long vocId;
	private Integer reparations;
	private String comment;
}
