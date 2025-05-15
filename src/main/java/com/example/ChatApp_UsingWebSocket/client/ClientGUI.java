package com.example.ChatApp_UsingWebSocket.client;

import com.example.ChatApp_UsingWebSocket.Message;

import javax.swing.*;
import java.util.concurrent.ExecutionException;

public class ClientGUI extends JFrame {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        MyStompClient myStompClient = new MyStompClient("Aaggin");
//        myStompClient.sendMessage(new Message("Aggin","Hello World"));
//        myStompClient.disconnectUser("Aaggin");
// this was for testing the client
//    }

    public ClientGUI(String username){
        super("User Name is :" +username);

        setSize(1218,685);
        setLocationRelativeTo(null);

        // By Default the close operation of JFrame is to hide the application and run it in the background
        // and we need to change that . 

    }
}
