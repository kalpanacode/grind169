// https://leetcode.com/problems/diameter-of-binary-tree/description/?envType=problem-list-v2&envId=rabvlt31

package simple1;

public class BinaryTreeDiameter {

	// TreeNode class to represent tree nodes
	static class TreeNode {
	    int val;
	    TreeNode left, right;

	    TreeNode(int val) {
	        this.val = val;
	    }
	}

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        // Constructing the binary tree [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeDiameter btd = new BinaryTreeDiameter();
        int diameter = btd.diameterOfBinaryTree(root);

        System.out.println("Diameter of the binary tree: " + diameter);
    }
}
