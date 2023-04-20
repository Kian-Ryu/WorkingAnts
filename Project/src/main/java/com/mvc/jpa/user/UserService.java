package com.mvc.jpa.user;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {
	Long register(UserDTO dto, MultipartFile file);
	
	default Users dToEntity(UserDTO dto) {
		Users entity = Users.builder()
				.userCode(dto.getUserCode())
				.userRegion(dto.getUserRegion())
				.userName(dto.getUserName())
				.userNickname(dto.getUserNickname())
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
				.userNickname(entity.getUserNickname())
				.userId(entity.getUserId())
				.userPw(entity.getUserPw())
				.userEmail(entity.getUserEmail())
				.userPhone(entity.getUserPhone())
				.proName(entity.getProName())
				.proPath(entity.getProPath())
				.build();
		return dto;
	}

	UserDTO read(long userCode);

	void updateReg(long userCode, String userRegion);
	
}
