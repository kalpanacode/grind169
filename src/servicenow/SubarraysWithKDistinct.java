package servicenow;
import java.util.*;
public class SubarraysWithKDistinct {

	public int subarraysWithKDistinct(int[] nums, int k) {
		return atMostK(nums, k) - atMostK(nums, k - 1);
	}

	private int atMostK(int[] nums, int k) {
		int n = nums.length;
		int res = 0, left = 0;
		Map<Integer, Integer> count = new HashMap<>();

		for (int right = 0; right < n; right++) {
			count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
			if (count.get(nums[right]) == 1) k--;

			while (k < 0) {
				count.put(nums[left], count.get(nums[left]) - 1);
				if (count.get(nums[left]) == 0) k++;
				left++;
			}
			res += right - left + 1;
		}
		return res;
	}
}
