package org.minesweeper;

import javax.swing.*;

/**
 * The main screen that contains all the gameplay.
 */
public class GameScreen extends JFrame{

    /**
     * Main gameplay. Creates a window that contains the game with the settings from
     * the welcome screen. Calls a win screen or a lose screen depending on the outcome
     * of the game.
     * @param runtime object of Runtime for this screen to access information from Runtime.java
     */
    public GameScreen(Runtime runtime) {
        this.setTitle("Minesweeper game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(runtime.screenWidth / 5, runtime.screenHeight / 2);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel panel = new JPanel();
        this.add(panel);

        JButton winButton = new JButton("Win the game");
        winButton.addActionListener(e -> runtime.winGame());
        panel.add(winButton);

        JButton loseButton = new JButton("Lose the game");
        loseButton.addActionListener(e -> runtime.loseGame());
        panel.add(loseButton);
    }
}
