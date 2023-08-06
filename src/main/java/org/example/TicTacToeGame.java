package org.example;

import java.util.Scanner;

public class TicTacToeGame {

    public static final char PLAYER_X_SYMBOL = 'X';
    public static final char PLAYER_O_SYMBOL = 'O';
    public static final int BOARD_SIZE = 9;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] board = new char[BOARD_SIZE];
        boolean boxEmpty = false;
        char winner = 0;

        initializeBoard(board);
        System.out.println("Enter box number to select. Enjoy!\n");

        while (true) {
            displayBoard(board);

            if (!boxEmpty) {
                initializeBoard(board);
                boxEmpty = true;
            }

            if (winner == PLAYER_X_SYMBOL) {
                displayWinnerMessage("You won");
                break;
            } else if (winner == PLAYER_O_SYMBOL) {
                displayWinnerMessage("You lost");
                break;
            } else if (winner == 'D') {
                displayWinnerMessage("It's a draw");
                break;
            }

            int userInput = getUserInput(scan);

            if (isValidMove(board, userInput)) {
                makeMove(board, userInput, PLAYER_X_SYMBOL);
                winner = checkWinner(board, PLAYER_X_SYMBOL);
                if (winner == 0) {
                    int computerMove = getComputerMove(board);
                    makeMove(board, computerMove, PLAYER_O_SYMBOL);
                    winner = checkWinner(board, PLAYER_O_SYMBOL);
                }
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }

    public static void initializeBoard(char[] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = (char) ('1' + i);
        }
    }

    public static void displayBoard(char[] board) {
        System.out.println("\n\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }

    public static void displayWinnerMessage(String message) {
        System.out.println(message + " the game!\nCreated by Shreyas Saha. Thanks for playing!");
    }

    public static int getUserInput(Scanner scan) {
        return scan.nextInt();
    }

    public static boolean isValidMove(char[] board, int input) {
        return input > 0 && input <= BOARD_SIZE && (board[input - 1] != PLAYER_X_SYMBOL && board[input - 1] != PLAYER_O_SYMBOL);
    }

    public static void makeMove(char[] board, int input, char symbol) {
        board[input - 1] = symbol;
    }

    public static int getComputerMove(char[] board) {
        int move;
        do {
            move = (int) (Math.random() * (BOARD_SIZE - 1 + 1) + 1);
        } while (board[move - 1] == PLAYER_X_SYMBOL || board[move - 1] == PLAYER_O_SYMBOL);
        return move;
    }

    public static char checkWinner(char[] board, char symbol) {
        if ((board[0] == symbol && board[1] == symbol && board[2] == symbol) ||
                (board[3] == symbol && board[4] == symbol && board[5] == symbol) ||
                (board[6] == symbol && board[7] == symbol && board[8] == symbol) ||
                (board[0] == symbol && board[3] == symbol && board[6] == symbol) ||
                (board[1] == symbol && board[4] == symbol && board[7] == symbol) ||
                (board[2] == symbol && board[5] == symbol && board[8] == symbol) ||
                (board[0] == symbol && board[4] == symbol && board[8] == symbol) ||
                (board[2] == symbol && board[4] == symbol && board[6] == symbol)) {
            return symbol;
        } else if (isBoardFull(board)) {
            return 'D';
        } else {
            return 0;
        }
    }

    public static boolean isBoardFull(char[] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i] != PLAYER_X_SYMBOL && board[i] != PLAYER_O_SYMBOL) {
                return false;
            }
        }
        return true;
    }
}