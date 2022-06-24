package com.example.java.was.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PenaltyDto {
	
	private Long id;
	private Long vocId;
	private Long workerId;
	private String state;
}
