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
        this.setSize(runtime.screenWidth, runtime.screenHeight);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel mainPanel = new JPanel();
        this.add(mainPanel);

        FieldPanel field = new FieldPanel(
                runtime.xMines, runtime.yMines, runtime.mineAmount, runtime);
        mainPanel.add(field);
    }
}
