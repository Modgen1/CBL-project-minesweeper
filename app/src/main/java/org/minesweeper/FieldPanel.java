package org.minesweeper;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

/**
 * TODO write javadoc.
 */
public class FieldPanel extends JPanel {

    // runtime object that called the screen with this panel
    Runtime runtime;
    // 2d-list containing all field cells that are instances of FieldButton objects
    FieldButton[][] field;

    // variables to be used for FieldButton configuration
    Dimension size; // size of one cell in pixels
    Font font; // font that will be used for text in cells
    Insets margin; // margin for text inside cells

    // variables that are passed to the object generator for configuring field
    int xMines; // width of the field in amount of cells
    int yMines; // height of the field in amount of cells
    int mineAmount; // amount of cells that have mine under them
    int revealed = 0; // amount of already revealed cells, required for determining win condition

    /**
     * TODO write javadoc.
     * All parameters are passed from runtime object which stores these variables.
     *
     * @param xMines width of the field in amount of cells
     * @param yMines height of the field in amount of cells
     * @param mineAmount amount of cells that have mine under them
     */
    public FieldPanel(int xMines, int yMines, int mineAmount, Runtime runtime) {
        // assigning object variables to passed parameters
        this.runtime = runtime;
        this.xMines = xMines;
        this.yMines = yMines;
        this.mineAmount = mineAmount;

        // setting grid layout for putting all cells into correct grid
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // calculating the size of the side of the cell that will fit the user's screen
        int side = Math.min(
                (runtime.screenWidth - 200) / xMines, (runtime.screenHeight - 200) / yMines);
        // creating dimension object for size of the cell as it is passed into the cell's setSize
        size = new Dimension(side, side);
        // creating font object based on cell size that will be used by text inside cells
        font = new Font("Monospaced", Font.PLAIN, side - side / 5);
        // setting zero margins for the cells so they can fit text even when they are small
        margin = new Insets(0, 0, 0, 0);

        // crating the list of cells with given size
        this.field = new FieldButton[xMines][yMines];
        // iterating through this 2D-list and filling it with cell objects
        for (int x = 0; x < xMines; x++) {
            gbc.gridx = x;
            for (int y = 0; y < yMines; y++) {
                gbc.gridy = y;
                // each cell is not a mine when it is generated
                this.field[x][y] = new FieldButton(x, y, this);
                // then cell is immediately added to the panel
                this.add(this.field[x][y], gbc);
            }
        }
        // creating object for randomizing as it is used to pseudo-randomly generate mine position
        Random rand = new Random();
        // iterating through all mines and generating their position
        for (int i = mineAmount; i > 0; i--) {
            int randX = rand.nextInt(0, xMines);
            int randY = rand.nextInt(0, yMines);
            // if there is no mine at this cell, it gets mine, else repeat cycle once more
            if (!field[randX][randY].isMine) {
                field[randX][randY].isMine = true;
            } else {
                i++;
            }
        }
    }
}
