package org.minesweeper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * TODO write javadoc.
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
     * TODO write javadoc.
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
     * TODO write javadoc.
     */
    public void leftClick() {
        // if the cell was not already revealed
        if (!this.revealed) {
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
     * TODO write javadoc.
     */
    public void rightClick() {
        // if cell is not revealed and there is no flag, put flag
        if (!this.revealed && !this.flagged) {
            this.flagged = true;

            String flagIcon = new String(Character.toChars(0x1F6A9));
            this.setText(flagIcon);

        // else if it has flag, remove it
        } else if (!this.revealed) {
            this.flagged = false;
            this.setText("");
        }
    }

    /**
     * TODO write javadoc.
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
     * TODO write javadoc.
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
