package com.example.java.was.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java.was.entity.PenaltyVo;

@Repository
public interface PenaltyRepository extends JpaRepository<PenaltyVo, Long>{
	Optional<PenaltyVo> findByVocId(Long vocId);
}
