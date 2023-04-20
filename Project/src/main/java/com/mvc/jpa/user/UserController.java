package com.mvc.jpa.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService service;
	
	@GetMapping("/register")
	public String register() {
		log.info("resgister get...");
		return "/register";
	}
	@PostMapping("/register")
	public void registerPost(UserDTO dto, MultipartFile profile) {
		service.register(dto, profile);
		log.info("처리 완료");
	}
//	@GetMapping("/mypage")
//	public String mypage_dash() {
//		return "/mypage_dash";
//	}
	@GetMapping("/mypage/{userCode}")
	public String mypage_dash(@PathVariable long userCode, Model m) {
		UserDTO dto = service.read(userCode);
		m.addAttribute("dto", dto);
//		log.info();
		return "/mypage_dash";
	}
	@PostMapping("/updateReg")
	public String updateReg(long userCode, String userRegion) {
		log.info("updatereg 실행");
		service.updateReg(userCode, userRegion);
		return "redirect:/user/mypage/"+userCode;
	}
}
