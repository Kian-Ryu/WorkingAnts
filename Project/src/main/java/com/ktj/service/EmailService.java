package com.ktj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender; // 이메일 비밀번호 찾기용

	public void sendPassword(String to, String password) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("your-email@example.com"); // 발신자 이메일 주소
		message.setTo(to); // 수신자 이메일 주소
		message.setSubject("Your Password"); // 이메일 제목
		message.setText("Your password is " + password); // 이메일 본문
		javaMailSender.send(message); // 이메일 전송
	}
}