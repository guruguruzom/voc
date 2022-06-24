package com.example.java.was.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@DynamicInsert
@AllArgsConstructor
@EnableJpaAuditing
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="penalty")
public class PenaltyVo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long vocId;
	private Long workerId;
	private String state;
	private Date createAt;
	
	@Builder
	public PenaltyVo(Long vocId,Long workerId,String state) {
		this.vocId = vocId;
		this.workerId = workerId;
		this.state = state;
	}
}
