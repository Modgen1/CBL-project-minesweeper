package org.minesweeper;

import javax.swing.*;
import java.awt.*;

public class Runtime {

    WelcomeScreen welcomeScreen;
    GameScreen gameScreen;
    WinScreen winScreen;
    LoseScreen loseScreen;

    JFrame currentScreen;

    int xMines;
    int yMines;
    int mineAmount;

    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int SCREEN_WIDTH = (int)size.getWidth();
    int SCREEN_HEIGHT = (int)size.getHeight();

    public void start() {
        welcomeScreen = new WelcomeScreen(this);
        currentScreen = welcomeScreen;
        currentScreen.setVisible(true);
    }

    public void newGame() {
        currentScreen.setVisible(false);
        gameScreen = new GameScreen(this);
        currentScreen = gameScreen;
        currentScreen.setVisible(true);
    }

    public static void main(String[] args) {
        new Runtime().start();
    }
}
