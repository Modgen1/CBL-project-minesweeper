package org.minesweeper;

import java.awt.*;
import java.awt.event.*;
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
    boolean flagged = false;

    /**
     * TODO write javadoc.
     */
    public FieldButton(boolean isMine, int xPosition, int yPosition, FieldPanel field) {
        this.field = field;
        this.isMine = isMine;
        this.xPosition = xPosition;
        this.yPosition = yPosition;

        this.setPreferredSize(field.size);
        this.setMargin(field.margin);
        this.setFont(field.font);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    leftClick();
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    rightClick();
                }
            }
        });
    }

    /**
     * TODO write javadoc.
     */
    public void leftClick() {
        if (!this.revealed) {
            this.field.revealed++;
            this.revealed = true;
            this.setBackground(Color.white);
            if (isMine) {
                this.field.runtime.loseGame();
            } else {
                int neighbours = checkNeighbours();
                if (neighbours == 0) {
                    revealAround();
                    this.setText(" ");
                } else {
                    this.setText(String.valueOf(neighbours));
                }
            }
            if (this.field.revealed >= this.field.xMines * this.field.yMines
                    - this.field.mineAmount) {
                this.field.runtime.winGame();
            }
        }
    }

    /**
     * TODO write javadoc.
     */
    public void rightClick() {
        if (!this.revealed && !this.flagged) {
            this.flagged = true;
            this.setText("F");
        } else if (!this.revealed) {
            this.flagged = false;
            this.setText("");
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
            field.field[xPosition - 1][yPosition - 1].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            field.field[xPosition][yPosition - 1].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            field.field[xPosition + 1][yPosition - 1].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            field.field[xPosition - 1][yPosition].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            field.field[xPosition + 1][yPosition].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            field.field[xPosition - 1][yPosition + 1].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            field.field[xPosition][yPosition + 1].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            field.field[xPosition + 1][yPosition + 1].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
    }
}
