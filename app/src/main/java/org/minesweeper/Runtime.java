package org.minesweeper;

public class Runtime {

    WelcomeScreen welcomeScreen;
    GameScreen gameScreen;

    public void start() {
        welcomeScreen = new WelcomeScreen(this);
        welcomeScreen.setVisible(true);
    }

    public void newGame(int xField, int yField, int mineAmount) {
        welcomeScreen.setVisible(false);
        gameScreen = new GameScreen(xField, yField, mineAmount);
        gameScreen.setVisible(true);
    }

    public static void main(String[] args) {
        new Runtime().start();
    }
}
