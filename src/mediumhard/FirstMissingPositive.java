// https://leetcode.com/problems/first-missing-positive/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace numbers <= 0 and > n with a number outside index range (n+1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) nums[i] = n + 1;
        }

        // Step 2: Use index as a hash to mark presence of a number
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) continue;
            if (nums[num - 1] > 0) nums[num - 1] = -nums[num - 1];
        }

        // Step 3: Find first index with positive value (missing number)
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }

        // All numbers 1 to n are present
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        int missing = firstMissingPositive(nums);
        System.out.println("First missing positive: " + missing);
    }
}

