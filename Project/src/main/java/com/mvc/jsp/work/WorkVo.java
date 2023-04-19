package com.mvc.jsp.work;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkVo {
 private Integer listCode; //게시물코드
 private String listTitle; //제목
 private String listCategory; //카테고리
 private String listContent; //내용
 private Integer listAmount; //금액
 private Integer listCnt; //조회수
 private String listState="모집중"; //상태
 private String listRegion; //지역
 private Integer listStartTime; //시작시간
 private Integer listEndTime; //끝시간
 
 private Date listDate;
 private Date listFinishDate;


 
}
