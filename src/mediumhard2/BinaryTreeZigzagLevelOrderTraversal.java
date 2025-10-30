// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard2;

import java.util.*;


public class BinaryTreeZigzagLevelOrderTraversal {

	//Definition for a binary tree node.
	static class TreeNode {
	 int val;
	 TreeNode left, right;
	 TreeNode(int val) {
	     this.val = val;
	 }
	}

 public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     List<List<Integer>> result = new ArrayList<>();
     if (root == null) return result;

     Queue<TreeNode> queue = new LinkedList<>();
     queue.offer(root);
     boolean leftToRight = true;

     while (!queue.isEmpty()) {
         int levelSize = queue.size();
         LinkedList<Integer> currentLevel = new LinkedList<>();

         for (int i = 0; i < levelSize; i++) {
             TreeNode node = queue.poll();

             // Add node value in order based on direction
             if (leftToRight) {
                 currentLevel.addLast(node.val);
             } else {
                 currentLevel.addFirst(node.val);
             }

             if (node.left != null) queue.offer(node.left);
             if (node.right != null) queue.offer(node.right);
         }

         // Flip direction for the next level
         leftToRight = !leftToRight;
         result.add(currentLevel);
     }

     return result;
 }

 public static void main(String[] args) {
     // Build binary tree [3,9,20,null,null,15,7]
     TreeNode root = new TreeNode(3);
     root.left = new TreeNode(9);
     root.right = new TreeNode(20);
     root.right.left = new TreeNode(15);
     root.right.right = new TreeNode(7);

     List<List<Integer>> zigzag = zigzagLevelOrder(root);
     System.out.println("Zigzag level order traversal: " + zigzag);
     // Expected: [[3], [20, 9], [15, 7]]
 }
}

