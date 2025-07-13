package com.example.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Configuration
public class CustomWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("CustomWebSocketHandler.afterConnectionEstablished");

        System.out.println("session : " + session);
        System.out.println("ip : " + session.getRemoteAddress());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("CustomWebSocketHandler.afterConnectionClosed");
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println("CustomWebSocketHandler.handleMessage");
        System.out.println("message: " + message.getPayload());

        TextMessage textMessage = new TextMessage("return : " + message.getPayload());
        session.sendMessage(textMessage);
    }
}
