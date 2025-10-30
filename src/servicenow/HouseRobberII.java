package servicenow;

public class HouseRobberII {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];

		// Exclude the last house
		int max1 = robLinear(nums, 0, nums.length - 2);
		// Exclude the first house
		int max2 = robLinear(nums, 1, nums.length - 1);

		return Math.max(max1, max2);
	}

	private int robLinear(int[] nums, int start, int end) {
		int prev1 = 0, prev2 = 0;
		for (int i = start; i <= end; i++) {
			int curr = Math.max(prev1, prev2 + nums[i]);
			prev2 = prev1;
			prev1 = curr;
		}
		return prev1;
	}
}
