package org.minesweeper;

import javax.swing.*;

/**
 * TODO write javadoc.
 */
public class GameScreen extends JFrame{

    /**
     * TODO write javadoc.
     * @param runtime TODO
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
