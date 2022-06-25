package com.example.java.was.domain;

import lombok.Data;

@Data
public class PenaltyDto {
	private Long vocId;
	private Long targetId;
	private String target;
	private String state;
}
