package com.mvc.grade;

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
public class Grade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long gradeCode;
	
	@Column(nullable = false)
	private Long listCode;
	
	@Column(nullable = true)
	private int userCode;
	
	@Column(nullable = true)
	private Double grade;
}
