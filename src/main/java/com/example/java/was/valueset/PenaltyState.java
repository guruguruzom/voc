package com.example.java.was.valueset;

public enum PenaltyState {
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
