package com.mvc.jsp.work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.mvc.jpa.user.Users;

@Controller
@RequestMapping("/jsp")
@RestController
public class ListController {
	String uploadPath = "C:\\Users\\gram\\git\\Project6\\WorkingAnts\\Project\\src\\main\\resources\\static\\upload";
	@Autowired
	WorkService service;

	@RequestMapping("/createList")
	public ModelAndView workView(WorkDto dto, RedirectAttributes redirectAttributes, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Users user = (Users) session.getAttribute("user");
		System.out.println(user.getUserCode());
		dto.setUserCode(user.getUserCode());
		System.out.println("service"+dto.getListCategory());
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
	public ModelAndView workViewPage(Long listCode, Model model, HttpSession session) {
		System.out.println("list>view+" + listCode);
		Users user = (Users) session.getAttribute("user");
		String userNickname = user.getUserNickName();
		ModelAndView mv = new ModelAndView();
		WorkDto wdto = service.read(listCode);
		String nickname = service.getUsernickname(wdto.getUserCode());
		mv.addObject("sessionName",userNickname);
		mv.addObject("work", wdto);
		mv.addObject("userid", nickname);
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
		List<String> userListp = new ArrayList<String>();
		for (Work w : workp) {
			userListp.add(service.getUsernickname(w.getUserCode()));
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

		mv.addObject("string", userListp);
		mv.addObject("imgsrcp", stringListp);
		mv.addObject("workp", workp);
		mv.addObject("searchInput", searchInput);
		mv.addObject("imgsrc", stringList);
		mv.addObject("work", work);
		mv.setViewName("/work/list2");
		return mv;
	}

	@RequestMapping("/listCheck")
	public ModelAndView checkList(String Category, PageRequestDTO pageRequestDTO, Model model) {
		System.out.println(Category);
		// 최신순리스트
		List<Work> work = service.getCategoryList(Category);
		List<String> stringList = new ArrayList<String>();
		List<String> userListp = new ArrayList<String>();
		for (Work w : work) {
			System.out.println(w);
			String[] imgsrc = w.getListContent().split("src=");
			userListp.add(service.getUsernickname(w.getUserCode()));
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

		mv.addObject("string", userListp);
		mv.addObject("imgsrcp", stringListp);
		mv.addObject("workp", workp);
		mv.addObject("imgsrc", stringList);
		mv.addObject("work", work);
		mv.setViewName("/work/list2");
		return mv;
	}

	@RequestMapping("/categoryCheck")
	public ModelAndView checkCategory(String amount, String category, String region,
			PageRequestDTO pageRequestDTO, Model model) {
		System.out.println("categoryCheckCard" + amount + " " + category + " " + region);
		
		  ModelAndView mv = new ModelAndView();
		 
		// 요즘뜨는거
		List<Work> workp = service.getList(amount, category, region);
		List<String> stringListp = new ArrayList<String>();
		List<String> userListp = new ArrayList<String>();
		
		for (Work w : workp) {
			String[] imgsrc = w.getListContent().split("src=");
			userListp.add(service.getUsernickname(w.getUserCode()));
			if (imgsrc.length > 1) {
				int firstQuoteIndex = imgsrc[1].indexOf("\"");
				int secondQuoteIndex = imgsrc[1].indexOf("\"", firstQuoteIndex + 1);
				String result = imgsrc[1].substring(firstQuoteIndex + 1, secondQuoteIndex);
				stringListp.add(result);
			} else {
				stringListp.add("../img/helpAnt.png");
			}
		}

		mv.addObject("string", userListp);
		mv.addObject("imgsrc", stringListp);
		mv.addObject("work", workp);
		mv.setViewName("/work/list2 :: #cardWorkList");


		return mv;
	}

	@RequestMapping("/categoryTableCheck")
	public ModelAndView categoryTableCheck(String amount, String category, String region,
			PageRequestDTO pageRequestDTO, Model model) {
		System.out.println("categoryCheckTable" + amount + " " + category + " " + region);
		
		  ModelAndView mv = new ModelAndView();
		 
		// 요즘뜨는거
		List<Work> workp = service.getList(amount, category, region);
		List<String> stringListp = new ArrayList<String>();
		List<String> userListp = new ArrayList<String>();
		
		for (Work w : workp) {
			String[] imgsrc = w.getListContent().split("src=");
			userListp.add(service.getUsernickname(w.getUserCode()));
			
			if (imgsrc.length > 1) {
				int firstQuoteIndex = imgsrc[1].indexOf("\"");
				int secondQuoteIndex = imgsrc[1].indexOf("\"", firstQuoteIndex + 1);
				String result = imgsrc[1].substring(firstQuoteIndex + 1, secondQuoteIndex);
				stringListp.add(result);
			} else {
				stringListp.add("../img/helpAnt.png");
			}
		}

		mv.addObject("string", userListp);
		mv.addObject("imgsrc", stringListp);
		mv.addObject("work", workp);
		mv.setViewName("/work/list2 :: #tableWorkList");


		return mv;
	}
	
}
