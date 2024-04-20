package com.backtracking;

/**
 * Time Comlexity O(n^n)
 */
public class NQueens {


    public static boolean isSafe(char[][] board, int row, int col) {

        //Check column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') return false;
        }
        //Check Row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 'Q') return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row, j = col; i < board.length && j < board.length; i++, j++) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public static void placeQueens(char[][] board, int col) {
        if (col == board.length) {
            System.out.println("N Queens arrangement in board: ");
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                placeQueens(board, col + 1);
                board[row][col] = '.';
            }
        }


    }


    public static void main(String[] args) {

        int n = 8;
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        placeQueens(board, 0);
    }
}
