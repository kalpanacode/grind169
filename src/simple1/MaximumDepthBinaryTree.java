// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=problem-list-v2&envId=rabvlt31

package simple1;


public class MaximumDepthBinaryTree {
 // Method to find the maximum depth of a binary tree
 public int maxDepth(TreeNode root) {
     if (root == null) return 0;
     int leftDepth = maxDepth(root.left);
     int rightDepth = maxDepth(root.right);
     return Math.max(leftDepth, rightDepth) + 1;
 }

 // Main method for testing
 public static void main(String[] args) {
     MaximumDepthBinaryTree solution = new MaximumDepthBinaryTree();

     // Construct the binary tree: [3,9,20,null,null,15,7]
     TreeNode root = new TreeNode(3);
     root.left = new TreeNode(9);
     root.right = new TreeNode(20);
     root.right.left = new TreeNode(15);
     root.right.right = new TreeNode(7);

     // Calculate maximum depth
     int depth = solution.maxDepth(root);
     System.out.println("Maximum depth of the binary tree: " + depth);  // Output: 3
 }
}

