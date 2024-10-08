package org.minesweeper;

public class Runtime {

    WelcomeScreen welcomeScreen;

    public void run() {
        welcomeScreen = new WelcomeScreen();
    }

    public static void main(String[] args) {
        new Runtime().run();
    }
}
