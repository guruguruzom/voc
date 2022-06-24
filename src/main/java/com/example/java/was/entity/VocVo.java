package com.example.java.was.entity;

import lombok.*;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.java.was.dto.VocDto;

@Data
@DynamicInsert
@AllArgsConstructor
@EnableJpaAuditing
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="voc")
public class VocVo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userKey;
	private String reason;
	private String target;
	private Integer workerId;
	private Integer vendorId;
	private Date createAt;
	

	@Builder
	public VocVo(String userKey,String reason,String target,int workerId,int vendorId,Date createAt) {
		
		this.userKey = userKey;
		this.reason = reason;
		this.target = target;
		this.workerId = workerId;
		this.vendorId = vendorId;
		this.createAt = createAt;
	}
}
