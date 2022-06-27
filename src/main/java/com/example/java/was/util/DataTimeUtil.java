package com.example.java.was.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DataTimeUtil { 
	public static Timestamp getTime(LocalDateTime ldt) {
		return Timestamp.valueOf(ldt);
	}
}
