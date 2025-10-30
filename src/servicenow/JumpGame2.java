// https://www.youtube.com/watch?v=9kyHYVxL4fw
// https://leetcode.com/problems/jump-game-ii/description/

// Greedy on coverage calculation

package servicenow;

public class JumpGame2 {
	public int jump(int[] nums) {
		int totalJumps = 0;
        int destination = nums.length - 1;
        int coverage = 0, lastJumpIdx = 0;

        for (int i = 0; i < destination; i++) {
            coverage = Math.max(coverage, i + nums[i]);

            // When we've reached the end of the current jump coverage range
            if (i == lastJumpIdx) {
                totalJumps++;
                lastJumpIdx = coverage;

                if (lastJumpIdx >= destination) {
                    break; // We can end early since we can reach or pass the destination now
                }
            }
        }
        return totalJumps;
	}
}

