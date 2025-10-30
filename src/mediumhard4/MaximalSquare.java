// https://leetcode.com/problems/maximal-square/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        // dp[i][j] represents the side length of the largest square whose
        // bottom-right corner is at (i-1, j-1) in the original matrix.
        int[][] dp = new int[m + 1][n + 1];
        int maxSide = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // The side length of the square depends on minimum of
                    // squares ending top, left, and diagonal top-left
                    dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j], dp[i][j - 1]),
                        dp[i - 1][j - 1]
                    ) + 1;

                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        // Return area of the largest square found
        return maxSide * maxSide;
    }

    // Example test for Eclipse IDE
    public static void main(String[] args) {
        MaximalSquare ms = new MaximalSquare();
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        int maxArea = ms.maximalSquare(matrix);
        System.out.println("Maximal square area: " + maxArea); // Expected: 4
    }
}

