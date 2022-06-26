package com.example.java.was.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@DynamicInsert
@EnableJpaAuditing
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="compensation")
public class CompensationVo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private Integer reparations;
	private String comment;
	private Date createAt;
	
	@Builder
	public CompensationVo(Long id,Integer reparations,String comment,Date createAt) {
		this.id = id;
		this.reparations = reparations;
		this.comment = comment;
		this.createAt = createAt;
	}
}
