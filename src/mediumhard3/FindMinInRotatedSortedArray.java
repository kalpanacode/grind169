// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;
// simple 1 step binary

public class FindMinInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        // If array is not rotated (sorted), return first element
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than right element, minimum lies to the right
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise minimum lies to the left (including mid)
                right = mid;
            }
        }
        return nums[left];  // left == right at the end, minimum element
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int min = findMin(nums);
        System.out.println("Minimum element in rotated sorted array: " + min);
        // Expected output: 1
    }
}

