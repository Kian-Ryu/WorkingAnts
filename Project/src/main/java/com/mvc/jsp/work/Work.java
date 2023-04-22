package com.mvc.jsp.work;

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
public class Work {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long listCode; // 게시물코드

	@Column(length = 20, nullable = false)
	private String listTitle; // 제목

	@Column(length = 20, nullable = false)
	private String listCategory; // 카테고리

	/*
	 * @ManyToOne(fetch = FetchType.EAGER, targetEntity=Work.class) // 기본전략
	 * 
	 * @JoinColumn(name = "userCode") // 실제디비엔 userCode칼럼명으로 들어감 private Long
	 * usercode;
	 */
	
	@Lob
	@Column
	private String listContent; // 내용

	@Column
	private int listAmount; // 금액

	@Column
	private int listCnt; // 조회수
	
	@Column
	private String listState; // 상태
	@Column
	private String listRegion; // 지역
	@Column
	private int listStartTime; // 시작시간
	@Column
	private int listEndTime; // 끝시간
	@Column
	@CreationTimestamp
	private Timestamp listDate;
	@Column
	private String listFinishDate;

	//조회수
	public void increaselistCnt() {
        this.listCnt++;
    }
	
	//수정
    public void changeTitle(String title){
        this.listTitle = title;
    }
    public void changeCategory(String category){
        this.listCategory = category;
    }
    public void changeAmount(int amount){
        this.listAmount = amount;
    }
    public void changeRegion(String region){
        this.listRegion = region;
    }
    public void changeStartTime(int starttime){
        this.listStartTime = starttime;
    }
    public void changeEndTime(int endtime){
        this.listEndTime = endtime;
    }
    public void changeFinishDate(String finishdate){
        this.listFinishDate = finishdate;
    }
    public void changeContent(String content){
        this.listContent = content;
    }
}
