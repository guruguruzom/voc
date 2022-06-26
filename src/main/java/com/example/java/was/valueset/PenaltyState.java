package com.example.java.was.valueset;

public enum PenaltyState {
	/*
	 * none:확인안함
	 * confirm:확인
	 * objection:이의제기
	 * admit:인정
	 * */
	NONE("none"),
	CONFIRM("confirm"),
	OBJECTION("objection"),
	ADMIT("admit");
	
	String code;
	
	
	public String getCode() {
		return code;
	}
	
	PenaltyState(String code){
		this.code = code;
	}
	
	public static PenaltyState getEnumFromString(String code) throws Exception {
		for(PenaltyState ps : PenaltyState.values()) {
			if(ps.getCode() == code) {
				return ps;
			}
		}
		
		throw new Exception("Invalid PenaltyStateCode");
	}
}
