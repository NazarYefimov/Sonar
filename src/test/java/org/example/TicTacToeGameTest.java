package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeGameTest {

    @Test
    public void testInitializeBoard() {
        char[] board = new char[TicTacToeGame.BOARD_SIZE];
        TicTacToeGame.initializeBoard(board);
        char[] expectedBoard = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        assertArrayEquals(expectedBoard, board);
    }

    @Test
    public void testIsValidMove() {
        char[] board = { 'X', 'O', '3', '4', '5', '6', '7', '8', '9' };
        assertFalse(TicTacToeGame.isValidMove(board, 1));
        assertFalse(TicTacToeGame.isValidMove(board, 2));
        assertTrue(TicTacToeGame.isValidMove(board, 3));
        assertTrue(TicTacToeGame.isValidMove(board, 9));
        assertFalse(TicTacToeGame.isValidMove(board, 10));
    }

    @Test
    public void testCheckWinner() {
        char[] board1 = { 'X', 'X', 'X', '4', '5', '6', '7', '8', '9' };
        char[] board2 = { 'O', 'O', '3', 'X', 'X', '6', '7', '8', '9' };
        char[] board3 = { 'O', 'X', '3', '4', 'X', '6', '7', '8', 'X' };
        char[] board4 = { 'X', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'X' };
        assertEquals('X', TicTacToeGame.checkWinner(board1, TicTacToeGame.PLAYER_X_SYMBOL));
        assertEquals('X', TicTacToeGame.checkWinner(board2, TicTacToeGame.PLAYER_X_SYMBOL));
        assertEquals('X', TicTacToeGame.checkWinner(board3, TicTacToeGame.PLAYER_X_SYMBOL));
        assertEquals('D', TicTacToeGame.checkWinner(board4, TicTacToeGame.PLAYER_X_SYMBOL));
    }
}