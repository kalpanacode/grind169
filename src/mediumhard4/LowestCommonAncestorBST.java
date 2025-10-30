// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while (current != null) {
            if (p.val > current.val && q.val > current.val) {
                // Both nodes greater, go right
                current = current.right;
            } else if (p.val < current.val && q.val < current.val) {
                // Both nodes smaller, go left
                current = current.left;
            } else {
                // Found the split point, lca is current
                return current;
            }
        }

        return null; // not found
    }

    // TreeNode class for running in Eclipse IDE
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) { this.val = val; }
    }

    // Example test
    public static void main(String[] args) {
        /*
            Construct BST:
                 6
                / \
               2   8
              / \ / \
             0  4 7  9
               / \
              3   5
        */
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        LowestCommonAncestorBST solution = new LowestCommonAncestorBST();
        TreeNode p = root.left;      // Node 2
        TreeNode q = root.right;     // Node 8
        System.out.println("LCA: " + solution.lowestCommonAncestor(root, p, q).val); // Expected: 6
    }
}
