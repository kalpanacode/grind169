// https://leetcode.com/problems/move-zeroes/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;

        // Move non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Fill remaining positions with zero
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();

        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);

        System.out.println("After moving zeroes: " + Arrays.toString(nums));  // Output: [1, 3, 12, 0, 0]
    }
}
