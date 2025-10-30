// https://leetcode.com/problems/sliding-window-maximum/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.*;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        // Deque stores indices of useful elements in decreasing order of values
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller values at the end since they won't be needed
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index at the back of deque
            deque.offerLast(i);

            // Start recording results when first window is complete
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    // Test method to run in Eclipse IDE
    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] maxWindow = solution.maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(maxWindow)); // Expected: [3, 3, 5, 5, 6, 7]
    }
}

