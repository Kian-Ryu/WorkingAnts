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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userCode;
	
	@Column(length = 20, nullable = false)
	private String userRegion;
	
	@Column(length = 20, nullable = false)
	private String userName;
	
	@Column(length = 20, nullable = false)
	private String userNickName;
	
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
	
	public void changeUserRegion(String userRegion) {
		this.userRegion = userRegion;
	}
	public void changeUserAnother(String userNickName, String userPw, String userEmail, String userPhone) {
		this.userNickName = userNickName;
		this.userPw = userPw;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	}
	public void addImg(String proName, String proPath) {
		this.proName = proName;
		this.proPath = proPath;
	}
}
