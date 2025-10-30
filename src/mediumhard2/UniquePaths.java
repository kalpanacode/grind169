// https://leetcode.com/problems/unique-paths/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard2;

public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Initialize the first row and first column to 1
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // Fill the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Number of ways to reach current cell is sum of ways from top and left cells
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        int paths = uniquePaths(m, n);
        System.out.println("Number of unique paths for grid " + m + "x" + n + ": " + paths);
        // Expected output: 28
    }
}

