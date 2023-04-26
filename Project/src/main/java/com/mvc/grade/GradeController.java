package com.mvc.grade;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.jpa.user.UserDTO;
import com.mvc.jsp.work.Work;
import com.mvc.jsp.work.WorkDto;
import com.mvc.jsp.work.WorkService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/grade")
@RequiredArgsConstructor
public class GradeController {
	private final GradeService service;
	private final WorkService wservice;
	@PostMapping(value = "/register", produces = "application/json")
	public void register(@RequestParam GradeDTO dto) {
		service.register(dto);
	}
	
	@RequestMapping("/regGrade")
	public ModelAndView regGrade(long listCode, double grade, Model m) {
		ModelAndView mv = new ModelAndView();
		WorkDto wdto = wservice.read(listCode);
		GradeDTO dto = new GradeDTO();
		dto.setGrade(grade);
		dto.setListCode(listCode);
//		dto.setUserCode(wdto.getUserCode2);
		service.register(dto);
//		List<Work> workp = wservice.getListByUsercode(wdto.getUserCode2);
		List<Work> workp = null;
//		List<Grade> gradelist = service.findByUserCode(wdto.getUserCode2);
		List<Grade> gradelist = null;
		mv.addObject("workp", workp);
		mv.addObject("gradelist", gradelist);
		mv.setViewName("reqtable :: #myreqwork");
		return mv;
	}
	
}
