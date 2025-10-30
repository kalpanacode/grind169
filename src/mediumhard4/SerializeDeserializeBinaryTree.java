// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.*;

public class SerializeDeserializeBinaryTree {
    // Serialize a tree to a single string
    public String serialize(TreeNode root) {
        if (root == null) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(',');
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append("null,");
            }
        }
        // Remove trailing commas and null values for cleanliness
        while (sb.length() > 5 && sb.substring(sb.length() - 5).equals("null,")) {
            sb.setLength(sb.length() - 5);
        }
        // Remove trailing comma if exists
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.setLength(sb.length() - 1);
        }
        sb.append(']');
        return sb.toString();
    }

    // Deserialize a string to a tree
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;

        String[] nodes = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode node = queue.poll();

            String leftVal = nodes[index++];
            if (!leftVal.equals("null")) {
                node.left = new TreeNode(Integer.parseInt(leftVal));
                queue.offer(node.left);
            }

            if (index < nodes.length) {
                String rightVal = nodes[index++];
                if (!rightVal.equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(rightVal));
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    // TreeNode class for Eclipse IDE use
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v) { val = v; }
    }

    // Testing serialization and deserialization
    public static void main(String[] args) {
        SerializeDeserializeBinaryTree codec = new SerializeDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserializedRoot = codec.deserialize(serialized);
        String verifySerialization = codec.serialize(deserializedRoot);
        System.out.println("Verified Serialization: " + verifySerialization);
    }
}
