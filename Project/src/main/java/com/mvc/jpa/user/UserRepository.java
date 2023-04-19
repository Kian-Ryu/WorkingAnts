package com.mvc.jpa.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<Users, Long>, QuerydslPredicateExecutor<Users> {

	Optional<Users> findByUserCode(long l);

}
