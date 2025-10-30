package simple1;

//Definition for a binary tree node.
class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode(int val) {
     this.val = val;
     this.left = null;
     this.right = null;
 }
}

public class BalancedBinaryTree {
 // Method to check if binary tree is height-balanced
 public boolean isBalanced(TreeNode root) {
     return checkHeight(root) != -1;
 }

 // Helper method to check height and detect imbalance
 private int checkHeight(TreeNode node) {
     if (node == null) return 0;

     int leftHeight = checkHeight(node.left);
     if (leftHeight == -1) return -1; // Left subtree not balanced

     int rightHeight = checkHeight(node.right);
     if (rightHeight == -1) return -1; // Right subtree not balanced

     if (Math.abs(leftHeight - rightHeight) > 1) return -1; // Current node not balanced

     return Math.max(leftHeight, rightHeight) + 1;
 }

 // Main method for testing
 public static void main(String[] args) {
     BalancedBinaryTree solution = new BalancedBinaryTree();

     // Construct the binary tree: [3,9,20,null,null,15,7]
     TreeNode root = new TreeNode(3);
     root.left = new TreeNode(9);
     root.right = new TreeNode(20);
     root.right.left = new TreeNode(15);
     root.right.right = new TreeNode(7);

     // Check if the tree is balanced
     boolean result = solution.isBalanced(root);
     System.out.println("Is the binary tree balanced? " + result);  // Output: true
 }
}
