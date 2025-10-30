// https://leetcode.com/problems/partition-equal-subset-sum/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard5;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        // If total sum is odd, cannot split into equal halves
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        // dp[j] => true if subset sum j can be formed
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // sum 0 can always be formed (by taking nothing)

        // Build bottom-up DP
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }

    // Example testing in Eclipse IDE
    public static void main(String[] args) {
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();

        int[] nums1 = {1, 5, 11, 5};
        System.out.println("Can partition [1,5,11,5]? " + solution.canPartition(nums1));  // Expected: true

        int[] nums2 = {1, 2, 3, 5};
        System.out.println("Can partition [1,2,3,5]? " + solution.canPartition(nums2));  // Expected: false
    }
}
