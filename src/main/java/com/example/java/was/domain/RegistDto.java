package com.example.java.was.domain;

import lombok.Data;

@Data
public class RegistDto {
	private String reason;
	private String target;
	private Long workerId;
	private Long vendorId;
}
