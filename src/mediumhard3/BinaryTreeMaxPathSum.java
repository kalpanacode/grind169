  // https://leetcode.com/problems/binary-tree-maximum-path-sum/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;

//Definition for a binary tree node.
class TreeNode {
 int val;
 TreeNode left, right;
 TreeNode(int val) {
     this.val = val;
 }
}

public class BinaryTreeMaxPathSum {
 private static int maxSum;

 public static int maxPathSum(TreeNode root) {
     maxSum = Integer.MIN_VALUE;
     maxGain(root);
     return maxSum;
 }

 // Recursive helper returns max gain from the current node
 private static int maxGain(TreeNode node) {
     if (node == null) return 0;

     // Get max gain from left and right children, ignore negative gains
     int leftGain = Math.max(maxGain(node.left), 0);
     int rightGain = Math.max(maxGain(node.right), 0);

     // Calculate the price of current path using this node as root
     int priceNewPath = node.val + leftGain + rightGain;

     // Update maxSum if priceNewPath is better
     maxSum = Math.max(maxSum, priceNewPath);

     // Return max gain if continuing the same path upwards
     return node.val + Math.max(leftGain, rightGain);
 }

 // Example usage
 public static void main(String[] args) {
     /*
      Construct tree:
          1
         / \
        2   3
      */
     TreeNode root = new TreeNode(1);
     root.left = new TreeNode(2);
     root.right = new TreeNode(3);

     int result = maxPathSum(root);
     System.out.println("Maximum path sum: " + result);  // Expected: 6
 }
}

