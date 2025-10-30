// https://leetcode.com/problems/sudoku-solver/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard;

public class SudokuSolver {

    public static void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private static boolean backtrack(char[][] board, int row, int col) {
        if (row == 9) return true; // Reached the end successfully

        if (col == 9) return backtrack(board, row + 1, 0);

        if (board[row][col] != '.') {
            return backtrack(board, row, col + 1);
        }

        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c;
                if (backtrack(board, row, col + 1)) return true;
                board[row][col] = '.'; // Undo assignment (backtrack)
            }
        }

        return false; // No valid number found, backtrack
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;    // Check row
            if (board[i][col] == c) return false;    // Check column
            // Check 3x3 box
            int r = boxRowStart + i / 3;
            int co = boxColStart + i % 3;
            if (board[r][co] == c) return false;
        }

        return true;
    }

    public static void printBoard(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Original Sudoku board:");
        printBoard(board);

        solveSudoku(board);

        System.out.println("\nSolved Sudoku board:");
        printBoard(board);
    }
}
