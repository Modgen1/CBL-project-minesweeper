package org.minesweeper;

import javax.swing.*;

public class WelcomeScreen extends JFrame{

    public WelcomeScreen(Runtime runtime) {
        this.setTitle("Minesweeper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(runtime.SCREEN_WIDTH / 5, runtime.SCREEN_HEIGHT / 2);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel panel = new JPanel();
        this.add(panel);

        JButton startButton = new JButton("Start the game");
        startButton.addActionListener(e -> runtime.newGame());
        panel.add(startButton);
    }
}
