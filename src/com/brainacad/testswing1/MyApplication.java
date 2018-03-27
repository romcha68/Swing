package com.brainacad.testswing1;

 import javax.swing.*;
 import java.awt.*;
 import java.io.IOException;

/**
 * Created by User on 27.03.2018.
 */
public class MyApplication {
    private JFrame frame = new JFrame();
    private String[] programs = {"Calculator", "Notepad"};


    public MyApplication(String title) {
        frame.setTitle(title);
        frame.setSize(400, 200);
        frame.setLocation(550, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createControlsRun() {
        JLabel label = new JLabel("Run a Program");
        JComboBox comboBox = new JComboBox(programs);
        JButton button = new JButton("Run");

        button.addActionListener((e) -> {
            try {
                if (comboBox.getSelectedItem().equals("Calculator")) {
                    Runtime.getRuntime().exec("calc.exe");
                }
                if (comboBox.getSelectedItem().equals("Notepad")) {
                    Runtime.getRuntime().exec("notepad.exe");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(label);
        frame.add(comboBox);
        frame.add(button);

        frame.pack();
        frame.setVisible(true);
    }
}
