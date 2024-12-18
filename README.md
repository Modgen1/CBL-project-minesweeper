# Minesweeper CBL Project
> Made by Ivan Sergeevich Mishin and Nikita Vladimirovich Gamolin as a 2IP90 CBL project
>
> [Link](https://github.com/Modgen1/CBL-project-minesweeper) to the GitHub repo of this project


### Project description
This project implements a simple game of Minesweeper with basic logic and a couple of additional features.

The project is written in Java using Swing as a graphical framework. It also uses Gradle built system configured to create jar-file of the project to run it on any computer with Java installed.

The project was tested on Windows, macOS and Linux X11 with different screen resolutions.


### Project structure
In the root folder of the project, there are multiple files and directories. Most of the files are required to configure and run Gradle. There is also a .xml file with the configuration of Checkstyle as it is required for this project. The rest of the files such as .gitignore required to configure which files should not be pushed to the repo and the .gitatributes file is required to deal with building the project on different operating systems. .idea and .github directories contain config files for the IDE and VCS accordingly. app directory contains the src folder where all Java code is placed and also contains all build files if you build the project locally. src directory also includes a subdirectory for test files as gradle allows automation of all unit tests, but it was not our topic of choice so it is not yet implemented.

The main class of the project is org.minesweeper.Runtime which is launched when you launch the jar file. More on each separate class can be read in JavaDocs in each of these files.


### Downloading the project
Simply go to [releases](https://github.com/Modgen1/CBL-project-minesweeper/releases) and download the .jar executable from there.


### Running the program
Java 17 or higher is required to run the program!

If you get "A Java exception has occurred" error, check that you are using correct version of JRE.

To run this executable you can either click on it, if Java is set to be the default application for the .jar extension in your system, or you can run the command:

`java -jar <absolute path to the .jar executable>`


### Clean build
To build this project, clone the repo to your local machine or download sources from [releases](https://github.com/Modgen1/CBL-project-minesweeper/releases), then navigate to the root folder of the project and run the command:

`gradlew shadowJar`

This will create a jar executable called `minesweeper-x.x.x.jar`, where x.x.x is the version of the game in the root folder of the project.
Shadow jar is used for this project as it allows you to put all dependencies of the project directly inside one so-called fat-jar file which does not require anything to run except for Java being installed on your computer.


## Game logic
When you launch the game, you see the main menu which allows you to change three settings. Then you can start the game by pressing the button at the bottom, and it will open the game screen.

The game field is a grid of cells with user chosen size. Under each cell, there might be a mine. When a user clicks on the cell, if it is not a mine, it shows the amount of cells with mines around itself. If there are no mines around the cell, all surrounding cells are also revealed. If the user clicks on a cell with mine, they lose the game. The game is won where all non-mine cells are revealed.

To allow players to remember where there might be a mine, they can right-click a cell, and it will put a flag on it. While the cell is flagged, it cannot be revealed. Second right-click on a cell removes the flag from it.

Lose and win screens both contain three buttons - either to play the game with the same setting again, to go to the main menu to change settings, or to exit the game.


### About Git
As Git is one of our chosen topic of interest, we were not simply using it for versioning but also exploring new functionality for us. As being said, we made separate branches for development and also main structural components of the project were implemented in their separate branches and then merged into the dev branch. During the project, we became familiar with how to manage pull requests, how to deal with merge conflicts, how to set up IDEs for proper work with multiple git branches and how to manage working in different branches simultaneously. 

Moreover, I was also interested in finding something that will combine git with our second topic of interest - Gradle. And I found out about CI in GitHub that allows to automate gradle build and testing in the cloud. So we spent some time researching it and set it up to automatically check every push to the main and dev branches and also to check every pull request. It also helped us find some cases where there were merge conflicts.


### Credits:
- Mostly Oracle Java Documentation
- A lot of GitHub docs for CI implementation and automatization
- [Gradle](https://docs.gradle.org/current/userguide/userguide.html) and [ShadowJar](https://gradleup.com/shadow/introduction/) documentations
- 2IP90 Lectures about Swing and its structure
- Many, Many discussions on Stackoverflow to find solutions to our bugs
- Most of the basic aspects of the game were already known but as a basis, we used [this](https://minesweeperonline.com/) implementation of the game.
- The thing that changed our project the most was probably not some source but generally our discussion with each other as we were talking about how we wanted to implement different things, so there were no real sources that influenced us, we already knew what minesweeper is and how it works.
