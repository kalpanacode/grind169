// https://leetcode.com/problems/validate-binary-search-tree/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard2;


public class ValidateBST {

	//Definition for a binary tree node.
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int val) {
			this.val = val;
		}
	}
	public static boolean isValidBST(TreeNode root) {
		return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean validate(TreeNode node, Integer low, Integer high) {
		if (node == null) {
			return true;
		}

		int val = node.val;

		// Check current node with allowed range
		if (( val <= low) || ( val >= high)) {
			return false;
		}

		// Recursively validate left and right subtrees with updated ranges
		return validate(node.left, low, val) && validate(node.right, val, high);
	}

	public static void main(String[] args) {
		// Construct binary tree: [2,1,3]
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);

		boolean isBST = isValidBST(root);
		System.out.println("Is valid BST: " + isBST); // Expected: true
	}
}

