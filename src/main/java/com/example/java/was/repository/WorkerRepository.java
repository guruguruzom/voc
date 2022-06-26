package com.example.java.was.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java.was.entity.WorkerVo;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerVo, Long>{

}
