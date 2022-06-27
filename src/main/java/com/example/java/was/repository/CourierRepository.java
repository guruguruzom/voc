package com.example.java.was.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.java.was.entity.CourierVo;

@Repository
public interface CourierRepository extends JpaRepository<CourierVo, Long>{
	@Query(value="SELECT c FROM courier c "
			+ "INNER JOIN FETCH c.worker w "
			+ "WHERE w.id=:workerId")
	Optional<CourierVo> findByIdworker(@Param("workerId") Long workerId);
}
