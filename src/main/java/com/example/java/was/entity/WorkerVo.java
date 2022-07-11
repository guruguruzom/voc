package com.example.java.was.entity;

import java.sql.Date;

import javax.persistence.Column;
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
@Entity(name="worker")
public class WorkerVo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long workerId;
	private String name;
	private String contact;
	@Column (name = "courier_id")
	private Long courierId;
	private Date createAt;
	
	@Builder
	public WorkerVo(String name, String contact, Long courierId, Date createAt) {
		this.name = name;
		this.contact = contact;
		this.createAt = createAt;
		this.courierId = courierId;
	}
}
