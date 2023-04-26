package com.Allchat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").withSockJS();
	} // WebSocket 연결을 등록하는 데 사용되는 메소드입니다.
		// StompEndpointRegistry는 WebSocket 연결을 등록하는 데 사용되는 객체입니다.
		/// ws 엔드포인트를 등록하고, SockJS 지원을 활성화하는 코드입니다.

	// withSockJS()는 SockJS 지원을 활성화하는 메소드입니다. SockJS는 WebSocket을 지원하지 않는 브라우저에서도 사용할
	// 수 있는 대체 프로토콜을 제공하여 웹소켓의 호환성 문제를 해결합니다.

	/*
	 * 따라서,registry.addEndpoint("/ws").withSockJS()코드는/ws 엔드포인트를 등록하고, SockJS 지원을
	 * 활성화하여 WebSocket 연결을 사용하는 클라이언트 브라우저의 호환성을 보장합니다.
	 */

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableSimpleBroker("/topic"); // Enables a simple in-memory broker
	}

	// 해당 메소드는 Spring WebSocket의 메시지 브로커를 설정하는 역할을 합니다.

	// MessageBrokerRegistry 객체를 사용하여 /app과 같은 애플리케이션 목적지 접두사와 /topic과 같은 대상 주제를 등록할
	// 수 있습니다.

	// setApplicationDestinationPrefixes() 메소드는 애플리케이션 목적지의 접두사를 설정하는 데 사용됩니다. 이
	// 목적지에 대한 메시지는 @MessageMapping 주석이 지정된 메소드와 연결되며, 해당 메소드에서 처리됩니다.

	// enableSimpleBroker() 메소드는 대상 주제를 등록하고, 인메모리 브로커를 활성화합니다. 이 브로커를 통해 애플리케이션에서
	// 발행한 메시지를 구독하는 클라이언트에게 전송됩니다.

	// 즉, configureMessageBroker() 메소드는 애플리케이션 목적지와 대상 주제를 설정하고, 메시지 브로커를 활성화하는 데
	// 사용됩니다. 이를 통해 Spring WebSocket을 사용하여 클라이언트 간의 실시간 메시지 전송을 구현할 수 있습니다.

}
