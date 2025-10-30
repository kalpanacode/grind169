// https://leetcode.com/problems/combination-sum/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int remain, int start, List<Integer> tempList, List<List<Integer>> result) {
        if (remain < 0) return; // Exceeded target, stop exploration
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i, tempList, result);  // not i + 1 because we can reuse the same element
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = combinationSum(candidates, target);
        System.out.println("Combinations summing to " + target + ": " + combinations);
    }
}
