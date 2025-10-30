// https://leetcode.com/problems/jump-game/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard2;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                // If current position is beyond max reachable, return false
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Can jump to end (nums1): " + canJump(nums1)); // Expected: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Can jump to end (nums2): " + canJump(nums2)); // Expected: false
    }
}
