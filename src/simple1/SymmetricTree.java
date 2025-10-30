// https://leetcode.com/problems/symmetric-tree/description/?envType=problem-list-v2&envId=rabvlt31

package simple1;


public class SymmetricTree {

	//Definition for a binary tree node.
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return isMirror(root.left, root.right);
	}

	private boolean isMirror(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) return true;
		if (t1 == null || t2 == null) return false;
		if (t1.val != t2.val) return false;
		return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
	}

	public static void main(String[] args) {
		SymmetricTree solution = new SymmetricTree();

		// Construct the binary tree: [1,2,2,3,4,4,3]
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);

		// Check if the tree is symmetric
		boolean result = solution.isSymmetric(root);
		System.out.println("Is the tree symmetric? " + result);  // Output: true
	}
}
