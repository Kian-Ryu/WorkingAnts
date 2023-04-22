package com.ktj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.ktj.entity.Users;
import com.ktj.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository; // User CRUD용 레포지터리

	public void createUser(Users user) {
		userRepository.save(user);
	} // 유저생성

	public void findByUserIdAndUserPw(String userId, String userPw) {
		userRepository.findByUserIdAndUserPw(userId, userPw);
	} // 로그인시 회원등록여부 파악

	public List<Users> UserAll() {
		return (List<Users>) userRepository.findAll(); // admin 관리자 페이지에서 회원정보 전체조회
	}

	public void deleteByUserCode(int userCode) {
		userRepository.deleteById(userCode); // admin 관리자 페이지에서 회원정보 삭제
	}

	@Transactional // admin 관리자 페이지에서 모달창 통해서 회원정보 수정
	public void updateUser(Users user) {
		Users existingUser = userRepository.findById(user.getUserCode()).orElse(null);
		if (existingUser != null) {
			existingUser.setUserRegion(user.getUserRegion());
			existingUser.setUserName(user.getUserName());
			existingUser.setUserNickName(user.getUserNickName());
			existingUser.setUserId(user.getUserId());
			existingUser.setUserPw(user.getUserPw());
			existingUser.setUserEmail(user.getUserEmail());
			existingUser.setUserPhone(user.getUserPhone());
			userRepository.save(existingUser);
		}
	}
	
	

}
