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
		message.setFrom("Ant@co.kr"); // 발신자 이메일 주소
		message.setTo(to); // 수신자 이메일 주소
		message.setSubject("일개미 사이트에서 비밀번호를 알려드립니다!"); // 이메일 제목
		message.setText("패스워드 " + password); // 이메일 본문
		javaMailSender.send(message); // 이메일 전송
	}
}