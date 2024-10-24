package org.minesweeper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class that extends JButton class in order to implement cell of the minesweeper field.
 * Adds functionality of left click with revealing amount of mines around and right click
 * showing a flag that indicates that user thinks there is a mine under the cell.
 */
public class FieldButton extends JButton {
    // object variables that are passed to the generator
    FieldPanel field; // field object that called generation of this cell
    int xPosition; // integer horizontal position of this cell ob the field
    int yPosition; // integer vertical position of thi cell on the field

    // internal boolean variables that are determining state of this cell
    boolean isMine = false; // whether this cell has a mine
    boolean revealed = false; // whether the user already have pressed this cell
    boolean flagged = false; // whether there is a flag on this cell

    /**
     * Object generator that configures the cell and adds mouse listener that calls methods
     * depending on what mouse button user clicks.
     */
    public FieldButton(int xPosition, int yPosition, FieldPanel field) {
        // assigning passed parameters to the object variables
        this.field = field;
        this.xPosition = xPosition;
        this.yPosition = yPosition;

        // configuring look of the cell according to field values
        this.setPreferredSize(field.size);
        this.setMargin(field.margin);
        this.setFont(field.font);

        // adding event listener that is called every time user clicks on the cell
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // if cell is clicked with left mouse button
                if (e.getButton() == MouseEvent.BUTTON1) {
                    leftClick();
                // else if cell is clicked with right mouse button
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    rightClick();
                }
            }
        });
    }

    /**
     * Method that implements logic of left mouse button click.
     * Does nothing if cell is already revealed or if it is flagged,
     * otherwise reveals it showing whether it has mine.
     * If it does not, then shows how many neighbouring cells da have them.
     * If no neighbours have mines, then all these cells are also revealed.
     */
    public void leftClick() {
        // if the cell was not already revealed
        if (!this.revealed && !this.flagged) {
            // adding one to the counter of revealed cells in the field
            this.field.revealed++;
            // setting the cell as revealed
            this.revealed = true;
            this.setBackground(Color.white);
            // if the cell contains mine, user loses
            if (isMine) {
                this.field.runtime.loseGame();
            } else {
                // checking how many surrounding cells have mines in them
                int neighbours = checkNeighbours();
                // if there are no mines around, reveal all cells around this one
                if (neighbours == 0) {
                    revealAround();
                    this.setText(" ");
                // else show the amount of cells around that have mines
                } else {
                    this.setText(String.valueOf(neighbours));
                }
            }
            // if all non-mine cells are revealed, user wins
            if (this.field.revealed >= this.field.xMines * this.field.yMines
                    - this.field.mineAmount) {
                this.field.runtime.winGame();
            }
        }
    }

    /**
     * Method that implements the logic of right mouse button click.
     * Works only on non-revealed cells - if user clicks with right mouse button,
     * he sets a flag on this mine indicating that they think there is a mine under the flag.
     * With the next right click on the flagged cell, flag is removed.
     */
    public void rightClick() {
        // if cell is not revealed and there is no flag, put flag
        if (!this.revealed && !this.flagged) {
            this.flagged = true;
            this.setText("F");
        // else if it has flag, remove it
        } else if (!this.revealed) {
            this.flagged = false;
            this.setText("");
        }
    }

    /**
     * Method that checks amount of neighbouring cells that do have mines under them.
     * This method is shown as too deeply nested, but it does the same check for 8 different
     * neighbours so it cannot be much simplified.
     * Catch part is also only required by the checkstyle as it does not allow to leave blank
     * brackets so we had to put assert true into them which basically does nothing.
     *
     * @return integer amount of neighbouring cells that have mine in them
     */
    int checkNeighbours() {
        int neighbours = 0;
        try {
            // top left neighbour
            if (field.field[xPosition - 1][yPosition - 1].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // this is required only to avoid checkstyle errors, it does nothing
            assert true;
        }
        try {
            // top neighbour
            if (field.field[xPosition][yPosition - 1].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            // top right neighbour
            if (field.field[xPosition + 1][yPosition - 1].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            // left neighbour
            if (field.field[xPosition - 1][yPosition].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            // right neighbour
            if (field.field[xPosition + 1][yPosition].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            // bottom left neighbour
            if (field.field[xPosition - 1][yPosition + 1].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            // bottom neighbour
            if (field.field[xPosition][yPosition + 1].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            // bottom right neighbour
            if (field.field[xPosition + 1][yPosition + 1].isMine) {
                neighbours++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        return neighbours;
    }

    /**
     * This method is called when there are no neighbours around and therefore all their cells can
     * be revealed.
     * For this we iterate through all these neighbours and imitate left click on each of them.
     * It uses the same structure as checkNeighbours method, therefore is considered by checkstyle
     * to be too deeply nested but in our implementation of the game, it is the most performant
     * implementation which also adds nice animation when a lot of cells are being revealed by this
     * method.
     */
    void revealAround() {
        try {
            // top left neighbour
            field.field[xPosition - 1][yPosition - 1].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            // this is required only to avoid checkstyle errors, it does nothing
            assert true;
        }
        try {
            // top neighbour
            field.field[xPosition][yPosition - 1].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            // top right neighbour
            field.field[xPosition + 1][yPosition - 1].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            // left neighbour
            field.field[xPosition - 1][yPosition].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            // right neighbour
            field.field[xPosition + 1][yPosition].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            // bottom left neighbour
            field.field[xPosition - 1][yPosition + 1].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            // bottom neighbour
            field.field[xPosition][yPosition + 1].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
        try {
            // bottom right neighbour
            field.field[xPosition + 1][yPosition + 1].leftClick();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert true;
        }
    }
}
