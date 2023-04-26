package com.Allchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.Allchat.model.ChatMessage;
import com.Allchat.model.Messagerepo;
import com.Allchat.service.MessageRepositoryService;

/**
 * Author Damiano Belliazzi on 10/04/2020
 */
@Controller
@Transactional

public class ChatController {
	@Autowired
	MessageRepositoryService mr;

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		try {
			mr.save(new Messagerepo(chatMessage.getContent(), chatMessage.getSender()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return chatMessage;
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		// aggiungi user name nella chat web socket
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

}

//해당 코드는 WebSocket을 이용한 채팅 어플리케이션에서 클라이언트로부터 수신된 메시지를 처리하는 기능을 담당하는 ChatController 클래스입니다.

/*
 * @Controller 어노테이션은 해당 클래스가 Spring Framework에서 제공하는 Controller 역할을 한다는 것을
 * 의미합니다.@Transactional 어노테이션은 해당 클래스 내에서 수행되는 모든 메소드에 대해 트랜잭션 처리를 하겠다는 것을
 * 선언합니다.
 * 
 * @Autowired 어노테이션을 이용하여 MessageRepositoryService를 주입합니다.
 * 
 * @MessageMapping 어노테이션은 클라이언트가 특정 메시지를 서버로 전송할 때 매핑되는 URI를
 * 지정합니다./chat.sendMessage는 클라이언트에서 메시지 전송 시 호출됩니다./chat.addUser는 클라이언트에서 채팅방 입장
 * 시 호출됩니다.
 * 
 * @SendTo 어노테이션은 메시지 핸들러의 반환 값을 해당 주소로 전송합니다.
 * 
 * @Payload 어노테이션은 수신된 메시지의 body를 추출합니다.
 * 
 * ChatMessage 객체를 이용하여 메시지의 정보를 저장합니다.save() 함수를 이용하여 메시지를 DB에 저장합니다.
 * 
 * SimpMessageHeaderAccessor는 WebSocket 메시지의 헤더 정보를 가지고 있는 객체입니다.addUser()
 * 메소드에서는 SimpMessageHeaderAccessor 객체를 이용하여 채팅방에 입장한 사용자를 저장합니다 .
 */