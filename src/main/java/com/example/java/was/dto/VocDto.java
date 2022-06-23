package com.example.java.was.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VocDto {
	
	private String userKey;
	private String reason;
	private String target;
	private Integer workerId;
	private Integer vendorId;
}
