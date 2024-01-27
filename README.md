# Tic Tac Toe Game

This folder contains files related to a simple Tic Tac Toe game implemented in Java.

## Files in the Folder

- `TicTacToe.java`: The main Java source code file for the Tic Tac Toe game.
- `TicTacToe.class`: The compiled Java bytecode file.
- `TicTacToe$GameBoard.class`: This file is automatically created as it is part of the `TicTacToe` class.
- `README.txt`: Instructions for running and playing the game.

## Instructions for Running the Program

1. Open your terminal and navigate to the folder containing `TicTacToe.java`.
2. Enter the command `javac TicTacToe.java` to compile the program.
3. After compilation, enter the command `java TicTacToe` to run the program.

## Game Instructions

1. The game presents four sections: 
    - Player Vs Player
    - Player Vs Computer
    - Help
    - Quit

2. Player 1 is always 'X', and Player 2 (or Computer) is always 'O'.

3. When making a move, input a single integer (1 - 9) for the position on the 3x3 board.

4. Carefully read the displayed messages and input according to the instructions or refer to the Help section.

5. When prompted to choose how you wish to play, enter an integer type only.

## Game Rules

- The board is a 3x3 matrix of integers.

- After every move, the program checks for a win:
    - If 'X' appears in any consecutive cells of rows, columns, or diagonals, Player 1 wins.
    - If 'O' appears in any consecutive cells of rows, columns, or diagonals, Player 2 (or Computer) wins.
    - If no win condition is met, the game continues.

- The `isGameFinished()` function checks whether the game has finished.

## Computer vs Player Mode

When the Computer has to make a move:
1. It checks if it can win; if so, it makes that move.
2. If not, it checks if it can block the player from winning.
3. If no winning or blocking move is available, the computer makes a random move in an unoccupied position.

Feel free to explore and enjoy the Tic Tac Toe game!
