
package com.mvc.jsp.work;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface WorkService {
	Long register(WorkDto dto);
	
	Long modify(WorkDto dto);

	WorkDto read(Long listcode);
	
	List<Work> getList8(PageRequestDTO requestDTO);

	List<Work> getList(String amount,String category,String region);

	void remove(Long gno);

	List<Work> getCategoryList(String category);
	
	List<Work> getSearchList(String search);

	default Work dtoToEntity(WorkDto dto) {

		Work entity = Work.builder()

				.listCode(dto.getListCode())

				.listTitle(dto.getListTitle())

				.listCategory(dto.getListCategory())

//				.usercode(dto.getUsercode())

				.listContent(dto.getListContent())

				.listAmount(dto.getListAmount())

				.listCnt(dto.getListCnt())

				.listState(dto.getListState())

				.listRegion(dto.getListRegion())

				.listStartTime(dto.getListStartTime())

				.listEndTime(dto.getListEndTime())

				.listDate(dto.getListDate())

				.listFinishDate(dto.getListFinishDate())

				.build();

		return entity;

	}

	default WorkDto entityToDto(Work entity) {

		WorkDto dto = WorkDto.builder()

				.listCode(entity.getListCode())

				.listTitle(entity.getListTitle())

				.listCategory(entity.getListCategory())

//				.usercode(entity.getUsercode())

				.listContent(entity.getListContent())

				.listAmount(entity.getListAmount())

				.listCnt(entity.getListCnt())

				.listState(entity.getListState())

				.listRegion(entity.getListRegion())

				.listStartTime(entity.getListStartTime())

				.listEndTime(entity.getListEndTime())

				.listDate(entity.getListDate())

				.listFinishDate(entity.getListFinishDate())

				.build();

		return dto;

	}


}
