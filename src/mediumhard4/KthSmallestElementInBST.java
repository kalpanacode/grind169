// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

public class KthSmallestElementInBST {

    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inorder(node.right, k);
    }

    // TreeNode definition for running in Eclipse
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) { this.val = val; }
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        /*
            Constructed BST:
                 3
                / \
               1   4
                \
                 2
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallestElementInBST solution = new KthSmallestElementInBST();
        int k = 1;
        System.out.println("Kth smallest element is: " + solution.kthSmallest(root, k)); // Expected: 1
    }
}
