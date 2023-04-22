package com.ktj.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ktj.entity.Users;
import com.ktj.repository.UserRepository;
import com.ktj.service.UserService;

@Controller
public class LoginController {
 
    @Autowired
    private UserRepository userRepository;
 
    @GetMapping("/login")
    public String index() {
        return "users/login";
    }
 
    @PostMapping("/login")
    public String login(@RequestParam String userId,
                        @RequestParam String userPw,
                        HttpSession session) {
 
        // 사용자 ID와 비밀번호를 사용하여 데이터베이스에서 사용자를 찾습니다.
        Users user = userRepository.findByUserIdAndUserPw(userId, userPw);
 
        if (user != null && user.getUserId().equals("admin")) {
            return "redirect:/admin";
        } else if (user == null) {
            // 로그인 실패 시 로그인 페이지로 다시 이동합니다.
            return "redirect:/login";
        } else {
            // 로그인 성공 시 세션에 사용자 정보를 저장합니다.
            session.setAttribute("user", user);
            String userNickName = user.getUserNickName();
            session.setAttribute("userNickName", userNickName); 
            session.removeAttribute("naver_id_login"); // 네이버 로그인용 세션을 제거합니다.
            return "redirect:/main";
        }

    }
 
    @GetMapping("/main")
    public String home(HttpSession session) {
 
        // 세션에서 사용자 정보를 가져옵니다.
        Users user = (Users) session.getAttribute("user");
 
        // 세션에 사용자 정보가 없으면 로그인 페이지로 이동합니다.
        if (user == null) {
            return "redirect:/login";
        }
   	 System.out.println("현재 로그인한 사용자 ID: " + user.getUserId());
     System.out.println("현재 로그인한 사용자 이름: " + user.getUserPw());
 
        return "/main";
    }
 
}