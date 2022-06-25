package com.example.java.was.valueset;

public enum TargetCode {
	COURIER("courier"),
	VENDOR("vendor");
	
	String code;
	
	public String getCode() {
		return code;
	}
	
	TargetCode(String code){
		this.code = code;
	}
	
	public static TargetCode getEnumFromString(String code) throws Exception {
		for(TargetCode ps : TargetCode.values()) {
			if(ps.getCode().equals(code)) {
				return ps;
			}
		}
		
		throw new Exception("Invalid PenaltyStateCode");
	}
}
