// https://leetcode.com/problems/rotate-array/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;

import java.util.*;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Normalize k if larger than array length

        // Reverse entire array
        reverse(nums, 0, n - 1);
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse remaining n-k elements
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);
        System.out.println("Rotated array: " + Arrays.toString(nums));
        // Expected output: [5, 6, 7, 1, 2, 3, 4]
    }
}
