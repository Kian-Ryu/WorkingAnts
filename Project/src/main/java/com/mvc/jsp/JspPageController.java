package com.mvc.jsp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.jsp.work.PageRequestDTO;
import com.mvc.jsp.work.PageResultDTO;
import com.mvc.jsp.work.Work;
import com.mvc.jsp.work.WorkDto;
import com.mvc.jsp.work.WorkService;

@RestController
@RequestMapping("/jsp")
public class JspPageController {
	@Autowired
	WorkService service;

	@RequestMapping("/index")
    public ModelAndView mainPage(PageRequestDTO pageRequestDTO, Long listCode, Model model) {
		List<Work> workp=service.getList8(pageRequestDTO);
		List<String> stringListp = new ArrayList<String>();
		for(Work w:workp){
			String[] imgsrc = w.getListContent().split("src=");
			if(imgsrc.length>1) {
				int firstQuoteIndex = imgsrc[1].indexOf("\"");
				int secondQuoteIndex = imgsrc[1].indexOf("\"", firstQuoteIndex + 1);
				String result = imgsrc[1].substring(firstQuoteIndex + 1, secondQuoteIndex);
				stringListp.add(result);
			}
			else {
				stringListp.add("../img/helpAnt.png");
			}
		}
		
		ModelAndView mv = new ModelAndView();
		if(listCode==null) {
			listCode=0L;
		}
		mv.addObject("listCode",listCode);
		mv.addObject("imgsrc", stringListp);
		mv.addObject("work",workp);
        mv.setViewName("main");
		return mv;
    }

	/* service */
	@RequestMapping("/faq")
	public ModelAndView faqPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("service/faq");
		return mv;
	}

	@RequestMapping("/inquiry")
	public ModelAndView inqPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("service/inquiry");
		return mv;
	}

	/* work */

	@RequestMapping("/list")
	public ModelAndView workReadPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("work/list");
		return mv;
	}

	@RequestMapping("/create")
	public ModelAndView workCreatePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("work/create");
		return mv;
	}


}