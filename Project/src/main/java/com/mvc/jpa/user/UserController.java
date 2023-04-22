package com.mvc.jpa.user;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mvc.grade.GradeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService service;
	private final GradeService gradeservice;
	
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

	@GetMapping("/mypage/{userCode}")
	public String mypage_dash(@PathVariable long userCode, Model m) {
		UserDTO dto = service.read(userCode);
		m.addAttribute("dto", dto);
		m.addAttribute("avgGrade", gradeservice.avgGrade(userCode));
//		log.info();
		return "/mypage_dash";
	}
	@PostMapping(value = "/updateReg", produces = "application/json")
	@ResponseBody
	public void updateReg(@RequestParam Map<String, Object> param) {
		log.info("updatereg 실행");
		log.info(param.get("Code"));
		service.updateReg(Long.parseLong((String) param.get("Code")), (String)param.get("userRegion"));
	}
}
