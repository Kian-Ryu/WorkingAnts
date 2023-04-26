package com.ktj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.jpa.user.UserService;
import com.mvc.jpa.user.Users;
import com.mvc.jsp.work.PageRequestDTO;
import com.mvc.jsp.work.Work;
import com.mvc.jsp.work.WorkService;



@Controller
@RequestMapping("/")
public class PageController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	WorkService service;


	@GetMapping("/register")
	public String register() {
		return "/users/register";
	}

	@GetMapping("/password")
	public String password() {
		return "/users/password";
	}
	
	// home 확인용
	@GetMapping("/home")
	public String home() {
		return "/users/home";
	}

	// 팀장 메인
	@GetMapping("/header")
	public String header() {
		return "/layout/header";
	}

	@GetMapping("/header_logout")
	public String header_logout() {
		return "/layout/header_logout";
	}

	@GetMapping("/nav")
	public String nav() {
		return "/layout/nav";
	}

	@GetMapping("/footer")
	public String footer() {
		return "/layout/footer";
	}

	// jsp
	@GetMapping("/table")
	public String table() {
		return "/table";
	}

	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("list", userService.UserAll());
		model.addAttribute("userNickName", "admin");
		return "/users/admin";
	}
	
	@GetMapping("/naverMain")
	public ModelAndView naverMain(PageRequestDTO pageRequestDTO, Long listCode, Model model) {
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
        mv.setViewName("navermain");
		return mv;

	}


	@GetMapping("/users/chat")
	public String chatView(Model model, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		model.addAttribute("user", user);
		return "/users/chat";
	}

	@PostMapping("/saveNaverUserInfo")
	@ResponseBody
	public void saveNaverUserInfo(@RequestParam String email, @RequestParam String nickname, HttpSession session) {
		Users user = new Users();
		user.setUserEmail(email);
		user.setUserNickName(nickname);

		session.setAttribute("user", user);
	}
	
	@GetMapping("/users/naverchat")
	public String naverchatView(Model model, HttpSession session) {
	    Users user = (Users) session.getAttribute("user");
	    if (user == null) {
	        return "redirect:/login";
	    }
	    model.addAttribute("user", user);
	    return "/users/chat";
	}
}