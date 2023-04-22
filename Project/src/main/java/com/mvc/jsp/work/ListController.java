package com.mvc.jsp.work;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping("/jsp")
@RestController
public class ListController {
	String uploadPath = "C:\\Users\\gram\\git\\Project6\\WorkingAnts\\Project\\src\\main\\resources\\static\\upload";
	@Autowired
	WorkService service;

	@RequestMapping("/createList")
	public ModelAndView workView(WorkDto dto, RedirectAttributes redirectAttributes) {
		System.out.println("만들어져라 얍");
		ModelAndView mv = new ModelAndView();
		Long listcode = service.register(dto);
		mv.addObject("listCode",listcode);
		mv.setViewName("redirect:/jsp/view");
		return mv;

	}

	@RequestMapping("/modifyList")
	public ModelAndView workModify(WorkDto dto, RedirectAttributes redirectAttributes) {
		System.out.println("바껴라 얍");
		ModelAndView mv = new ModelAndView();
		Long listcode = service.modify(dto);
		mv.addObject("listCode",listcode);
		mv.setViewName("redirect:/jsp/view");
		return mv;

	}

	@RequestMapping("/view")
    public ModelAndView workViewPage(Long listCode, Model model) {
        System.out.println("list>view+"+listCode);
		ModelAndView mv = new ModelAndView();
        WorkDto wdto = service.read(listCode);
		mv.addObject("work",wdto);
        mv.addObject("userid","ALLO");
        mv.setViewName("work/read");
		return mv;
    }

	@RequestMapping("/modify")
    public ModelAndView workModifyPage(Long listCode, Model model) {
        System.out.println("list>modify+"+listCode);
		ModelAndView mv = new ModelAndView();
        WorkDto wdto = service.read(listCode);
		mv.addObject("work",wdto);
        mv.setViewName("work/modify");
		return mv;
    }
	
	@RequestMapping("/remove")
	public ModelAndView workRemovePage(Long listCode, Model model) {
		System.out.println("list>remove+"+listCode);
		ModelAndView mv = new ModelAndView();
		service.remove(listCode);
		mv.setViewName("redirect:/jsp/list");;
		return mv;
	}
}
