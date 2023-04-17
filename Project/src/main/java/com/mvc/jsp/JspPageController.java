package com.mvc.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspPageController {
	@GetMapping("/index")
	public String forgot() {
		return "main";
	}
//	@GetMapping("/forgot-password")
//	public String forgot() {
//		return "/member/forgot-password";
//	}
//
//	@GetMapping("/login")
//	public String login() {
//		return "/member/login";
//	}
//
//	@GetMapping("/register")
//	public String register() {
//		return "/member/register";
//	}

}