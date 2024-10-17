package org.minesweeper;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

/**
 * TODO write javadoc.
 */
public class FieldPanel extends JPanel {

    Runtime runtime;
    FieldButton[][] field;

    Dimension size;
    Font font;
    Insets margin;

    int xMines;
    int yMines;
    int mineAmount;
    int revealed = 0;

    /**
     * TODO write javadoc.
     *
     * @param xMines TODO
     * @param yMines TODO
     * @param mineAmount TODO
     */
    public FieldPanel(int xMines, int yMines, int mineAmount, Runtime runtime) {

        this.runtime = runtime;
        this.xMines = xMines;
        this.yMines = yMines;
        this.mineAmount = mineAmount;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        int side = Math.min(
                (runtime.screenWidth - 200) / xMines, (runtime.screenHeight - 200) / yMines);
        size = new Dimension(side, side);

        font = new Font("Monospaced", Font.PLAIN, side - side / 5);

        margin = new Insets(0, 0, 0, 0);

        this.field = new FieldButton[xMines][yMines];
        for (int x = 0; x < xMines; x++) {
            gbc.gridx = x;
            for (int y = 0; y < yMines; y++) {
                gbc.gridy = y;
                this.field[x][y] = new FieldButton(false, x, y, this);
                this.add(this.field[x][y], gbc);
            }
        }
        Random rand = new Random();
        for (int i = mineAmount; i > 0; i--) {
            int randX = rand.nextInt(0, xMines);
            int randY = rand.nextInt(0, yMines);
            if (!field[randX][randY].isMine) {
                field[randX][randY].isMine = true;
            } else {
                i++;
            }
        }
    }
}
