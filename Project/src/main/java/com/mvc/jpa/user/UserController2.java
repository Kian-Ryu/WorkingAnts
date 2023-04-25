//package com.mvc.jpa.user;
//
//import java.util.Map;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.ktj.service.EmailService;
//import com.mvc.grade.GradeService;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//
//@Controller
//@Log4j2
//@RequestMapping("/")
//@RequiredArgsConstructor
//public class UserController2 {
//	private final UserService service;
//	private final GradeService gradeservice;
//	private final EmailService emailService;
//	
//	@PostMapping("/createUser")
//	public String registerPost(UserDTO dto, MultipartFile profile) {
//		service.register(dto, profile);
//		return"users/login";
//	}
//	
//	@DeleteMapping("/deleteUser") // 관리자 테이블 유저정보 삭제
//	public void deleteCustomer(long userCode) {
//		service.deleteByUserCode(userCode);
//	}
//	
//	@PutMapping("/updateUser") // 관리자 테이블 유저정보 수정
//	public String updateUser(@RequestBody Users user) {
//		service.updateUser(user);
//		return "users/admin";
//	}
//	@PostMapping(value ="/updateUserbyU", produces="application/json") // 유저 유저정보 수정
//	@ResponseBody
//	public void updateUserbyU(@RequestParam Users user) {
//		log.info(user);
//		service.updateUser(user);
//	}
//	
//	@GetMapping("/mypage/{userCode}")
//	public String mypage_dash(@PathVariable long userCode, Model m) {
//		UserDTO dto = service.read(userCode);
//		m.addAttribute("dto", dto);
//		m.addAttribute("avgGrade", gradeservice.avgGrade(userCode));
////		log.info();
//		return "/mypage_dash";
//	}
//	@PostMapping(value = "/updateReg", produces = "application/json")
//	@ResponseBody
//	public void updateReg(@RequestParam Map<String, Object> param) {
//		log.info("updatereg 실행");
//		log.info(param.get("Code"));
//		service.updateReg(Long.parseLong((String) param.get("Code")), (String)param.get("userRegion"));
//	}
//	@PostMapping(value = "/updateAnother", produces = "application/json")
//	@ResponseBody
//	public void updateAnother(@RequestParam Map<String, Object> param) {
//		log.info("updateAnother 실행");
//		log.info(param.get("Code"));
//		service.updateAnother(Long.parseLong((String) param.get("Code")), (String)param.get("userNickName"),  (String)param.get("userPw"),  (String)param.get("userEmail"),  (String)param.get("userPhone"));
//	}
//	@PostMapping("/find-password") // 패스워드정보확인용 확인용 문자 메일보내기 메서드
//	public String findPassword(@RequestParam String userEmail, Model model) {
//		Users user = service.findByUserEmail(userEmail);
//		if (user == null) {
//			model.addAttribute("error", "User not found");
//			return "find-password";
//		}
//		String password = user.getUserPw();
//		emailService.sendPassword(userEmail, password);
//		model.addAttribute("message", "Your password has been sent to your email");
//		return "users/login";
//	}
//	@GetMapping("/test")
//	public String nav() {
//		return "/user/tablerequest";
//	}
//}
