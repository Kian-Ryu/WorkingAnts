package com.mvc.jpa.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

	private Long userCode;
	
	private String userRegion;
	
	private String userName;
	
	private String userNickname;
	
	private String userId;
	
	private String userPw;
	
	private String userEmail;
	
	private String userPhone;
	
	private String userProfile;
	
	public User toEntity() {
		User build = User.builder().userCode(userCode).userRegion(userRegion).userName(userName).userNickname(userNickname).userId(userId).userPw(userPw).userEmail(userEmail).userPhone(userPhone).userProfile(userProfile).build();
		
		return build;
	}
	
}
