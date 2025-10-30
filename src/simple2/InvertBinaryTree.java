// https://leetcode.com/problems/invert-binary-tree/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;

//Definition for a binary tree node.
class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode(int val) {
     this.val = val;
     this.left = null;
     this.right = null;
 }
}

public class InvertBinaryTree {
 public TreeNode invertTree(TreeNode root) {
     if (root == null) return null;

     // Swap left and right subtree recursively
     TreeNode temp = root.left;
     root.left = invertTree(root.right);
     root.right = invertTree(temp);

     return root;
 }

 // Helper method to print tree inorder for validation
 public void inorderPrint(TreeNode root) {
     if (root == null) return;
     inorderPrint(root.left);
     System.out.print(root.val + " ");
     inorderPrint(root.right);
 }

 public static void main(String[] args) {
     InvertBinaryTree solution = new InvertBinaryTree();

     // Construct the binary tree: [4,2,7,1,3,6,9]
     TreeNode root = new TreeNode(4);
     root.left = new TreeNode(2);
     root.right = new TreeNode(7);
     root.left.left = new TreeNode(1);
     root.left.right = new TreeNode(3);
     root.right.left = new TreeNode(6);
     root.right.right = new TreeNode(9);

     System.out.print("Original tree inorder: ");
     solution.inorderPrint(root);
     System.out.println();

     // Invert the binary tree
     TreeNode invertedRoot = solution.invertTree(root);

     System.out.print("Inverted tree inorder: ");
     solution.inorderPrint(invertedRoot);
     System.out.println();
     // Output inorder should reflect inverted structure
 }
}

