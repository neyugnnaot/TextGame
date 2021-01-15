package com.textgame.gui;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    Container pane = getContentPane();

    public GUI() {
        setSize(WIDTH, HEIGHT);
        setTitle("com.textgame.gameloop.Game");
        setVisible(Boolean.TRUE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        pane.setBackground(Color.black);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .5;
        c.gridx = 0;
        c.gridy = 0;
        JButton start = new JButton("Start");
        this.add(start, c);
    }
}
