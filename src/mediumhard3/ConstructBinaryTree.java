// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;

import java.util.*;



public class ConstructBinaryTree {
	//Definition for a binary tree node.
	static class TreeNode {
	 int val;
	 TreeNode left, right;
	 TreeNode(int val) {
	     this.val = val;
	 }
	}

 private static int preorderIndex = 0;
 private static Map<Integer, Integer> inorderIndexMap;

 public static TreeNode buildTree(int[] preorder, int[] inorder) {
     preorderIndex = 0;
     inorderIndexMap = new HashMap<>();
     for (int i = 0; i < inorder.length; i++) {
         inorderIndexMap.put(inorder[i], i);
     }
     return build(preorder, 0, inorder.length - 1);
 }

 private static TreeNode build(int[] preorder, int left, int right) {
     if (left > right) {
         return null;
     }

     int rootVal = preorder[preorderIndex++];
     TreeNode root = new TreeNode(rootVal);

     // Using hashmap to get the index of root in inorder traversal
     int inorderIndex = inorderIndexMap.get(rootVal);

     // Recursively build left and right subtrees
     root.left = build(preorder, left, inorderIndex - 1);
     root.right = build(preorder, inorderIndex + 1, right);

     return root;
 }

 // Helper method to print tree in level order for verification
 public static void printLevelOrder(TreeNode root) {
     if (root == null) return;
     Queue<TreeNode> queue = new LinkedList<>();
     queue.offer(root);
     List<Integer> result = new ArrayList<>();

     while (!queue.isEmpty()) {
         TreeNode node = queue.poll();
         if (node != null) {
             result.add(node.val);
             queue.offer(node.left);
             queue.offer(node.right);
         } else {
             result.add(null);
         }
     }

     // Trim trailing nulls
     int i = result.size() - 1;
     while (i >= 0 && result.get(i) == null) {
         result.remove(i);
         i--;
     }

     System.out.println(result);
 }

 public static void main(String[] args) {
     int[] preorder = {3, 9, 20, 15, 7};
     int[] inorder = {9, 3, 15, 20, 7};

     TreeNode root = buildTree(preorder, inorder);
     System.out.print("Constructed Tree (level order): ");
     printLevelOrder(root);
     // Expected output: [3, 9, 20, null, null, 15, 7]
 }
}

