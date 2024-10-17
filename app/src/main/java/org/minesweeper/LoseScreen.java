package org.minesweeper;

import javax.swing.*;

/**
 * Mechanics of the lose screen.
 */
public class LoseScreen extends JFrame {

    /**
     * Renders a lose screen window.
     * User can press a button to go back to the main menu, to restart the game,
     * or to exit the game.
     * @param runtime object of Runtime for this screen to access information from Runtime.java
     */
    public LoseScreen(Runtime runtime) {
        this.setTitle("You lost!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(runtime.screenWidth / 5, runtime.screenHeight / 2);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel panel = new JPanel();
        this.add(panel);

        JButton startButton = new JButton("Back to menu");
        startButton.addActionListener(e -> runtime.mainMenu());
        panel.add(startButton);

        JButton newGameButton = new JButton("Start the new game");
        newGameButton.addActionListener(e -> runtime.newGame());
        panel.add(newGameButton);

        JButton exitButton = new JButton("Exit the game");
        exitButton.addActionListener(e -> System.exit(0));
        panel.add(exitButton);
    }
}
