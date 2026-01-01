package com.example.websocket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class CustomWebSocketConfigurer implements WebSocketConfigurer {

    @Autowired
    private CustomWebSocketHandler customWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //CORS
        registry.addHandler(customWebSocketHandler, "/ws/echo").setAllowedOrigins("*");
    }
}
