# Pac-Man Game Clone

A classic Pac-Man game developed in Java, demonstrating core game development principles, object-oriented programming, and 2D graphics rendering with OpenGL. The player navigates a maze, consumes pellets, and avoids ghosts to win.

![Java](https://img.shields.io/badge/Language-Java-blue)
![Graphics](https://img.shields.io/badge/API-OpenGL-green)
![Grade](https://img.shields.io/badge/Project%20Grade-A%2B-brightgreen)


## Features

  * **Classic Gameplay:** Control Pac-Man to eat all the pellets in the maze.
  * **Intelligent Ghosts:** Four enemy ghosts with basic AI to track and chase the player.
  * **Scoring System:** Gain points for each pellet eaten.
  * **Lives System:** Start with a set number of lives, lose a life upon collision with a ghost.
  * **Win/Loss Conditions:** Win the game by clearing the maze of all pellets or lose by running out of lives.
  * **2D Graphics Engine:** Smooth, real-time game rendering and animations built with Java and OpenGL.

## Technologies Used

  * **Language:** Java
  * **Graphics:** OpenGL (using a Java binding) for graphics rendering.

## Getting Started

To run the project on your local machine, follow these steps.

### Prerequisites

  * Java Development Kit (JDK) installed.
  * The necessary OpenGL bindings for Java (e.g., JOGL or LWJGL) configured in your project environment.

### Installation & Execution

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/M-Sayed939/PacMan-Project.git
    ```
2.  **Navigate to the source directory:**
    ```sh
    cd PacMan-Project/src/Project
    ```
3.  **Compile the Java source files (ensure your OpenGL libraries are in the classpath):**
    ```sh
    javac *.java
    ```
4.  **Run the main application:**
    ```sh
    java pacman
    ```

## Project Structure

  * `pacman.java`: The main class and entry point for the application.
  * `maze.java`: Manages the game board, rendering, game loop, and collision detection.
  * `player.java`: Defines the Pac-Man character, controlling its movement and state.
  * `ghost.java`: Defines the ghost characters and their basic AI behavior.
  * `cell.java`, `moveable.java`, `person.java`: Base classes and objects that build the core structure of the game elements using OOP principles.

## Team

This project was a collaborative effort by:

  * Mohamed Sayed Fahim
  * Radwa Rahoma
  * Mohamed Sayed Mohamed
  * Menna Akram
  * Farah Hossam
  * Designed and implemented fundamental AI for four distinct ghost enemies that track and chase the player through the maze.
  * Applied Object-Oriented Programming (OOP) principles to create a modular and maintainable codebase with distinct classes for the player, ghosts, and maze environment.
  * Achieved an **A+ grade** for the project, reflecting a high standard of code quality, functionality, and documentation.
