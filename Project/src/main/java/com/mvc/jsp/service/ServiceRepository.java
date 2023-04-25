package com.mvc.jsp.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ServiceRepository extends JpaRepository<Service, Long>, QuerydslPredicateExecutor<Service> {

}
