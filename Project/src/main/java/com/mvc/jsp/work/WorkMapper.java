/*
 * package com.mvc.jsp.work;
 * 
 * import org.apache.ibatis.annotations.Insert; import
 * org.apache.ibatis.annotations.Mapper; import
 * org.mybatis.spring.annotation.MapperScan; import
 * org.springframework.stereotype.Repository;
 * 
 * @Repository
 * 
 * @Mapper public interface WorkMapper {
 * 
 * @Insert("insert into work(userCode, listTitle, listCategory, listContent, listDate, listFinishDate, listAmount, listCnt, listState, listRegion, listStartTime,listEndTime) "
 * +
 * "		values(#{userCode}, #{listTitle}, #{listCategory}, #{listContent}, now(), #{listFinishDate}, #{listAmount}, 0, #{listState},#{listStartTime}, #{listEndTime})"
 * ) public int insert(WorkVo vo); // public WorkVo view(int listCode); }
 */