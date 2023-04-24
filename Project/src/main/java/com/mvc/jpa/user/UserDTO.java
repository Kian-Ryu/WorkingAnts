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
	
	private String userNickName;
	
	private String userId;
	
	private String userPw;
	
	private String userEmail;
	
	private String userPhone;
	
	private String proName;
	
	private String proPath;
	
	
}
