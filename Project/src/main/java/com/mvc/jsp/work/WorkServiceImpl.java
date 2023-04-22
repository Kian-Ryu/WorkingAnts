package com.mvc.jsp.work;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageRequestDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.TypedQuery;

@Service
@RequiredArgsConstructor
public class WorkServiceImpl implements WorkService {

	private final WorkRepository repository;

	//등록
	@Override
	public Long register(WorkDto dto) {
		System.out.println("service register");
		Work entity = dtoToEntity(dto);
		entity.setListState("모집중");
		repository.save(entity);
		System.out.println("저장완료");
		return entity.getListCode();
	}
	
	//상세보기
	@Override
	public WorkDto read(Long listCode) {

		Optional<Work> result = repository.findById(listCode);
		
		if(result.isPresent()) {
			Work entity = result.get();
			entity.increaselistCnt();
			repository.save(entity);;
		}

		return result.isPresent() ? entityToDto(result.get()) : null;
	}
	
	//수정
		@Transactional
		@Override
		public Long modify(WorkDto dto) {

	        Work work = repository.getOne(dto.getListCode());

	        if(work != null) {
	        	work.changeAmount(dto.getListAmount());
	        	work.changeCategory(dto.getListCategory());
	        	work.changeContent(dto.getListContent());
	        	work.changeEndTime(dto.getListEndTime());
	        	work.changeFinishDate(dto.getListFinishDate());
	        	work.changeRegion(dto.getListRegion());
	        	work.changeStartTime(dto.getListStartTime());
	        	work.changeTitle(dto.getListTitle());

	            repository.save(work);
	        }
			return dto.getListCode();
		}

		//삭제
	@Override
	public void remove(Long listCode) {

		repository.deleteById(listCode);

	}

	//main list 조회순으로 출력
	@Override
	public List<Work> getList8(PageRequestDTO requestDTO) {

		Pageable pageable = requestDTO.getPageable(Sort.by("listCnt").descending());

		List<Work> workList = repository.findAll(pageable).getContent();

		return workList;

	}

	
	 
}