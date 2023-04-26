package com.mvc.jpa.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.mvc.grade.GradeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
	@Autowired
	private UserService service;
	@Autowired
	private GradeService gradeservice;
	@Autowired
	private EmailService emailService;
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/createUser") // 계정생성
	public String createUser(UserDTO user) {
		service.createUser(user);
		return "/users/login";
	}

	@DeleteMapping("/deleteUser") // 관리자 테이블 유저정보 삭제
	public void deleteCustomer(int userCode) {
		service.deleteByUserCode(userCode);
	}
	
	@GetMapping("/deleteuserbyself")
	public String deleteUserBySelf(int userCode) {
		service.deleteByUserCode(userCode);
		 return "/users/login";
	}
	@RequestMapping("/addImg")
	public ModelAndView addImg(int userCode, MultipartFile file, Model m) throws IllegalStateException, IOException {
		ModelAndView mv = new ModelAndView();
		service.addImg(userCode, file);
		UserDTO dto = service.read(userCode);
		mv.addObject("dto",dto);
		mv.addObject("avgGrade", gradeservice.avgGrade(userCode));
		mv.setViewName("/user/mypage_dash :: #users");
		return mv;

	}

	@PutMapping("/updateUser") // 관리자 테이블 유저정보 수정
	public String updateUser(@RequestBody Users user) {
		service.updateUser(user);
		return "/users/admin";
	}
	
	
	@PostMapping(value ="/updateUserbyU", produces="application/json") // 유저 유저정보 수정
	@ResponseBody
	public void updateUserbyU(@RequestParam Users user) {
		System.out.println(user.getUserEmail());
		log.info(user);
		service.updateUser(user);
	}
	@GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login"; // 로그인 페이지로 리다이렉트
    }

 @GetMapping("/naverlogout")
    public String naverlogout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login"; // 로그인 페이지로 리다이렉트
    }

	
	@PostMapping("/mypage")
	public String mypage_dash(Model m, HttpSession session) {
        Users user = (Users) session.getAttribute("user");
		UserDTO dto = service.read(user.getUserCode());
		m.addAttribute("dto", dto);
		m.addAttribute("avgGrade", gradeservice.avgGrade(user.getUserCode()));
		return "/mypage_dash";
	}
	
	
	  @PostMapping(value = "/updateReg", produces = "application/json")
	  
	  @ResponseBody public void updateReg(@RequestParam Map<String, Object> param)
	  { log.info("updatereg 실행"); log.info(param.get("Code"));
	  service.updateReg(Integer.parseInt((String) param.get("Code")),
	  (String)param.get("userRegion")); }
	 
	@RequestMapping("/updateReg")
	public ModelAndView updateReg1(int userCode, String userRegion, Model m) {
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
	public ModelAndView updateAnother1(int userCode, String userNickName, String userEmail, String userPw, String userPhone, Model m) {
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
		Users user = userRepository.findByUserEmail(userEmail);
		if (user == null) {
			model.addAttribute("error", "User not found");
			return "/find-password";
		}
		String password = user.getUserPw();
		emailService.sendPassword(userEmail, password);
		model.addAttribute("message", "Your password has been sent to your email");
		return "/users/login";
	}
	
//	  @GetMapping("/test") public String test(long userCode, MultipartFile file)
//	  throws IllegalStateException, IOException { service.addImg(userCode, file);
//	  return "/user/tablerequest"; }
	 
}
