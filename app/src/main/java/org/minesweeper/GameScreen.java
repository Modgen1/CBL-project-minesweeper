package org.minesweeper;

import javax.swing.*;

/**
 * The main gameplay screen that it is responsible for rendering the game panels.
 */
public class GameScreen extends JFrame{
    /**
     * Object generator that configures the screen and handles panel rendering with all
     * its appropriate logic.
     *
     * @param runtime Runtime object which this screen will be attached to.
     *                Used to access and modify variables that are shared between screens.
     */
    public GameScreen(Runtime runtime) {
        // screen configuration
        this.setTitle("Minesweeper game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(runtime.screenWidth, runtime.screenHeight);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // creating a panel containing game field and adding it to the frame
        FieldPanel field = new FieldPanel(runtime);
        this.add(field);
    }
}
