package com.example.java.was.domain;

import lombok.Data;

@Data
public class ParamSet {
	/**
	 * paging 저리를 위함(이 프로젝트에선 아직 사용하지 않습니다.)
	 * */
	private Long key;
	private int offset;
	private int limit;
	
}
