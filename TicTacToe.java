// By Prashant 

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    public static class GameBoard {
        char[][] board;

        public GameBoard() { // call the constructor to fill the blank space when I created new game board
            board = new char[][] { { ' ', ' ', ' ' },
                    { ' ', ' ', ' ' },
                    { ' ', ' ', ' ' } };
        }

        public void print() {
            System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
            System.out.println("-+-+-");
            System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
            System.out.println("-+-+-");
            System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        }

        public void clear() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }
        }

        public boolean hasWon(char symbol) {
            if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                    (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                    (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                    (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                    (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                    (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                    (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                    (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
                return true;
            }
            return false;
        }

        public boolean isValidMove(int position) {
            switch (position) {
                case 1:
                    return (board[0][0] == ' ');
                case 2:
                    return (board[0][1] == ' ');
                case 3:
                    return (board[0][2] == ' ');
                case 4:
                    return (board[1][0] == ' ');
                case 5:
                    return (board[1][1] == ' ');
                case 6:
                    return (board[1][2] == ' ');
                case 7:
                    return (board[2][0] == ' ');
                case 8:
                    return (board[2][1] == ' ');
                case 9:
                    return (board[2][2] == ' ');
                default:
                    return false;
            }

        }

        public void placeMove(int position, char symbol) {
            switch (position) {
                case 1:
                    board[0][0] = symbol;
                    break;
                case 2:
                    board[0][1] = symbol;
                    break;
                case 3:
                    board[0][2] = symbol;
                    break;
                case 4:
                    board[1][0] = symbol;
                    break;
                case 5:
                    board[1][1] = symbol;
                    break;
                case 6:
                    board[1][2] = symbol;
                    break;
                case 7:
                    board[2][0] = symbol;
                    break;
                case 8:
                    board[2][1] = symbol;
                    break;
                case 9:
                    board[2][2] = symbol;
                    break;
                default:
                    System.out.println("Invalid Choice!! Try Again");
            }
        }

        public boolean isGameFinished(int ch) {

            if (hasWon('X')) {
                print();
                System.out.println("Congratulations! Player1 wins");
                return true;
            }

            if (hasWon('O')) {
                print();
                if (ch == 1)
                    System.out.println("Congratulations! Player2 wins");
                else
                    System.out.println("Alas! Computer wins!");
                return true;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        return false;
                    }
                }
            }
            print();
            System.out.println("The game ended in a tie!");
            return true;
        }

    }

    public static void playerVsPlayer(GameBoard gBoard, int ch) {
        Scanner input = new Scanner(System.in);
        int p = 1;
        while (true) {
            System.out.println("Enter position you want to mark ! (1 - 9)");
            int get = input.nextInt();
            if (p == 1)
                System.out.println("Player1 chose " + get);
            else
                System.out.println("Player2 chose " + get);

            if (gBoard.isValidMove(get)) {
                gBoard.placeMove(get, (p == 1) ? 'X' : 'O');

                if (p == 1)
                    p = 2;
                else
                    p = 1;
            } else {
                System.out.println("Invalid Choice !! Try Again");
            }

            if (gBoard.isGameFinished(1))
                break;
            else
                gBoard.print();
        }
    }

    public static void playerVsComputer(GameBoard gBoard, int ch) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int p = 1;
        while (true) {

            if (p == 1) {
                System.out.println("Enter position you want to mark ! (1 - 9)");
                int get = input.nextInt();
                System.out.println("Player1 chose " + get);
                if (gBoard.isValidMove(get)) {
                    gBoard.placeMove(get, (p == 1) ? 'X' : 'O');

                    if (p == 1)
                        p = 2;
                    else
                        p = 1;
                } else {
                    System.out.println("Invalid Choice !! Try Again");
                }
            } else {
                // computer turns
                // Step 1: Check for winning possibility
                int havepos = -1;
                for (int i = 1; i <= 9; i++) {
                    if (gBoard.isValidMove(i)) {
                        gBoard.placeMove(i, 'O');
                        if (gBoard.hasWon('O')) {
                            havepos = i;
                        }
                        gBoard.placeMove(i, ' '); // Undo the move
                    }
                }

                if (havepos == -1) {
                    // Step 2: Block the player from winning
                    for (int i = 1; i <= 9; i++) {
                        if (gBoard.isValidMove(i)) {
                            gBoard.placeMove(i, 'X');
                            if (gBoard.hasWon('X')) {
                                // gBoard.placeMove(i, 'O');
                                havepos = i;
                            }
                            gBoard.placeMove(i, ' '); // Undo the move
                        }
                    }

                    if (havepos == -1) {

                        // Step 3: If neither winning nor blocking, make a random move
                        int randomMove;
                        do {
                            randomMove = rand.nextInt(9) + 1;
                            havepos = randomMove;
                        } while (!gBoard.isValidMove(randomMove));

                    }

                }

                System.out.println("Computer chose " + havepos);
                gBoard.placeMove(havepos, 'O');

                if (p == 1)
                    p = 2;
                else
                    p = 1;

            }

            if (gBoard.isGameFinished(2))
                break;
            else
                gBoard.print();
        }

    }

    public static void main(String[] args) {

        GameBoard gBoard = new GameBoard();
        Scanner input = new Scanner(System.in);
        System.out.println("****Welcome to the ultimate battle of Tic Tac Toe*****");

        while (true) {
            System.out.println("1 Player vs Player");
            System.out.println("2 Player vs Computer");
            System.out.println("3 Help");
            System.out.println("4 Quit");
            int choice;
            choice = input.nextInt();
            gBoard.print();
            switch (choice) {
                case 1:
                    playerVsPlayer(gBoard, 1);
                    gBoard.clear();
                    break;
                case 2:
                    playerVsComputer(gBoard, 2);
                    gBoard.clear();
                    break;
                case 3:
                    System.out.println("****************************************************************************");
                    System.out.println("1 Players take turns placing 'X' or 'O' on an empty spot.");
                    System.out.println("2 Achieve consecutive three Mark either in row , column, or diagonal to win.");
                    System.out.println("3 Enter a number from 1 to 9 for placing your marks");
                    System.out.println("****************************************************************************");
                    break;
                case 4:
                    System.out.println("You Successfully exit !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }

    }
}
