package org.minesweeper;

import javax.swing.*;

/**
 * TODO write javadoc.
 */
public class FieldButton extends JButton {

    boolean isMine;
    int xPosition;
    int yPosition;

    /**
     * TODO write javadoc.
     */
    public FieldButton(boolean isMine, int xPosition, int yPosition) {
        this.isMine = isMine;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.addActionListener(e -> this.click());
    }

    /**
     * TODO write javadoc.
     */
    public void click() {
        if (isMine) {
            this.setText("M");
        } else {
            this.setText("C");
        }
    }
}
