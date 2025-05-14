package com.example.ChatApp_UsingWebSocket.client;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MyStompClient {
    private StompSession session;
    private String username;

    public MyStompClient(String username) throws ExecutionException, InterruptedException {
        this.username=username;

        List<Transport> transports = new ArrayList<>();
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));

        SockJsClient sockJsClient = new SockJsClient(transports);
        WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
        // this can use the stomp protocol ;
        // SockJsClient in of itself cannot interact with the stomp protocol
        // so for which it needs WebSocketStompClient to interact with the Stomp Protocol

        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        // this class or library class MappingJackson helps to serialize and deserialize java objects
        // when we send the data to the websocket stomp server ;
        // we need to send it in a json format , here it is doing that for us so
        // we no longer need to manually serialize amd deserialize the java objects when sending and receiving the java objects reespectively


        StompSessionHandler sessionHandler = new MyStompSessionHandler(username);
        String url = "ws://localhost:8080/ws";
        // use ws for web socket
        // now we will be connecting the session to our web socket server

        session = stompClient.connectAsync(url,sessionHandler).get();


    }
}
