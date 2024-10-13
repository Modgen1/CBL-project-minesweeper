package org.minesweeper;

import javax.swing.*;

/**
 * TODO write javadoc.
 */
public class LoseScreen extends JFrame {

    /**
     * TODO write javadoc.
     * @param runtime TODO
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
