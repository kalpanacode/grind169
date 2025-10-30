// https://leetcode.com/problems/coin-change/description/ 

package servicenow;
import java.util.*;
public class CoinChange {


	    public int coinChange(int[] coins, int amount) {
	        int max = amount + 1;
	        int[] dp = new int[amount + 1];
	        Arrays.fill(dp, max);
	        dp[0] = 0;

	        for (int a = 1; a <= amount; a++) {
	            for (int c : coins) {
	                if (a - c >= 0) {
	                    dp[a] = Math.min(
	                        dp[a],
	                        1 + dp[a - c]
	                    );
	                }
	            }
	        }

	        return dp[amount] == max ? -1 : dp[amount];
	    }
	}

