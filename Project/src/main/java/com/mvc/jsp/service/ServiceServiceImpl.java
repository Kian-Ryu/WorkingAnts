package com.mvc.jsp.service;

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
public class ServiceServiceImpl implements ServiceService {

	private final ServiceRepository repository;

	//등록
	@Override
	public void register(ServiceDto dto) {
		System.out.println("service register");
		com.mvc.jsp.service.Service entity = dtoToEntity(dto);
		repository.save(entity);
		System.out.println("저장완료");
	}
		
	 
}