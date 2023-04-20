package com.mvc.grade;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GradeRepository extends JpaRepository<Grade, Long>, QuerydslPredicateExecutor<Grade> {
	
	Optional<Grade> findByUserCode(Long userCode);
	
	@Query(value = "select avg(g.grade) from Grade g where g.userCode = ?")
	public long avgGrade(long userCode);
	
	
}
