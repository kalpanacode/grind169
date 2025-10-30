// https://leetcode.com/problems/path-sum-ii/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;

import java.util.*;

//Definition for a binary tree node.

public class PathSumII {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ans = new ArrayList<>();


		dfs(root, 0, ans, new ArrayList<>(), sum);

		return ans;

	}

	private static void dfs(TreeNode root, int runningSum, List<List<Integer>> ans, List<Integer> runningList, int target){
		if(root==null){
			return ;
		}
		int totalCurrSum = root.val+ runningSum;

		runningList.add(root.val);

		if(root.left==null && root.right==null && target == totalCurrSum){
			// terminal node
			ans.add(new ArrayList<Integer>(runningList));
			return;
		}
		// pre order traversal

		dfs(root.right, totalCurrSum, ans, new ArrayList<>(runningList), target);
		dfs(root.left, totalCurrSum, ans, new ArrayList<>(runningList), target);

	}

	public static void main(String[] args) {
		/*
	      Construct tree:
	           5
	          / \
	         4   8
	        /   / \
	      11   13  4
	      / \      / \
	     7   2    5   1
		 */
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);

		int targetSum = 22;

		List<List<Integer>> paths = pathSum(root, targetSum);
		System.out.println("Paths with sum " + targetSum + ": " + paths);
		// Expected output: [[5, 4, 11, 2], [5, 8, 4, 5]]
	}


}


/*
 public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
     List<List<Integer>> result = new ArrayList<>();
     List<Integer> currentPath = new ArrayList<>();
     dfs(root, targetSum, currentPath, result);
     return result;
 }

 private static void dfs(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
     if (node == null) return;

     currentPath.add(node.val);
     remainingSum -= node.val;

     // Check if leaf node and sum matches
     if (node.left == null && node.right == null && remainingSum == 0) {
         result.add(new ArrayList<>(currentPath));
     } else {
         dfs(node.left, remainingSum, currentPath, result);
         dfs(node.right, remainingSum, currentPath, result);
     }
     // Backtrack
     currentPath.remove(currentPath.size() - 1);
 }
 */

