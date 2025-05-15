package com.example.ChatApp_UsingWebSocket.client;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            ClientGUI clientGUI = new ClientGUI("Aaggin");
            clientGUI.setVisible(true);
            // this should be at last and should not be related to that of the client
                // as the app must load all the things like client then only display it
                // IMP - First GUI then users and all


            }
        });
    }
}
