package org.minesweeper;

import javax.swing.*;

public class WinScreen extends JFrame {

    public WinScreen(Runtime runtime) {
        this.setTitle("Minesweeper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(runtime.SCREEN_WIDTH / 5, runtime.SCREEN_HEIGHT / 2);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel panel = new JPanel();
        this.add(panel);
    }
}
