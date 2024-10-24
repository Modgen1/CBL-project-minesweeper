package org.minesweeper;

import java.awt.*;
import javax.swing.*;

/**
 * Mechanics of the defeat screen.
 * Renders a defeat screen window with three available options for the user.
 * Player can go back to main menu to change settings, restart the game with the same settings,
 * or to exit the game.
 */
public class LoseScreen extends JFrame {
    /**
     * Object generator that configures the screen and handles panel rendering with all
     * button objects within this panel.
     *
     * @param runtime Runtime object which this screen will be attached to.
     *                Used to access and modify variables that are shared between screens.
     */
    public LoseScreen(Runtime runtime) {
        // screen configuration
        this.setTitle("Minesweeper game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(runtime.screenWidth / 5, runtime.screenHeight / 2);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // creating and adding a panel to the frame
        JPanel panel = new JPanel();
        this.add(panel, BorderLayout.NORTH);

        JLabel label = new JLabel("You lost!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(48f));
        panel.add(label);

        JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.add(flow, BorderLayout.SOUTH);

        // creating and attaching a button for exiting to main menu
        JButton startButton = new JButton("Back to menu");
        startButton.addActionListener(e -> runtime.mainMenu());
        flow.add(startButton);

        // creating and attaching a button for starting a new game
        JButton newGameButton = new JButton("Start new game");
        newGameButton.addActionListener(e -> runtime.newGame());
        flow.add(newGameButton);

        // creating and attaching a button for exiting the program
        JButton exitButton = new JButton("Exit the game");
        exitButton.addActionListener(e -> System.exit(0));
        flow.add(exitButton);
    }
}
