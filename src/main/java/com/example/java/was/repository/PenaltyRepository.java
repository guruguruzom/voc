package com.example.java.was.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.java.was.entity.CompensationVo;
import com.example.java.was.entity.PenaltyVo;

public interface PenaltyRepository extends JpaRepository<PenaltyVo, Long>{
	Optional<PenaltyVo> findByVocId(Long vocId);
}
