package org.minesweeper;

import java.awt.*;
import javax.swing.*;

/**
 * For more information about project itself, please read README.md.
 * Main package class that runs the program. Stores all created objects of screen classes,
 * the current screen, information regarding the user's screen resolution and all global variables
 * that can be accessed by other objects of the package.
 * It also handles switching between screens depending on user current state.
 *
 * @author Ivan Sergeevich Mishin (2076209)
 * @author Nikita Vladimirovich Gamolin (2091402)
 */
public class Runtime {
    // runtime stores all screens after their first initialization so game can use same screens
    // instead of creating new ones every time
    WelcomeScreen welcomeScreen = null;
    GameScreen gameScreen = null;
    WinScreen winScreen = null;
    LoseScreen loseScreen = null;

    // storing current screen makes program always know what is the current active screen
    // that is shown to the user
    JFrame currentScreen = null;

    // initializing settings that can be changed by the user so they are also available to every
    // window in the game through runtime
    int xMines = 12; // 12 is the minimal width of the field
    int yMines = 12; // 12 is the minimal height of the field
    int mineAmount = 18; // 18 is the minimal amount of mines on the smallest field

    // getting user's screen resolution so it can be used by window objects to properly
    // scale game windows
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int) size.getWidth();
    int screenHeight = (int) size.getHeight();

    /**
     * Create or switch to a welcome screen at the launch of the program.
     */
    public void mainMenu() {
        // if there is no created object of welcome screen, create new object
        if (welcomeScreen == null) {
            welcomeScreen = new WelcomeScreen(this);
        // if there is, then we are switching from another screen, therefore turn off current screen
        } else {
            currentScreen.setVisible(false);
        }
        // set welcome screen as current screen and show it
        currentScreen = welcomeScreen;
        currentScreen.setVisible(true);
    }

    /**
     * Switch from the current screen to the new game screen.
     */
    public void newGame() {
        // set current screen as not visible
        currentScreen.setVisible(false);
        // create new object of game screen class for this runtime
        gameScreen = new GameScreen(this);
        // set game screen as current screen and show it
        currentScreen = gameScreen;
        currentScreen.setVisible(true);
    }

    /**
     * Method that is called when user wins the game.
     * Switches from the game screen to the win screen.
     */
    public void winGame() {
        // set current screen as not visible
        currentScreen.setVisible(false);
        // if there is no created object of win screen, create new object
        if (winScreen == null) {
            winScreen = new WinScreen(this);
        }
        // then set win screen as current screen and show it
        currentScreen = winScreen;
        currentScreen.setVisible(true);
    }

    /**
     * Method that is called when user loses the game.
     * Switches from the game screen to the defeat screen.
     */
    public void loseGame() {
        // firstly, wait three seconds for animation of lose
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // then set current screen as not visible
        currentScreen.setVisible(false);
        // if there is no created object of defeat screen, create new object
        if (loseScreen == null) {
            loseScreen = new LoseScreen(this);
        }
        // then set defeat screen as current screen and show it
        currentScreen = loseScreen;
        currentScreen.setVisible(true);
    }

    public static void main(String[] args) {
        new Runtime().mainMenu();
    }
}
