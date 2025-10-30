// https://leetcode.com/problems/squares-of-a-sorted-array/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        int pos = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                result[pos--] = leftSquare;
                left++;
            } else {
                result[pos--] = rightSquare;
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray solution = new SquaresOfSortedArray();

        int[] nums = {-4, -1, 0, 3, 10};
        int[] squaredSorted = solution.sortedSquares(nums);

        System.out.println("Squares sorted: " + Arrays.toString(squaredSorted));  // Output: [0, 1, 9, 16, 100]
    }
}
