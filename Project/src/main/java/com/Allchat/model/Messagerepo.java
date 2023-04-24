package com.Allchat.model;

import javax.persistence.*;

@Entity
public class Messagerepo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String message;
	@Column(name = "USERID")
	private String userId;

	public Messagerepo() {
	}

	public Messagerepo(String message, String userId) {
		this.message = message;
		this.userId = userId;
	}

	// 기본 객체, 객체 생성 + 엔티티 테이블 생성 및 컬럼 설정

}
