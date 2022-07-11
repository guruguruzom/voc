package com.example.java.was.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.java.was.entity.CourierVo;

@Repository
public class CourierRepository /* extends JpaRepository<CourierVo, Long> */ {
//	@Query(value="SELECT c FROM courier c "
//			+ "INNER JOIN FETCH c.worker w "
//			+ "WHERE w.id=:workerId")
//	Optional<CourierVo> findByIdworker(@Param("workerId") Long workerId);

//	@PersistenceContext    // EntityManagerFactory가 DI 할 수 있도록 어노테이션 설정
//    private EntityManager em;
//
//    public List<CourierVo> findByIdworker(Long workerId){
//        String jpql = "SELECT c FROM courier c "
//        		+ "INNER JOIN FETCH c.worker w "
//        		+ "WHERE w.id=:workerId";
//        TypedQuery<CourierVo> query = em.createQuery(jpql, CourierVo.class);
//        query.setParameter("workerId", workerId);
//        return query.getResultList();
//    }

	@PersistenceContext // EntityManagerFactory가 DI 할 수 있도록 어노테이션 설정
	private EntityManager em;

	public List<CourierVo> findByIdworker(Long workerId) {
		String jpql = "SELECT c FROM courier c " + "INNER JOIN FETCH c.worker w " + "WHERE w.id=:workerId";
		TypedQuery<CourierVo> query = em.createQuery(jpql, CourierVo.class);
		query.setParameter("workerId", workerId);
		return query.getResultList();
	}
}
