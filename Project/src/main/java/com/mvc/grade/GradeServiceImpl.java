package com.mvc.grade;

import java.util.List;
import java.util.Optional;

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
	
	public void read() {
		
	}
	
	public void register(GradeDTO dto) {
		Grade g = dToEntity(dto);
		repo.save(g);
	}
	
	public double avgGrade(int userCode) {
		double sum = 0.0;
		List<Grade> result = repo.findByUserCode(userCode);
		if(!result.isEmpty()) {
			for (Grade grade : result) {
				GradeDTO dto = eToDTO(grade);
				sum = sum + grade.getGrade();
			}
		}
		double avg = Math.round((sum/result.size())*100)/100.0;
		return avg;
	}

	
}
