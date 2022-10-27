package com.griffty.Launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private User user;
    private final Dimension windowSize;
    private final Font TopFont = new Font("comic sans ms", Font.BOLD, 30);
    private final Font buttonFont = new Font("comic sans ms", Font.BOLD, 20);
    private final Font mainTextFont = new Font(Font.DIALOG, Font.BOLD, 20);
    private JFrame profileChooser;
    public Login(Dimension windowSize, User user, JFrame profileChooser) {
        this.profileChooser = profileChooser;
        this.user = user;
        this.windowSize = windowSize;
        initGUI();
        setTitle("Sign in");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initGUI(){
        JPanel mainPanel = new JPanel();
        int width = (int) windowSize.getWidth();
        int height = (int) windowSize.getHeight();
        mainPanel.setPreferredSize(new Dimension(width/2, height/2));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);
        JLabel TopLabel = new JLabel("Sign in");
        TopLabel.setFont(TopFont);
        TopLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(TopLabel);
        mainPanel.add(Box.createVerticalGlue());
        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.Y_AXIS));
        mainPanel.add(usernamePanel);
        JLabel usernameLabel = new JLabel("Username: " + user.getName());
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameLabel.setFont(mainTextFont);
        usernamePanel.add(usernameLabel);
        JPanel passPanel = new JPanel();
        passPanel.setLayout(new BoxLayout(passPanel, BoxLayout.Y_AXIS));
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(passPanel);
        JLabel passLabel = new JLabel("Password:");
        passLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passLabel.setFont(mainTextFont);
        passPanel.add(passLabel);
        JTextField passTextField = new JTextField();
        passTextField.setMaximumSize(new Dimension(width/3, height/10));
        passPanel.add(passTextField);
        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component parent = (Component) e.getSource();
                System.out.println(user.getPass());
                if (passTextField.getText().equals(user.getPass())){
                    new GameMenu();
                    profileChooser.dispose();
                    dispose();
                }else {
                    String message = "Wrong pass, try again";
                    JOptionPane.showMessageDialog(parent, message);
                }

            }
        });
        continueButton.setFont(buttonFont);
        continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(continueButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

    }
}