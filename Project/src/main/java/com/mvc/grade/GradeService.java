package com.mvc.grade;

public interface GradeService {
	default Grade dToEntity(GradeDTO dto) {
		Grade entity = Grade.builder().gradeCode(dto.getGradeCode()).userCode(dto.getUserCode()).listCode(dto.getListCode()).grade(dto.getGrade()).build();
		return entity;
	}
	default GradeDTO eToDTO(Grade entity) {
		GradeDTO dto = GradeDTO.builder().gradeCode(entity.getGradeCode()).userCode(entity.getUserCode()).listCode(entity.getListCode()).grade(entity.getGrade()).build();
		return dto;
	}
	public void register(GradeDTO dto);
	public double avgGrade(long userCode);
//	long avgGrade(long userCode);
	
}
