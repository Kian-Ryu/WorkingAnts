package com.mvc.jsp.work;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WorkRepository extends JpaRepository<Work, Long>, QuerydslPredicateExecutor<Work> {

}
