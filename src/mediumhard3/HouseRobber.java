// https://leetcode.com/problems/house-robber/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;

public class HouseRobber {

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev = 0;      // Max amount robbed up to previous house
        int curr = 0;      // Max amount robbed up to current house

        for (int num : nums) {
            int temp = curr;
            // Decide to rob current house (prev + num) or skip it (curr)
            curr = Math.max(prev + num, curr);
            prev = temp;
        }

        return curr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 4};
        int maxRob = rob(nums);
        System.out.println("Maximum amount that can be robbed: " + maxRob);  // Expected: 4
    }
}

