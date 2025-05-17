package com.example.ChatApp_UsingWebSocket.client;

import com.example.ChatApp_UsingWebSocket.Message;
import jdk.jshell.execution.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
//        messagePanel.add(createChatMessageComponent(new Message("Aaggin","What If")));


        // input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(Utilities.addPadding(10,10,10,10));
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBackground(Utilities.TRANSPARENT_COLOR);


        JTextField inputField = new JTextField();
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    String input = inputField.getText();
                    inputField.setText("");

                    // this below is an edge case for when the text input field is empty
                    if(input.isEmpty()){
                        return;
                    }
                    messagePanel.add(createChatMessageComponent(new Message("Aaggin",input)));
                    repaint();
                    revalidate();
                    // these above two functions are needed to refresh the gui for the Swing

                }
            }
        });
        inputField.setBackground(Utilities.SECONDARY_COLOR);
        inputField.setForeground(Utilities.TEXT_COLOR);
        inputField.setFont(new Font("Inter",Font.PLAIN,16));
        inputField.setPreferredSize(new Dimension(inputPanel.getWidth(),50));
        inputPanel.add(inputField,BorderLayout.CENTER);
        chatPanel.add(inputPanel,BorderLayout.SOUTH);



        //adding the chat panel to the mother jframe ie client GUI
        add(chatPanel,BorderLayout.CENTER);


    }

    private void addConnectedUsersComponents(){
        connectedUsersPanel = new JPanel();
        connectedUsersPanel.setBorder(Utilities.addPadding(10,10,10,10));
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

    private JPanel createChatMessageComponent(Message message){
        // this is the panel which will be containing the username , and the chat message
        JPanel chatMessage = new JPanel();
        chatMessage.setBackground(Utilities.TRANSPARENT_COLOR);
        chatMessage.setLayout(new BoxLayout(chatMessage,BoxLayout.Y_AXIS));
        chatMessage.setBorder(Utilities.addPadding(20,20,10,20));

        JLabel userNameLabel = new JLabel(message.getUser());
        userNameLabel.setFont(new Font("Inter",Font.BOLD,18));
        userNameLabel.setForeground(Utilities.TEXT_COLOR);
        chatMessage.add(userNameLabel);

        JLabel messageLabel = new JLabel(message.getMessage());
        messageLabel.setFont(new Font("Inter",Font.PLAIN,18));
        messageLabel.setForeground(Utilities.TEXT_COLOR);
        chatMessage.add(messageLabel);

        return chatMessage;
    }

}
