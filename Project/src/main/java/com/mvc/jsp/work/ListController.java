package com.mvc.jsp.work;

import java.util.ArrayList;
import java.util.List;
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
		mv.addObject("listCode", listcode);
		mv.setViewName("redirect:/jsp/view");
		return mv;

	}	
	
	@RequestMapping("/modifyList")
	public ModelAndView workModify(WorkDto dto, RedirectAttributes redirectAttributes) {

		ModelAndView mv = new ModelAndView();
		Long listcode = service.modify(dto);
		mv.addObject("listCode", listcode);
		mv.setViewName("redirect:/jsp/view");
		return mv;

	}

	@RequestMapping("/view")
	public ModelAndView workViewPage(Long listCode, Model model) {
		System.out.println("list>view+" + listCode);
		ModelAndView mv = new ModelAndView();
		WorkDto wdto = service.read(listCode);
		mv.addObject("work", wdto);
		mv.addObject("userid", "ALLO");
		mv.setViewName("work/read");
		return mv;
	}

	@RequestMapping("/modify")
	public ModelAndView workModifyPage(Long listCode, Model model) {
		System.out.println("list>modify+" + listCode);
		ModelAndView mv = new ModelAndView();
		WorkDto wdto = service.read(listCode);
		mv.addObject("work", wdto);
		mv.setViewName("work/modify");
		return mv;
	}

	@RequestMapping("/remove")
	public ModelAndView workRemovePage(Long listCode, Model model) {
		System.out.println("list>remove+" + listCode);
		ModelAndView mv = new ModelAndView();
		service.remove(listCode);
		mv.setViewName("redirect:/jsp/list");
		;
		return mv;
	}

	@RequestMapping("/listsearch")
	public ModelAndView searchList(String searchInput, PageRequestDTO pageRequestDTO, Model model) {
		List<Work> work = service.getSearchList(searchInput);
		List<String> stringList = new ArrayList<String>();
		for (Work w : work) {
			String[] imgsrc = w.getListContent().split("src=");
			if (imgsrc.length > 1) {
				int firstQuoteIndex = imgsrc[1].indexOf("\"");
				int secondQuoteIndex = imgsrc[1].indexOf("\"", firstQuoteIndex + 1);
				String result = imgsrc[1].substring(firstQuoteIndex + 1, secondQuoteIndex);
				stringList.add(result);
			} else {
				stringList.add("../img/helpAnt.png");
			}
		}

		ModelAndView mv = new ModelAndView();

		List<Work> workp = service.getList8(pageRequestDTO);
		List<String> stringListp = new ArrayList<String>();
		for (Work w : workp) {
			String[] imgsrc = w.getListContent().split("src=");
			if (imgsrc.length > 1) {
				int firstQuoteIndex = imgsrc[1].indexOf("\"");
				int secondQuoteIndex = imgsrc[1].indexOf("\"", firstQuoteIndex + 1);
				String result = imgsrc[1].substring(firstQuoteIndex + 1, secondQuoteIndex);
				stringListp.add(result);
			} else {
				stringListp.add("../img/helpAnt.png");
			}
		}

		mv.addObject("imgsrcp", stringListp);
		mv.addObject("workp", workp);
		mv.addObject("searchInput", searchInput);
		mv.addObject("imgsrc", stringList);
		mv.addObject("work", work);
		mv.setViewName("/user/list2");
		return mv;
	}

	@RequestMapping("/listCheck")
	public ModelAndView checkList(String Category, PageRequestDTO pageRequestDTO, Model model) {
		System.out.println(Category);
		// 최신순리스트
		List<Work> work = service.getCategoryList(Category);
		List<String> stringList = new ArrayList<String>();
		for (Work w : work) {
			System.out.println(w);
			String[] imgsrc = w.getListContent().split("src=");
			if (imgsrc.length > 1) {
				int firstQuoteIndex = imgsrc[1].indexOf("\"");
				int secondQuoteIndex = imgsrc[1].indexOf("\"", firstQuoteIndex + 1);
				String result = imgsrc[1].substring(firstQuoteIndex + 1, secondQuoteIndex);
				stringList.add(result);
			} else {
				stringList.add("../img/helpAnt.png");
			}
		}

		ModelAndView mv = new ModelAndView();
		// 요즘뜨는거
		List<Work> workp = service.getList8(pageRequestDTO);
		List<String> stringListp = new ArrayList<String>();
		for (Work w : workp) {
			String[] imgsrc = w.getListContent().split("src=");
			if (imgsrc.length > 1) {
				int firstQuoteIndex = imgsrc[1].indexOf("\"");
				int secondQuoteIndex = imgsrc[1].indexOf("\"", firstQuoteIndex + 1);
				String result = imgsrc[1].substring(firstQuoteIndex + 1, secondQuoteIndex);
				stringListp.add(result);
			} else {
				stringListp.add("../img/helpAnt.png");
			}
		}

		mv.addObject("imgsrcp", stringListp);
		mv.addObject("workp", workp);
		mv.addObject("imgsrc", stringList);
		mv.addObject("work", work);
		mv.setViewName("/user/list2");
		return mv;
	}
	/*
	 * @RequestMapping("/categoryCheck") public ModelAndView checkCategory(Integer
	 * amount, String category, String region, PageRequestDTO pageRequestDTO, Model
	 * model) { System.out.println(amount + " " + category + " " + region);
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * // 요즘뜨는거 List<Work> workp = service.getList(amount,category,region);
	 * List<String> stringListp = new ArrayList<String>(); for (Work w : workp) {
	 * String[] imgsrc = w.getListContent().split("src="); if (imgsrc.length > 1) {
	 * int firstQuoteIndex = imgsrc[1].indexOf("\""); int secondQuoteIndex =
	 * imgsrc[1].indexOf("\"", firstQuoteIndex + 1); String result =
	 * imgsrc[1].substring(firstQuoteIndex + 1, secondQuoteIndex);
	 * stringListp.add(result); } else { stringListp.add("../img/helpAnt.png"); } }
	 * 
	 * mv.addObject("imgsrcp", stringListp); mv.addObject("workp", workp);
	 * mv.setViewName("/user/list2");
	 * 
	 * return mv; }
	 */

}
