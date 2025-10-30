package simple1;


public class ConvertSortedArrayToBST {
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

	public TreeNode sortedArrayToBST(int[] nums) {
		return buildBST(nums, 0, nums.length - 1);
	}

	private TreeNode buildBST(int[] nums, int left, int right) {
		if (left > right) return null;
		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildBST(nums, left, mid - 1);
		root.right = buildBST(nums, mid + 1, right);
		return root;
	}

	// Helper method to print tree inorder for verification
	private void inorderTraversal(TreeNode root) {
		if (root == null) return;
		inorderTraversal(root.left);
		System.out.print(root.val + " ");
		inorderTraversal(root.right);
	}

	public static void main(String[] args) {
		ConvertSortedArrayToBST solution = new ConvertSortedArrayToBST();

		int[] nums = {-10, -3, 0, 5, 9};
		TreeNode root = solution.sortedArrayToBST(nums);

		System.out.print("Inorder traversal of the BST: ");
		solution.inorderTraversal(root);  // Expected inorder: -10 -3 0 5 9
	}
}
