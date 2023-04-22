package com.ktj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userCode;

	@Column(length = 50, nullable = false)
	private String userRegion;
	
	@Column(length = 50, nullable = false)
	private String userName;
	
	@Column(length = 50, nullable = false)
	private String userNickName;
	
	@Column(length = 50, nullable = false)
	private String userId;
	
	@Column(length = 50, nullable = false)
	private String userPw;
	
	@Column(length = 50, nullable = false)
	private String userEmail;
	
	@Column(length = 50, nullable = false)
	private String userPhone;
	
}
