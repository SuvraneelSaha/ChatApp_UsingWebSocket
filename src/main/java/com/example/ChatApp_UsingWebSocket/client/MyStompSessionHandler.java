package com.example.ChatApp_UsingWebSocket.client;

import com.example.ChatApp_UsingWebSocket.Message;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

public class MyStompSessionHandler extends StompSessionHandlerAdapter {

    private String userName ;

    public MyStompSessionHandler(String userName){
        this.userName = userName;
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        System.out.println("Client Connected");
        session.send("/app/connect",userName);
        session.subscribe("/topic/messages", new StompFrameHandler() {
            @Override
            public Type getPayloadType(StompHeaders headers) {
                return Message.class;
            }

            @Override
            public void handleFrame(StompHeaders headers, Object payload) {
                try{
                    if(payload instanceof Message){
                        Message message = (Message) payload;
                        System.out.println("Received message : " + message.getUser() + " : " + message.getMessage());
                    }
                    else {
                        System.out.println("Received unexpected payload type : " + payload.getClass());
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        System.out.println("Client Subscribe to /topic/messages");
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        exception.printStackTrace();
    }
}
