package org.minesweeper;

import java.awt.*;
import javax.swing.*;

/**
 * TODO write javadoc.
 */
public class Runtime {
    // runtime stores all screens after their first initialization so game can use same screens
    // instead of creating new ones every time
    WelcomeScreen welcomeScreen;
    GameScreen gameScreen;
    WinScreen winScreen = null;
    LoseScreen loseScreen = null;

    // storing current screen makes program always know what is the current active screen
    // that is shown to the user
    JFrame currentScreen;

    // initializing settings that can be changed by the user so they are also available to every
    // window in the game through runtime
    int xMines;
    int yMines;
    int mineAmount;

    // getting user's screen resolution so it can be used by window objects to properly
    // scale game windows
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int) size.getWidth();
    int screenHeight = (int) size.getHeight();

    /**
     * TODO write javadoc.
     */
    public void start() {
        welcomeScreen = new WelcomeScreen(this);
        currentScreen = welcomeScreen;
        currentScreen.setVisible(true);
    }

    /**
     * TODO write javadoc.
     */
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
