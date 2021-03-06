package com.example.java.was.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.java.was.entity.CourierVo;
import com.example.java.was.entity.VocVo;

@Repository
public interface VocRepository extends JpaRepository<VocVo, Long>{
}
