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
@Entity(name="compensation")
public class CompensationVo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long vocId;
	private Long penaltyId;
	private Integer reparations;
	private String comment;
	private Date createAt;
	
	@Builder
	public CompensationVo(Long vocId,Long penaltyId,Integer reparations,String comment,Date createAt) {
		this.vocId = vocId;
		this.penaltyId = penaltyId;
		this.reparations = reparations;
		this.comment = comment;
		this.createAt = createAt;
	}
}
