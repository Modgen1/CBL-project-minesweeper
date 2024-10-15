package org.minesweeper;

import javax.swing.*;

/**
 * TODO write javadoc.
 */
public class FieldButton extends JButton {

    FieldPanel field;
    boolean isMine;
    int xPosition;
    int yPosition;

    boolean revealed = false;

    /**
     * TODO write javadoc.
     */
    public FieldButton(boolean isMine, int xPosition, int yPosition, FieldPanel field) {
        this.field = field;
        this.isMine = isMine;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.addActionListener(e -> this.click());
    }

    /**
     * TODO write javadoc.
     */
    public void click() {
        if (!this.revealed) {
            this.revealed = true;
            if (isMine) {
                this.field.runtime.loseGame();
            } else {
                int neighbours = checkNeighbours();
                if (neighbours == 0) {
                    revealAround();
                    this.setText("0");
                } else {
                    this.setText(String.valueOf(neighbours));
                }
            }
        }
    }

    /**
     * TODO write javadoc.
     *
     * @return TODO
     */
    int checkNeighbours() {
        int neighbours = 0;
        try {
            if (field.field[xPosition - 1][yPosition - 1].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            if (field.field[xPosition][yPosition - 1].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            if (field.field[xPosition + 1][yPosition - 1].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            if (field.field[xPosition - 1][yPosition].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            if (field.field[xPosition + 1][yPosition].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            if (field.field[xPosition - 1][yPosition + 1].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            if (field.field[xPosition][yPosition + 1].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            if (field.field[xPosition + 1][yPosition + 1].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        return neighbours;
    }

    /**
     * TODO write javadoc.
     */
    void revealAround() {
        try {
            field.field[xPosition - 1][yPosition - 1].click();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            field.field[xPosition][yPosition - 1].click();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            field.field[xPosition + 1][yPosition - 1].click();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            field.field[xPosition - 1][yPosition].click();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            field.field[xPosition + 1][yPosition].click();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            field.field[xPosition - 1][yPosition + 1].click();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            field.field[xPosition][yPosition + 1].click();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            field.field[xPosition + 1][yPosition + 1].click();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
    }
}
