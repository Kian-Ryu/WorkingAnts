package com.mvc.jpa.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>, QuerydslPredicateExecutor<Users> {

	Optional<Users> findByUserCode(int l);
	@Query(value = "SELECT * FROM USERS WHERE USER_ID = ?1 AND USER_PW = ?2 LIMIT 1", nativeQuery = true)
	Users findByUserIdAndUserPw(String userId, String userPw);
	Users findByUserEmail(String userEmail);
	
	@Query("SELECT userNickName FROM Users WHERE userCode = :userCode")
	String findByuserCode(@Param("userCode") int userCode);
}
