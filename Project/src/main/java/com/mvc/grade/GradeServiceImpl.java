package com.mvc.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
	
	@Autowired
	private final GradeRepository repo;
	
	
	public void register(GradeDTO dto) {
		Grade g = dToEntity(dto);
		repo.save(g);
	}
	
	public long avgGrade(long userCode) {
		return repo.avgGrade(userCode);
	}
	
	
}
