package com.mvc.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspPageController {
	@GetMapping("/index")
	public String mainPage() {
		return "main";
	}
	
	/* service */
	@GetMapping("/faq")
	public String faqPage() {
		return "service/faq";
	}
	@GetMapping("/inquiry")
	public String inqPage() {
		return "service/inquiry";
	}

	/* work */
	@GetMapping("/list")
	public String workReadPage() {
		return "work/list";
	}
	@GetMapping("/view")
	public String workViewPage() {
		return "work/read";
	}
	@GetMapping("/create")
	public String workCreatePage() {
		return "work/create";
	}
	@GetMapping("/modify")
	public String workModifyPage() {
		return "work/modify";
	}

}