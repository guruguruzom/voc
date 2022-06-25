package com.example.java.was.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java.was.entity.CompensationVo;

@Repository
public interface CompensationRepository extends JpaRepository<CompensationVo, Long>{
	Optional<CompensationVo> findByVocIdAndPenaltyId(Long vocId, Long PenaltyId);
}
