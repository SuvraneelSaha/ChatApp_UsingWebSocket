package com.example.ChatApp_UsingWebSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {

    private final SimpleMessagingTemplate messagingTemplate;

    @Autowired
    public WebsocketController(SimpleMessagingTemplate messagingTemplate){
        this.messagingTemplate = messagingTemplate ;

    }

    @MessageMapping("/message")
    public void handleMessage(Message message){
        System.out.println("Received message from User: "+message.getUser() + ": " + message.getMessage());
        messagingTemplate.convertAndSend("/topic/messages",message);
        System.out.println("Sent message to /topic/messages: " + message.getUser() + ": "+message.getMessage());
    }

}
