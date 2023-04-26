package com.mvc.jpa.user;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktj.service.EmailService;
import com.mvc.grade.Grade;
import com.mvc.grade.GradeService;
import com.mvc.jsp.work.Work;
import com.mvc.jsp.work.WorkService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
	private final UserService service;
	private final GradeService gradeservice;
	private final EmailService emailService;
	private final WorkService workService;
	
	@PostMapping("/createUser") // 계정생성
	public String createUser(Users user) {
		service.createUser(user);
		return "users/login";
	}
	
	@DeleteMapping("/deleteUser") // 관리자 테이블 유저정보 삭제
	public void deleteCustomer(long userCode) {
		service.deleteByUserCode(userCode);
	}
	@GetMapping("/deleteuserbyself")
	public String deleteUserBySelf(long userCode) {
		service.deleteByUserCode(userCode);
		 return "redirect:/jsp/index";
	}
	
	@PutMapping("/updateUser") // 관리자 테이블 유저정보 수정
	public String updateUser(@RequestBody Users user) {
		service.updateUser(user);
		return "users/admin";
	}
	@PostMapping(value ="/updateUserbyU", produces="application/json") // 유저 유저정보 수정
	@ResponseBody
	public void updateUserbyU(@RequestParam Users user) {
		log.info(user);
		service.updateUser(user);
	}
	
	@RequestMapping("/addImg")
	public ModelAndView addImg(@RequestParam("userCode") long userCode,@RequestParam("profile") MultipartFile file, Model m) throws IllegalStateException, IOException {
		ModelAndView mv = new ModelAndView();
		service.addImg(userCode, file);
		UserDTO dto = service.read(userCode);
		mv.addObject("dto",dto);
		mv.addObject("avgGrade", gradeservice.avgGrade(userCode));
		mv.setViewName("/user/mypage_dash :: #users");
		return mv;
		
	}
	
	@GetMapping("/mypage/{userCode}")
	public String mypage_dash(@PathVariable long userCode, Model m) {
		log.info(System.getProperty("user.dir") + "/src/main/resources/static/img/profile");
		UserDTO dto = service.read(userCode);
		m.addAttribute("dto", dto);
		m.addAttribute("avgGrade", gradeservice.avgGrade(userCode));
//		log.info();
		return "/mypage_dash";
	}
	@RequestMapping("/updateReg")
	public ModelAndView updateReg1(long userCode, String userRegion, Model m) {
		ModelAndView mv = new ModelAndView();
		service.updateReg(userCode, userRegion);
		UserDTO dto = service.read(userCode);
		log.info(dto);
		mv.addObject("dto",dto);
		mv.addObject("avgGrade", gradeservice.avgGrade(userCode));
		mv.setViewName("/user/mypage_dash :: #users");
		return mv;
	}
	@RequestMapping("/updateAnother")
	public ModelAndView updateAnother1(long userCode, String userNickName, String userEmail, String userPw, String userPhone, Model m) {
		ModelAndView mv = new ModelAndView();
		service.updateAnother(userCode, userNickName, userPw, userEmail, userPhone);
		UserDTO dto = service.read(userCode);
		log.info(dto);
		mv.addObject("dto",dto);
		mv.addObject("avgGrade", gradeservice.avgGrade(userCode));
		mv.setViewName("/user/mypage_dash :: #users");
		return mv;
	}
	@PostMapping("/find-password") // 패스워드정보확인용 확인용 문자 메일보내기 메서드
	public String findPassword(@RequestParam String userEmail, Model model) {
		Users user = service.findByUserEmail(userEmail);
		if (user == null) {
			model.addAttribute("error", "User not found");
			return "find-password";
		}
		String password = user.getUserPw();
		emailService.sendPassword(userEmail, password);
		model.addAttribute("message", "Your password has been sent to your email");
		return "users/login";
	}
	
	@RequestMapping("/myreqlist")
	public ModelAndView myreqTable(long userCode, Model m) {
		ModelAndView mv = new ModelAndView();
		List<Work> workp = workService.getListByUsercode(userCode);
		List<Grade> grade = gradeservice.findByUserCode(userCode);
		
		mv.addObject("workp", workp);
		mv.addObject("gradelist", grade);
		mv.setViewName("reqtable");
		return mv;
	}
}
