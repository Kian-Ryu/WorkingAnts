package com.mvc.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.jsp.work.WorkDto;
import com.mvc.jsp.work.WorkService;

@Controller
@RequestMapping("/jsp")
@RestController
public class ServiceController {
	@Autowired
	ServiceService service;

	@RequestMapping("/createQnA")
	public ModelAndView workView(ServiceDto dto, RedirectAttributes redirectAttributes) {
		System.out.println("controller>service");
		ModelAndView mv = new ModelAndView();
		service.register(dto);
		
		mv.setViewName("redirect:/jsp/inquiry");
		return mv;

	}
	@RequestMapping("/introduce")
	public ModelAndView serviceIntro(RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/service/introducePage");
		return mv;

	}
}
