package com.example.java.was.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
@Entity(name = "courier")
public class CourierVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courierId;
	private String name;
	private String contact;
	private String address;
	private Date createAt;


	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private WorkerVo worker;

	@Builder
	public CourierVo(String name, String contact, String address, Date createAt) {
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.createAt = createAt;
	}
}
