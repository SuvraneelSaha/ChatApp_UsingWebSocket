package com.example.ChatApp_UsingWebSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


// spring service component
// bean
@Service
public class WebSocketSessionManager {
    private final ArrayList<String> activeUserNames = new ArrayList<>();
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WebSocketSessionManager(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void addUserName(String username){
        activeUserNames.add(username);
    }
    public void removeUsername(String username){
        activeUserNames.remove(username);
    }

    public void broadcastActiveUsernames(){
        messagingTemplate.convertAndSend("/topic/users",activeUserNames);
        System.out.println("Broadcasting Active users to /topic/users : "+activeUserNames);
    }

}
