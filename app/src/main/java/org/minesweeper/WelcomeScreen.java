package org.minesweeper;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Main menu class of the game that is responsible for setting up all configurations
 * provided by user to prepare for creating a game field.
 * It allows user to change settings that are available for them and then start the game.
 * Available settings are:
 * 1. field width
 * 2. field height
 * 3. amount of mines.
 */
public class WelcomeScreen extends JFrame implements ChangeListener {
    // runtime object that called this screen
    Runtime runtime;

    // three sliders for changing game settings
    static JSlider xSlider;
    static JSlider ySlider;
    static JSlider minesSlider;

    /**
     * Object generator that renders the welcome screen.
     * Creates 3 sliders - sliders for the x-value and y-value of the minefield,
     * and a slider for choosing the number of mines.
     *
     * @param runtime Runtime object which this screen will be attached to.
     *                Used to access and modify variables that are shared between screens.
     */
    public WelcomeScreen(Runtime runtime) {
        // storing runtime in ab object variable so it can be used in other methods
        this.runtime = runtime;

        // screen configuration
        this.setTitle("Minesweeper menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(runtime.screenWidth / 5, runtime.screenHeight / 2);
        this.setLocationRelativeTo(null); // places the window in the middle of the screen
        this.setResizable(false); // restricting resizing in order to avoid rendering bugs

        // creating grid layout for the window
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 0.5;

        // adding label for the field width slider
        constraints.gridy = 0;
        constraints.gridx = 0;
        container.add(new JLabel("Choose field width:"), constraints);

        // adding and configuring slider for changing the field width
        xSlider = new JSlider(12, 44, runtime.xMines);
        xSlider.setPaintTrack(true);
        xSlider.setPaintTicks(true);
        xSlider.setPaintLabels(true);
        xSlider.setMajorTickSpacing(16);
        xSlider.setMinorTickSpacing(4);
        xSlider.setSnapToTicks(true); // to avoid float values of ticks for sliders, enable snapping
        xSlider.addChangeListener(this); // calls stateChanged() after each change in slider value

        constraints.gridx = 1;
        container.add(xSlider, constraints);


        // adding label for the field height slider
        constraints.gridy = 1;
        constraints.gridx = 0;
        container.add(new JLabel("Choose field height:"), constraints);

        // adding and configuring slider for changing the field width
        ySlider = new JSlider(12, 44, runtime.yMines);
        ySlider.setPaintTrack(true);
        ySlider.setPaintTicks(true);
        ySlider.setPaintLabels(true);
        ySlider.setMajorTickSpacing(16);
        ySlider.setMinorTickSpacing(4);
        ySlider.setSnapToTicks(true); // to avoid float values of ticks for sliders, enable snapping
        ySlider.addChangeListener(this); // calls stateChanged() after each change in slider value
        constraints.gridx = 1;
        container.add(ySlider, constraints);

        // adding label for the mines slider
        constraints.gridy = 2;
        constraints.gridx = 0;
        container.add(new JLabel("Choose amount of mines:"), constraints);

        // adding and configuring slider for changing amount of mines
        minesSlider = new JSlider((runtime.xMines * runtime.yMines) / 8,
                (runtime.xMines * runtime.yMines) / 2,
                runtime.mineAmount);
        minesSlider.setPaintTrack(true);
        minesSlider.setPaintTicks(true);
        minesSlider.setPaintLabels(true);
        minesSlider.setMajorTickSpacing(minesSlider.getMaximum() / 4); // always divisible by 4
        minesSlider.setMinorTickSpacing(minesSlider.getMajorTickSpacing() / 4);
        minesSlider.addChangeListener(this);
        constraints.gridx = 1;
        container.add(minesSlider, constraints);

        // creates button for starting a new game with set values of settings
        JButton startButton = new JButton("Start the game");
        startButton.addActionListener(e -> runtime.newGame()); // when button pressed, create game

        // adding it to the frame at the bottom
        constraints.gridy = 3;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridwidth = 2;
        container.add(startButton, constraints);

    }

    /**
     * Event handler for changing values of first two sliders.
     * Adjusts the amount-of-mines slider depending on the chosen variables of the
     * field width and field height.
     * The minimum value of the slider is 1/8 of the area of the minefield,
     * the maximum value is 1/2 of the area of the minefield.
     *
     * @param e Event that caused calling of this method. Handled automatically by Swing.
     */
    public void stateChanged(ChangeEvent e) {
        // firstly we change values in the runtime variables
        this.runtime.xMines = xSlider.getValue();
        this.runtime.yMines = ySlider.getValue();
        this.runtime.mineAmount = minesSlider.getValue();

        // then we adjust boundaries of the third slider according to values of two other sliders
        minesSlider.setMinimum((runtime.xMines * runtime.yMines) / 8);
        minesSlider.setMaximum((runtime.xMines * runtime.yMines) / 2);

        // then we recalculate the spacing for the third slider so it looks good
        minesSlider.setMajorTickSpacing((runtime.xMines * runtime.yMines) / 8);
        minesSlider.setMinorTickSpacing(minesSlider.getMajorTickSpacing() / 4);

        // and finally adjusting labels so they are not moving when adjusting boundaries
        minesSlider.setLabelTable(minesSlider.createStandardLabels(
                (runtime.xMines * runtime.yMines) / 8));
    }
}
