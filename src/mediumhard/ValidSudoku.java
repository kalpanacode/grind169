// https://leetcode.com/problems/valid-sudoku/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard;

public class ValidSudoku {

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

    public static boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') continue;

                // Temporarily empty the cell to avoid false positive in isValid 
                board[r][c] = '.';

                if (!isValid(board, r, c, val)) {
                    return false;
                }
                
                // Restore the cell value after check
                board[r][c] = val;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Is the Sudoku board valid? " + isValidSudoku(board));
    }
}
