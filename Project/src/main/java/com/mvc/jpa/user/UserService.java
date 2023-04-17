package com.mvc.jpa.user;

public interface UserService {
	Long register(UserDTO dto);
	
	default User dToEntity(UserDTO dto) {
		User entity = User.builder()
				.userCode(dto.getUserCode())
				.userRegion(dto.getUserRegion())
				.userName(dto.getUserName())
				.userNickname(dto.getUserNickname())
				.userId(dto.getUserId())
				.userPw(dto.getUserPw())
				.userEmail(dto.getUserEmail())
				.userPhone(dto.getUserPhone())
				.userProfile(dto.getUserProfile())
				.build();
		return entity;
				
	}
	default UserDTO EntityToDTO(User entity) {
		UserDTO dto = UserDTO.builder()
				.userCode(entity.getUserCode())
				.userRegion(entity.getUserRegion())
				.userName(entity.getUserName())
				.userNickname(entity.getUserNickname())
				.userId(entity.getUserId())
				.userPw(entity.getUserPw())
				.userEmail(entity.getUserEmail())
				.userPhone(entity.getUserPhone())
				.userProfile(entity.getUserProfile())
				.build();
		return dto;
	}
	
}
