package org.minesweeper;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * TODO write javadoc.
 */
public class WelcomeScreen extends JFrame implements ChangeListener {

    // runtime object that called this screen
    Runtime runtime;

    // three sliders for changing game settings
    static JSlider xSlider;
    static JSlider ySlider;
    static JSlider minesSlider;

    /**
     * TODO write javadoc.
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

        // creating and adding a panel to the frame
        JPanel panel = new JPanel();
        this.add(panel);

        // adding and configuring slider for changing the field width
        xSlider = new JSlider(8, 56, runtime.xMines);
        xSlider.setPaintTrack(true);
        xSlider.setPaintTicks(true);
        xSlider.setPaintLabels(true);
        xSlider.setMajorTickSpacing(16);
        xSlider.setMinorTickSpacing(4);
        xSlider.setSnapToTicks(true); // to avoid float values of ticks for sliders, enable snapping
        xSlider.addChangeListener(this); // calls stateChanged() after each change in slider value

        // adding and configuring slider for changing the field width
        ySlider = new JSlider(8, 56, runtime.yMines);
        ySlider.setPaintTrack(true);
        ySlider.setPaintTicks(true);
        ySlider.setPaintLabels(true);
        ySlider.setMajorTickSpacing(16);
        ySlider.setMinorTickSpacing(4);
        ySlider.setSnapToTicks(true); // to avoid float values of ticks for sliders, enable snapping
        ySlider.addChangeListener(this); // calls stateChanged() after each change in slider value

        //adding and configuring slider for changing amount of mines
        minesSlider = new JSlider((runtime.xMines * runtime.yMines) / 8,
                (runtime.xMines * runtime.yMines) / 2,
                runtime.mineAmount);
        minesSlider.setPaintTrack(true);
        minesSlider.setPaintTicks(true);
        minesSlider.setPaintLabels(true);
        minesSlider.setMajorTickSpacing(minesSlider.getMaximum() / 4); // always divisible by 4
        minesSlider.setMinorTickSpacing(minesSlider.getMajorTickSpacing() / 4);
        minesSlider.addChangeListener(this);

        // creates button for starting a new game with set values of settings
        JButton startButton = new JButton("Start the game");
        startButton.addActionListener(e -> runtime.newGame()); // when button pressed, create game

        // adding all elements to the panel in the right order
        panel.add(new JLabel("Choose field width:"));
        panel.add(xSlider);
        panel.add(new JLabel("Choose field height:"));
        panel.add(ySlider);
        panel.add(new JLabel("Choose amount of mines:"));
        panel.add(minesSlider);
        panel.add(startButton);
    }

    /**
     * TODO write javadoc.
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
