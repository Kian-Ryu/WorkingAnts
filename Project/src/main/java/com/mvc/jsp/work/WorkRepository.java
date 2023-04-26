package com.mvc.jsp.work;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

public interface WorkRepository extends JpaRepository<Work, Long>, QuerydslPredicateExecutor<Work> {
	@Query("SELECT w FROM Work w WHERE w.listState = :listState and (w.listCategory like :listSearch or w.listTitle like :listSearch or w.listRegion like :listSearch) order by w.listDate Desc")
	List<Work> findByListCategoryOrListTitleOrListRegion(@Param("listSearch") String listSearch, @Param("listState") String listState);
	
	@Query("SELECT w FROM Work w WHERE w.listState = :listState order by w.listCnt Desc")
	List<Work> findByListState(@Param("listState") String listState);
	
	@Query("SELECT w FROM Work w WHERE w.listState = :listState and w.listCategory like :Category order by w.listDate Desc")
	List<Work> findByListCategory(@Param("Category") String Category, @Param("listState") String listState);
	
	@Query("SELECT w FROM Work w WHERE w.listAmount <= :amount and w.listRegion like :region and w.listState like :listState and w.listCategory like :categoryLike order by w.listDate Desc")
	List<Work> findByListAmountAndListCategoryAndListRegionAndListState(@Param("amount") Integer amount,@Param("categoryLike") String categoryLike,@Param("region") String regionLike,@Param("listState") String listState);

	@Query("SELECT w FROM Work w WHERE w.listAmount >= :amount and w.listRegion like :region and w.listState like :listState and w.listCategory like :categoryLike order by w.listDate Desc")
	List<Work> findByListAmount2AndListCategoryAndListRegionAndListState(@Param("amount") Integer amount,@Param("categoryLike") String categoryLike,@Param("region") String regionLike,@Param("listState") String listState);

	@Query("SELECT w FROM Work w WHERE w.listRegion like :region and w.listState like :listState and w.listCategory like :categoryLike order by w.listDate Desc")
	List<Work> findByListCategoryAndListRegionAndListState(@Param("categoryLike") String categoryLike,@Param("region") String regionLike,@Param("listState") String listState);


	
}
