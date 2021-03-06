package com.example.java.was.entity;

import lombok.*;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Data
@DynamicInsert
///@AllArgsConstructor
@EnableJpaAuditing
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="voc")
public class VocVo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private String userKey;
	private String reason;
	private String target;
	private Long workerId;
	private Long vendorId;
	private String state;
	private Date createAt;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private CompensationVo compensation;
	
	@Builder
	public VocVo(Long id,String state) {
		this.id = id;
		this.state = state;
	}
	
	
	@Builder
	public VocVo(Long id,String userKey,String reason,String target,Long workerId,Long vendorId,String state,Date createAt,CompensationVo compensation) {
		this.id = id;
		this.userKey = userKey;
		this.reason = reason;
		this.target = target;
		this.workerId = workerId;
		this.vendorId = vendorId;
		this.state = state;
		this.createAt = createAt;
		this.compensation = compensation;
	}
}
