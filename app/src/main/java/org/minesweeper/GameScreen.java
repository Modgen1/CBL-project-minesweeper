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
        this.setTitle("Minesweeper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(runtime.screenWidth / 5, runtime.screenHeight / 2);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel panel = new JPanel();
        this.add(panel);
    }
}
