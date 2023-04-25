package com.mvc.jpa.user;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {
	
	default Users dToEntity(UserDTO dto) {
		Users entity = Users.builder()
				.userCode(dto.getUserCode())
				.userRegion(dto.getUserRegion())
				.userName(dto.getUserName())
				.userNickName(dto.getUserNickName())
				.userId(dto.getUserId())
				.userPw(dto.getUserPw())
				.userEmail(dto.getUserEmail())
				.userPhone(dto.getUserPhone())
				.proName(dto.getProName())
				.proPath(dto.getProPath())
				.build();
		return entity;
				
	}
	default UserDTO EntityToD(Users entity) {
		UserDTO dto = UserDTO.builder()
				.userCode(entity.getUserCode())
				.userRegion(entity.getUserRegion())
				.userName(entity.getUserName())
				.userNickName(entity.getUserNickName())
				.userId(entity.getUserId())
				.userPw(entity.getUserPw())
				.userEmail(entity.getUserEmail())
				.userPhone(entity.getUserPhone())
				.proName(entity.getProName())
				.proPath(entity.getProPath())
				.build();
		return dto;
	}
	void createUser(Users user);
	void deleteByUserCode(long userCode);
	UserDTO read(long userCode);
	void updateUser(Users user);
	void updateReg(long userCode, String userRegion);
	Users findByUserEmail(String userEmail);
	List<Users> UserAll();
	void addImg(long userCode, MultipartFile file) throws IllegalStateException, IOException;
	void updateAnother(long userCode, String usernickName, String userPw, String userEmail, String userPhone);
}
