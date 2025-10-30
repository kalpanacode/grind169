// https://leetcode.com/problems/single-number/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;

public class SingleNumber {
    // Method to find the single number appearing once
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR operation cancels out duplicates
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();

        int[] nums1 = {2, 2, 1};
        System.out.println("Single number: " + solution.singleNumber(nums1));  // Output: 1

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Single number: " + solution.singleNumber(nums2));  // Output: 4
    }
}
