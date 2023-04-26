package com.Allchat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.Allchat.model.ChatMessage;

/**
 * Created by rajeevkumarsingh on 25/07/17.
 */
@Component
public class WebSocketEventListener {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
	// 이 코드는 org.slf4j.Logger 인터페이스의 정적 변수를 초기화하고 있습니다.

	// oggerFactory.getLogger(Class<T> clazz) 메서드는 전달된 클래스에서 Logger 인스턴스를 반환합니다. 이
	// 경우에는 WebSocketEventListener 클래스의 로거 인스턴스를 반환하고 있습니다.

	/*
	 * 이 로거 인스턴스를 사용하여 해당 클래스에서 로그를 기록할 수 있습니다. 로그는 디버깅, 오류 추적 등에 유용합니다. 예를 들어
	 * logger.info("Received a new web socket connection");는 정보 로그를 남기고
	 * 있습니다.이는"Received a new web socket connection" 문자열을 로그로 출력합니다.
	 */

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	// SimpMessageSendingOperations은 스프링 프레임워크에서 제공하는 인터페이스로, 웹 소켓 클라이언트에게 메시지를 보내기
	// 위한 메소드를 제공합니다.
	// messagingTemplate라는 변수명으로 SimpMessageSendingOperations을 주입받아서 사용하고 있습니다. 즉, 이
	// 변수를 통해 메시지를 보내는 작업을 수행할 수 있습니다.

	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		logger.info("Received a new web socket connection");
	}

	// WebSocket 연결(SessionConnectedEvent)이 이루어질 때마다 실행되는 이벤트 핸들러입니다
	// @EventListener 어노테이션은 이벤트 핸들러 메서드임을 나타냅니다. 메서드 내부에서는 logger 객체를 이용하여 로그를 기록하고
	// 있습니다. 즉, WebSocket 연결 시 로그를 출력하는 기능을 가지고 있습니다.

	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

		String username = (String) headerAccessor.getSessionAttributes().get("username");
		if (username != null) {
			logger.info("User Disconnected : " + username);

			ChatMessage chatMessage = new ChatMessage();
			chatMessage.setType(ChatMessage.MessageType.LEAVE);
			chatMessage.setSender(username);

			messagingTemplate.convertAndSend("/topic/public", chatMessage);
		}
	}
}

//해당 코드는 Spring Boot 웹소켓을 이용하여 사용자의 웹 소켓 연결/끊기 이벤트를 처리하는 WebSocketEventListener 클래스
//채팅방에서 누가 나갔다는것을 메시지로 표현하기위해 있는코드
//결이 끊어진 세션의 사용자 이름을 가져오고, 가져온 사용자 이름을 사용하여 메시지를 생성합니다. 
//그런 다음 messagingTemplate을 사용하여 생성된 메시지를 /topic/public 채널로 브로드캐스팅