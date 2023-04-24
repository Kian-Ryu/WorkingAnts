package com.ktj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.jpa.user.UserService;



@Controller
@RequestMapping("/")
public class PageController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String register() {
		return "users/register";
	}

	@GetMapping("/password")
	public String password() {
		return "users/password";
	}
	
	// home 확인용
	@GetMapping("/home")
	public String home() {
		return "users/home";
	}

	// 팀장 메인
	@GetMapping("/header")
	public String header() {
		return "layout/header";
	}

	@GetMapping("/header_logout")
	public String header_logout() {
		return "layout/header_logout";
	}

	@GetMapping("/nav")
	public String nav() {
		return "layout/nav";
	}

	@GetMapping("/footer")
	public String footer() {
		return "layout/footer";
	}

	// jsp
	@GetMapping("/table")
	public String table() {
		return "table";
	}

	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("list", userService.UserAll());
		return "users/admin";
	}
	
	@GetMapping("/naverMain")
	public String naverMain() {
		return "navermain";
	}


}