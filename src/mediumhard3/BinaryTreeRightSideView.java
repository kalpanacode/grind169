// https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;

import java.util.*;

public class BinaryTreeRightSideView {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // Iterate through one level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // If it's the last element in this level, add to result
                if (i == size - 1) {
                    result.add(node.val);
                }
                // Add children to queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Construct the test tree [1,2,3,null,5,null,4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // Get the right side view
        List<Integer> rightView = rightSideView(root);

        // Print the result
        System.out.println("Right Side View: " + rightView);
    }
}
