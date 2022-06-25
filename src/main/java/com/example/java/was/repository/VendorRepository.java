package com.example.java.was.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java.was.entity.VendorVo;

@Repository
public interface VendorRepository extends JpaRepository<VendorVo, Long>{

}
