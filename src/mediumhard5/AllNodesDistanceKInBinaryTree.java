// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard5;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);

        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (dist == K) break;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && visited.add(node.left)) {
                    queue.offer(node.left);
                }
                if (node.right != null && visited.add(node.right)) {
                    queue.offer(node.right);
                }
                TreeNode parent = parentMap.get(node);
                if (parent != null && visited.add(parent)) {
                    queue.offer(parent);
                }
            }
            dist++;
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        return result;
    }

    private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) return;
        parentMap.put(node, parent);
        buildParentMap(node.left, node, parentMap);
        buildParentMap(node.right, node, parentMap);
    }

    // TreeNode class for Eclipse environment
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v) { val = v; }
    }

    // Example for testing
    public static void main(String[] args) {
        /*
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

        AllNodesDistanceKInBinaryTree solution = new AllNodesDistanceKInBinaryTree();
        TreeNode target = root.left; // Node 5
        int K = 2;

        List<Integer> nodesAtDistanceK = solution.distanceK(root, target, K);
        System.out.println("Nodes at distance " + K + " from target: " + nodesAtDistanceK); // Expected: [7, 4, 1]
    }
}
