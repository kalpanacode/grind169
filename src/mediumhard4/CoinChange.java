// https://leetcode.com/problems/coin-change/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;  // A value greater than amount (acts like infinity)
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);  // Initialize dp with max value
        dp[0] = 0;             // Base case: 0 coins needed for amount 0

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = solution.coinChange(coins, amount);
        System.out.println("Fewest number of coins needed: " + result); // Expected: 3
    }
}
