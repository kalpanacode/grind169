// https://leetcode.com/problems/word-search/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard2;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true; // All chars matched
        }

        // Check out of bounds or mismatch
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited by temporarily changing value
        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = backtrack(board, word, i + 1, j, index + 1) ||
                        backtrack(board, word, i - 1, j, index + 1) ||
                        backtrack(board, word, i, j + 1, index + 1) ||
                        backtrack(board, word, i, j - 1, index + 1);

        // Restore the original value for backtracking
        board[i][j] = temp;

        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println("Word '" + word1 + "' exists: " + exist(board, word1)); // true
        System.out.println("Word '" + word2 + "' exists: " + exist(board, word2)); // true
        System.out.println("Word '" + word3 + "' exists: " + exist(board, word3)); // false
    }
}
