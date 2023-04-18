package com.mvc.jpa.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userCode;
	
	@Column(length = 20, nullable = false)
	private String userRegion;
	
	@Column(length = 20, nullable = false)
	private String userName;
	
	@Column(length = 20, nullable = false)
	private String userNickname;
	
	@Column(length = 25, nullable = false)
	private String userId;
	
	@Column(length = 20, nullable = false)
	private String userPw;
	
	@Column(length = 30, nullable = false)
	private String userEmail;
	
	@Column(length = 30, nullable = false)
	private String userPhone;
	
	@Column(nullable = true)
	private String proName;
	
	@Column(nullable = true)
	private String proPath;
	
}
