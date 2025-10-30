// https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.*;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // kth largest is (n-k)th smallest in 0-based index
        return quickSelect(nums, 0, n - 1, n - k);
    }

    private int quickSelect(int[] nums, int left, int right, int kSmallest) {
        if (left == right) return nums[left];

        int pivotIndex = partition(nums, left, right);

        if (pivotIndex == kSmallest) {
            return nums[pivotIndex];
        } else if (pivotIndex < kSmallest) {
            return quickSelect(nums, pivotIndex + 1, right, kSmallest);
        } else {
            return quickSelect(nums, left, pivotIndex - 1, kSmallest);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // Example driver for Eclipse IDE
    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Kth largest element is: " + solution.findKthLargest(nums, k)); // Expected: 5
    }
}
