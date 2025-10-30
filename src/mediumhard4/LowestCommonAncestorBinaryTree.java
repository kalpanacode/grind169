// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

public class LowestCommonAncestorBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recur for left and right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides return non-null, root is LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise return non-null left or right
        return left != null ? left : right;
    }

    // TreeNode class for running in Eclipse IDE
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) { this.val = val; }
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        /*
             Constructed binary tree:
                    3
                   / \
                  5   1
                 / \ / \
                6  2 0  8
                  / \
                 7   4
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestorBinaryTree solution = new LowestCommonAncestorBinaryTree();
        TreeNode p = root.left; // Node 5
        TreeNode q = root.right; // Node 1
        System.out.println("LCA: " + solution.lowestCommonAncestor(root, p, q).val); // Expected: 3
    }
}
