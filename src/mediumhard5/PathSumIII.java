// https://leetcode.com/problems/path-sum-iii/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard5;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Base case: empty path sum = 0
        return helper(root, 0, targetSum, prefixSumCount);
    }

    private int helper(TreeNode node, int currSum, int targetSum, Map<Integer, Integer> prefixSumCount) {
        if (node == null) return 0;

        currSum += node.val;
        // Number of ways to get currSum - targetSum is number of paths meeting targetSum ending here
        int count = prefixSumCount.getOrDefault(currSum - targetSum, 0);

        // Update prefixSumCount with current sum
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        // Recurse down
        count += helper(node.left, currSum, targetSum, prefixSumCount) 
              + helper(node.right, currSum, targetSum, prefixSumCount);

        // Restore the map state before returning to parent
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

        return count;
    }

    // TreeNode definition for Eclipse IDE
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v) { val = v; }
    }

    // Example for testing
    public static void main(String[] args) {
        /*
                 10
                /  \
               5   -3
              / \    \
             3   2    11
            / \   \
           3  -2   1
         */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        PathSumIII solution = new PathSumIII();
        int targetSum = 8;
        int count = solution.pathSum(root, targetSum);
        System.out.println("Number of paths with sum " + targetSum + ": " + count); // Expected: 3
    }
}
