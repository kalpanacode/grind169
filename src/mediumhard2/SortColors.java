// https://leetcode.com/problems/sort-colors/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard2;

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {
        int low = 0;     // Next position for 0 (red)
        int mid = 0;     // Current element under consideration
        int high = nums.length - 1;   // Next position for 2 (blue)

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid], move both pointers forward
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 (white) is in correct place, just move mid forward
                mid++;
            } else {
                // nums[mid] == 2, swap nums[mid] and nums[high], move high backward
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.println("Original array: " + Arrays.toString(nums));

        sortColors(nums);

        System.out.println("Sorted array: " + Arrays.toString(nums));  // Expected: [0, 0, 1, 1, 2, 2]
    }
}

