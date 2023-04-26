package com.mvc.jsp.work;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkDto {
	private Long listCode; // 게시물코드
	private String listTitle; // 제목
	private String listCategory; // 카테고리
	private String listContent; // 내용
	private int listAmount; // 금액
	private int listCnt; // 조회수
	private String listState; // 상태
	private String listRegion; // 지역
	private int listStartTime; // 시작시간
	private int listEndTime; // 끝시간
	private Timestamp listDate;
	private String listFinishDate;
	private Integer userCode; //유저코드
	private Integer userCode2; //연결된 유저코드
}
