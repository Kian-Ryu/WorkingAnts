package com.mvc.jsp.service;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@ToString
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long inqCode; // 문의코드

	@Column(length = 20, nullable = false)
	private String inqTitle; // 제목
	
	@Lob
	@Column
	private String inqContent; // 내용

	@Column
	private String inqEmail; // 문의이메일	
}
