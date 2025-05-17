package com.example.ChatApp_UsingWebSocket.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ClientGUI extends JFrame {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        MyStompClient myStompClient = new MyStompClient("Aaggin");
//        myStompClient.sendMessage(new Message("Aggin","Hello World"));
//        myStompClient.disconnectUser("Aaggin");
// this was for testing the client
//    }

    private JPanel connectedUsersPanel,messagePanel;
    // its a div - jPanel
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

        getContentPane().setBackground(Utilities.PRIMARY_COLOR);

        addGUIComponents();
    }
    private void addGUIComponents(){
        addConnectedUsersComponents();
        addChatComponents();

    }

    private void addChatComponents() {
        JPanel chatPanel = new JPanel();
        // default layout of Jpanel is ?
        chatPanel.setLayout(new BorderLayout());
        chatPanel.setBackground(Utilities.TRANSPARENT_COLOR);

        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel,BoxLayout.Y_AXIS));
        messagePanel.setBackground(Utilities.TRANSPARENT_COLOR);
        chatPanel.add(messagePanel,BorderLayout.CENTER);

        // for testing -
        JLabel message = new JLabel("Random Text");
        message.setFont(new Font("Inter",Font.BOLD,18));
        message.setForeground(Utilities.TEXT_COLOR);
        messagePanel.add(message);


        //adding the chat panel to the mother jframe ie client GUI
        add(chatPanel,BorderLayout.CENTER);


    }

    private void addConnectedUsersComponents(){
        connectedUsersPanel = new JPanel();
        connectedUsersPanel.setLayout(new BoxLayout(connectedUsersPanel,BoxLayout.Y_AXIS));
        // JPanel 's Default layout is FlowLayout
        // BorderLayout (Default for JFrame)
        connectedUsersPanel.setBackground(Utilities.SECONDARY_COLOR);
        connectedUsersPanel.setPreferredSize(new Dimension(200,getHeight()));
        // getheight() -- method for the height to fetch from the mother JFrame ;

        JLabel connectedUsersLabel = new JLabel("Connected Users");
        connectedUsersLabel.setFont(new Font("Inter",Font.BOLD,18));
        connectedUsersLabel.setForeground(Utilities.TEXT_COLOR);
        connectedUsersPanel.add(connectedUsersLabel);

        // now below - we are adding the panel to the GUI
        add(connectedUsersPanel,BorderLayout.WEST);
    }

}
