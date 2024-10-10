package org.minesweeper;

import javax.swing.*;

/**
 * TODO write javadoc.
 */
public class WelcomeScreen extends JFrame{

    /**
     * TODO write javadoc.
     * @param runtime TODO
     */
    public WelcomeScreen(Runtime runtime) {
        this.setTitle("Minesweeper menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(runtime.screenWidth / 5, runtime.screenHeight / 2);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel panel = new JPanel();
        this.add(panel);

        JButton startButton = new JButton("Start the game");
        startButton.addActionListener(e -> runtime.newGame());
        panel.add(startButton);
    }
}
