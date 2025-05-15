package com.example.ChatApp_UsingWebSocket.client;

import com.example.ChatApp_UsingWebSocket.Message;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(ClientGUI.this,"Do you really want to Leave ?", "Exit" , JOptionPane.YES_NO_OPTION );

                if (option == JOptionPane.YES_OPTION){
                    ClientGUI.this.dispose();

                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

    }
}
