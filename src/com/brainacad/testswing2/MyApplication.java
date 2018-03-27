package com.brainacad.testswing2;

 import javax.swing.*;
 import java.awt.*;

public class MyApplication extends JFrame {
    private JFrame frame = new JFrame();
    JTextField resultTextField;

    public MyApplication(String title) {
        frame.setTitle(title);
        frame.setSize(400, 200);
        frame.setLocation(550, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void createForm() {
        frame.setLayout(new GridLayout(4, 1, 100, 10));
        GridBagLayout layout = new GridBagLayout();

        JPanel namePanel = new JPanel(layout);
        JPanel resultPanel = new JPanel(layout);
        JPanel compPanel = new JPanel(layout);

        frame.add(namePanel);
        frame.add(resultPanel);
        frame.add(compPanel);

        JTextField userNameTextField = new JTextField(10);
        userNameTextField.setPreferredSize(new Dimension(400, 40));
        JButton buttonGetUserName = new JButton("Get_User_Name");
        namePanel.add(userNameTextField);
        namePanel.add(buttonGetUserName);

        JLabel resultLabel = new JLabel("Result: ");
        resultTextField = new JTextField();
        resultTextField.setPreferredSize(new Dimension(300, 40));
        resultPanel.add(resultLabel);
        resultPanel.add(resultTextField);

        JTextField compNameTextField = new JTextField(10);
        compNameTextField.setPreferredSize(new Dimension(400, 40));
        JButton buttonGetCompName = new JButton("Get_Comp_Name");
        compPanel.add(compNameTextField);
        compPanel.add(buttonGetCompName);

        buttonGetUserName.addActionListener((e) -> compNameTextField.setText(userNameTextField.getText()));
        buttonGetCompName.addActionListener((e) -> userNameTextField.setText(compNameTextField.getText()));

        frame.pack();
    }

    public void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(250, 20));
        frame.add(menuBar);

        JMenu menu = new JMenu("Message");
        menuBar.add(menu);

        JMenuItem questionItem = new JMenuItem("Question");
        questionItem.addActionListener((e) -> {
            String answer = JOptionPane.showInputDialog("Are you ready to undergo the test?");
            resultTextField.setText(answer);
            frame.requestFocus();
        });
        menu.add(questionItem);

        JMenuItem inputNameItem = new JMenuItem("Input name");
        inputNameItem.addActionListener((e) -> {
            String name = JOptionPane.showInputDialog("Input name");
            resultTextField.setText(name);
            frame.requestFocus();
        });
        menu.add(inputNameItem);
    }

}
