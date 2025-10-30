// https://leetcode.com/problems/subtree-of-another-tree/description/?envType=problem-list-v2&envId=rabvlt31
package simple1;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class SubtreeChecker {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // If subRoot is null, it is always a subtree
        if (subRoot == null) return true;
        // If root is null but subRoot is not, it's not a subtree
        if (root == null) return false;

        // If trees rooted at current nodes are identical, return true
        if (isSameTree(root, subRoot)) return true;

        // Otherwise, check left and right subtree recursively for subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper method to check if two trees are identical
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
    public static void main(String[] args) {
        // Construct the main tree root = [3,4,5,1,2]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        // Construct the subtree subRoot = [4,1,2]
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        SubtreeChecker checker = new SubtreeChecker();
        boolean result = checker.isSubtree(root, subRoot);

        System.out.println("Is subRoot a subtree of root? " + result);
    }

}

