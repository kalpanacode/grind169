// https://leetcode.com/problems/missing-number/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2; // sum of numbers from 0 to n
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();

        int[] nums1 = {3, 0, 1};
        System.out.println("Missing number: " + solution.missingNumber(nums1));  // Output: 2

        int[] nums2 = {0, 1};
        System.out.println("Missing number: " + solution.missingNumber(nums2));  // Output: 2
    }
}
