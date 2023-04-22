package com.ktj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ktj.entity.Users;

public interface UserRepository extends CrudRepository<Users, Integer> {
	
	// 로그인 아이디,비밀번호 확인
	@Query(value = "SELECT * FROM USERS WHERE USER_ID = ?1 AND USER_PW = ?2 LIMIT 1", nativeQuery = true)
	Users findByUserIdAndUserPw(String userId, String userPw);
	
	Users findByUserEmail(String userEmail); // 이메일을 통한 비밀번호찾기 메서드 구현
	/*
	 * List<Customer> findByName(String name); List<Customer> findByNameLike(String
	 * name); List<Customer> findByNameLikeOrderByAddressDesc(String name);
	 * List<Customer> findByNameOrAddress(String name, String address);
	 * 
	 * 
	 * @Query("from Customer where name = ?1 and address = ?2") List<Customer>
	 * findVipList(String value1, String value2);
	 * 
	 * @Query(value="select * from Customer where name = ?1 and address = ?2"
	 * ,nativeQuery=true) List<Customer> findVipList2(String value1, String value2);
	 */
}
