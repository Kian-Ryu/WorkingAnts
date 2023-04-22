package com.mvc.grade;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/grade")
@RequiredArgsConstructor
public class GradeController {
	private final GradeService service;
	
	@PostMapping(value = "/register", produces = "application/json")
	public void register(@RequestParam GradeDTO dto) {
		service.register(dto);
	}
	
}
