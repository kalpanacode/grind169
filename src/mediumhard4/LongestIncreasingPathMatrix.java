// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

public class LongestIncreasingPathMatrix {
    private int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;

        int[][] memo = new int[m][n];
        int maxLen = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, memo));
            }
        }
        return maxLen;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] memo) {
        if (memo[row][col] != 0) return memo[row][col];

        int max = 1; // length at least 1 (the cell itself)
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] > matrix[row][col]) {
                int len = 1 + dfs(matrix, r, c, memo);
                max = Math.max(max, len);
            }
        }
        memo[row][col] = max;
        return max;
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        LongestIncreasingPathMatrix solution = new LongestIncreasingPathMatrix();

        int[][] matrix = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };

        int length = solution.longestIncreasingPath(matrix);
        System.out.println("Length of longest increasing path: " + length); // Expected: 4
    }
}
