// https://leetcode.com/problems/subsets/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard2;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Add current subset to result
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Include nums[i]
            current.add(nums[i]);
            // Explore further
            backtrack(nums, i + 1, current, result);
            // Backtrack: remove last element
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);

        System.out.println("All subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
        // Expected output: [], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]
    }
}

