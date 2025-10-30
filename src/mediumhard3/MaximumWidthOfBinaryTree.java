// https://leetcode.com/problems/maximum-width-of-binary-tree/description/
// Queue<Pair<TreeNode, Integer>> queue  // Node with index 0 left 2i+1, right 2i+2
// if (i == 0) first = index;
// if (i == size - 1) last = index;
package mediumhard3;

import java.util.*;


public class MaximumWidthOfBinaryTree {
	//Definition for a binary tree node.
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int val) {
			this.val = val;
		}
	}

	public static int widthOfBinaryTree(TreeNode root) {
		if (root == null) return 0;

		int maxWidth = 0;
		Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
		queue.offer(new Pair<>(root, 0)); // Node with index 0

		while (!queue.isEmpty()) {
			int size = queue.size();
			int levelMinIndex = queue.peek().getValue(); // Index of first node at this level
			int first = 0, last = 0;

			for (int i = 0; i < size; i++) {
				Pair<TreeNode, Integer> pair = queue.poll();
				TreeNode node = pair.getKey();
				// Normalize index to avoid integer overflow
				int index = pair.getValue() - levelMinIndex;

				if (i == 0) first = index;
				if (i == size - 1) last = index;

				if (node.left != null) {
					queue.offer(new Pair<>(node.left, 2 * index + 1));
				}
				if (node.right != null) {
					queue.offer(new Pair<>(node.right, 2 * index + 2));
				}
			}
			maxWidth = Math.max(maxWidth, last - first + 1);
		}

		return maxWidth;
	}

	// Simple Pair class since Java FX is not always available
	static class Pair<K, V> {
		private K key;
		private V value;
		public Pair(K key, V value) { this.key = key; this.value = value; }
		public K getKey() { return key; }
		public V getValue() { return value; }
	}

	public static void main(String[] args) {
		/*
                   1
                 /   \
                3     2
               / \     \
              5   3     9
		 */
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(9);

		int maxWidth = widthOfBinaryTree(root);
		System.out.println("Maximum width of binary tree: " + maxWidth);
		// Expected output: 4
	}
}

