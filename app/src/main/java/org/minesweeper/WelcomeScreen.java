package org.minesweeper;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * TODO write javadoc.
 */
public class WelcomeScreen extends JFrame implements ChangeListener {

    Runtime runtime;
    static JSlider xSlider;
    static JSlider ySlider;
    static JSlider minesSlider;

    /**
     * TODO write javadoc.
     * @param runtime TODO
     */
    public WelcomeScreen(Runtime runtime) {
        //
        this.runtime = runtime;

        //
        this.setTitle("Minesweeper menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(runtime.screenWidth / 5, runtime.screenHeight / 2);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //
        JPanel panel = new JPanel();
        this.add(panel);

        //
        xSlider = new JSlider(8, 72, runtime.xMines);
        xSlider.setPaintTrack(true);
        xSlider.setPaintTicks(true);
        xSlider.setPaintLabels(true);
        xSlider.setMajorTickSpacing(16);
        xSlider.setMinorTickSpacing(4);
        xSlider.setSnapToTicks(true);
        xSlider.addChangeListener(this);

        //
        ySlider = new JSlider(8, 72, runtime.yMines);
        ySlider.setPaintTrack(true);
        ySlider.setPaintTicks(true);
        ySlider.setPaintLabels(true);
        ySlider.setMajorTickSpacing(16);
        ySlider.setMinorTickSpacing(4);
        ySlider.setSnapToTicks(true);
        ySlider.addChangeListener(this);

        //
        minesSlider = new JSlider((runtime.xMines * runtime.yMines) / 8,
                (runtime.xMines * runtime.yMines) / 2,
                runtime.mineAmount);
        minesSlider.setPaintTrack(true);
        minesSlider.setPaintTicks(true);
        minesSlider.setPaintLabels(true);
        minesSlider.setMajorTickSpacing(minesSlider.getMaximum() / 4);
        minesSlider.setMinorTickSpacing(minesSlider.getMajorTickSpacing() / 4);
        minesSlider.addChangeListener(this);

        //
        JButton startButton = new JButton("Start the game");
        startButton.addActionListener(e -> runtime.newGame());

        //
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
     * @param e TODO
     */
    public void stateChanged(ChangeEvent e) {
        //
        this.runtime.xMines = xSlider.getValue();
        this.runtime.yMines = ySlider.getValue();
        this.runtime.mineAmount = minesSlider.getValue();

        //
        minesSlider.setMinimum((runtime.xMines * runtime.yMines) / 8);
        minesSlider.setMaximum((runtime.xMines * runtime.yMines) / 2);

        //
        minesSlider.setMajorTickSpacing((runtime.xMines * runtime.yMines) / 8);
        minesSlider.setMinorTickSpacing(minesSlider.getMajorTickSpacing() / 4);

        //
        minesSlider.setLabelTable(minesSlider.createStandardLabels(
                (runtime.xMines * runtime.yMines) / 8));
    }
}
