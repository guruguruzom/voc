package com.example.java.was.dto;

import lombok.Data;

@Data
public class CompensationDto {
	private Long id;
	private Long vocId;
	private Long penaltyId;
	private Integer reparations;
	private String comment;
}
