package org.minesweeper;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame{
    public GameScreen(int xField, int yField, int mineAmount) {
        this.setTitle("Minesweeper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        int width = (int)size.getWidth();

        int height = (int)size.getHeight();

        this.setSize(width / 5, height / 2);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel panel = new JPanel();
        this.add(panel);
    }
}
