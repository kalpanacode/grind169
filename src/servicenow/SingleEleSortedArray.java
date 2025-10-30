// https://leetcode.com/problems/single-element-in-a-sorted-array/description/
package servicenow;

public class SingleEleSortedArray {
	public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean isEven = (mid % 2 == 0);

            if (nums[mid] == nums[mid + 1]) {
                // If mid is even and equals next, single is on the right side.
                // If mid is odd, single is on the left side.
                if (isEven) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                // If mid is odd and equals previous, single is on right side.
                // If mid is even, single is on left side.
                if (isEven) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else {
                // nums[mid] is unique
                return nums[mid];
            }
        }

        return nums[low];
    }
}
