package com.mvc.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class JpaPageController {

	@GetMapping("/tablerequest")
	public String tablerequest() {
		return "/tablerequest";
	}

	@GetMapping("/tableresult")
	public String tableresult() {
		return "/tableresult";
	}

	@GetMapping("/tabletrying")
	public String tabletrying() {
		return "/tabletrying";
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@GetMapping("/register")
	public String register() {
		return "/register";
	}

	@GetMapping("/password")
	public String password() {
		return "/password";
	}

	@GetMapping("/admin")
	public String admin() {
		return "/admin";
	}

}