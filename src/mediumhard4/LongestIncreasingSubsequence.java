// https://leetcode.com/problems/longest-increasing-subsequence/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;

        // Every element is at least a subsequence of length 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Build dp array where dp[i] is length of LIS ending at i
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();

        int[] nums = {10,9,2,5,3,7,101,18};
        int length = solution.lengthOfLIS(nums);
        System.out.println("Length of longest increasing subsequence: " + length);  // Expected output: 4
    }
}
