package com.ktj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ktj.entity.Users;
import com.ktj.repository.UserRepository;
import com.ktj.service.EmailService;
import com.ktj.service.UserService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/")
@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@PostMapping("/createUser") // 계정생성
	public String createUser(Users user) {
		userService.createUser(user);
		return "users/login";
	}

	@DeleteMapping("/deleteUser") // 관리자 테이블 유저정보 삭제
	public void deleteCustomer(int userCode) {
		userService.deleteByUserCode(userCode);
	}

	@PutMapping("/updateUser") // 관리자 테이블 유저정보 수정
	public String updateUser(@RequestBody Users user) {
		userService.updateUser(user);
		return "users/admin";
	}

	@PostMapping("/find-password") // 패스워드정보확인용 확인용 문자 메일보내기 메서드
	public String findPassword(@RequestParam String userEmail, Model model) {
		Users user = userRepository.findByUserEmail(userEmail);
		if (user == null) {
			model.addAttribute("error", "User not found");
			return "find-password";
		}
		String password = user.getUserPw();
		emailService.sendPassword(userEmail, password);
		model.addAttribute("message", "Your password has been sent to your email");
		return "users/login";
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
	

	/*
	 * @GetMapping("/findAllUser") public String findAllBoard(Model model) {
	 * model.addAttribute("list", userService.UserAll()); return "admin"; }
	 */

	/*
	 * @PostMapping("/login") // 로그인 public String login(@RequestParam("username")
	 * String userId, @RequestParam("password") String userPw, HttpSession session,
	 * Model model) { // Check userId and userPw if
	 * (userId.equals("your_username_here") && userPw.equals("your_password_here"))
	 * { session.setAttribute("username", userId); return "redirect:/"; } else {
	 * model.addAttribute("error", "Invalid username/password combination"); return
	 * "login"; } }
	 */

}
/*
 * @PutMapping("/updateUser") //수정 public Customer postCustomer(Customer
 * customer) { return repository.save(customer); }
 * 
 * @DeleteMapping("/deleteuser") //삭제 public void deleteCustomer(int id) {
 * repository.deleteById(id); }
 * 
 * @GetMapping("/selectUser") // 개별 id 로 개인조회 public Customer getCustomer(int
 * id) { return repository.findById(id).orElse(null); //값이 있을때는 엔티티제 리턴, 아니면
 * null }
 * 
 * 
 * @GetMapping("/selectUserAll") //사용자 전체조회 public List<Customer>
 * getCustomerList(){ return (List<Customer>) repository.findAll(); //리스트
 * 객체변환을위해 리턴값을 캐스팅처리 }
 */

/*
 * @GetMapping("/customer/name") // 개별 name 으로 개인조회 , 동명이인 있을수있으니 list 로 반환
 * public List<Customer> getCustomer(String name) { return
 * repository.findByName(name);// }
 * 
 * @GetMapping("/customer/search") // public List<Customer>
 * searchCustomer(String name) { return
 * repository.findByNameLike("%"+name+"%");// }
 */
