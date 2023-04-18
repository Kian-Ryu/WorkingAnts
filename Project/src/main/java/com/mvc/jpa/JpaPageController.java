package com.mvc.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class JpaPageController {

	@GetMapping("/about")
	public String about() {
		return "/about";
	}

	@GetMapping("/blog")
	public String blog() {
		return "/blog";
	}

	@GetMapping("/contact")
	public String contact() {
		return "/contact";
	}

	@GetMapping("/detail")
	public String detail() {
		return "/detail";
	}

	@GetMapping("/feature")
	public String feature() {
		return "/feature";
	}

	@GetMapping("/index")
	public String index() {
		return "/index";
	}

	@GetMapping("/product")
	public String product() {
		return "/product";
	}

	@GetMapping("/service")
	public String service() {
		return "/service";
	}

	@GetMapping("/team")
	public String team() {
		return "/team";
	}

	@GetMapping("/testimonial")
	public String testimonial() {
		return "/testimonial";
	}
	

}