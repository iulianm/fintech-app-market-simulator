package com.fintech.marketsimulator.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // Stomp ENDPOINT
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/market-start").setAllowedOrigins("*").withSockJS();
        System.out.println("STOMP endpoint was created");
    }

    // This is the BROKER where we want to push messages to
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        System.out.println("TOPIC was created");
        registry.setApplicationDestinationPrefixes("/app");
        System.out.println("APP was registered");
    }
}