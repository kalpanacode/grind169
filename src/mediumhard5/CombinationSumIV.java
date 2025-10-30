// https://leetcode.com/problems/combination-sum-iv/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard5;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;  // one way to make sum 0, by choosing nothing

        // Build up dp from 1 to target
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        CombinationSumIV solution = new CombinationSumIV();
        int[] nums = {1, 2, 3};
        int target = 4;
        int result = solution.combinationSum4(nums, target);
        System.out.println("Number of combinations: " + result);  // Expected: 7
    }
}
