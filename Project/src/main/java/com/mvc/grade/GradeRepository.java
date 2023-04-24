package com.mvc.grade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long>, QuerydslPredicateExecutor<Grade> {
	
	
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("grade");
//	
//	final EntityManager em = emf.createEntityManager();
	
	List<Grade> findByUserCode(Long userCode);
	
//	@Query(value = "select avg(g.grade) from Grade g where g.userCode = ")
//	public long avgGrade(long userCode);
	
//	default Grade avgGrade() {
//
//		return em.createQuery("select avg(g.grade) from Grade g where g.userCode = :userCode",Grade.class).setParameter("","").getSingleResult();
//		
//	}
//	
	
	
}
