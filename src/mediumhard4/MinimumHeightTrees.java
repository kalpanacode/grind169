// https://leetcode.com/problems/minimum-height-trees/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.*;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }

        // Build adjacency list for the tree
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new HashSet<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Initialize leaves queue: nodes with only one neighbor
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.offer(i);
            }
        }

        // Remove leaves layer by layer until <= 2 nodes remain
        int remainingNodes = n;
        while (remainingNodes > 2) {
            int leavesCount = leaves.size();
            remainingNodes -= leavesCount;
            for (int i = 0; i < leavesCount; i++) {
                int leaf = leaves.poll();
                // The only neighbor connected to leaf
                int neighbor = adj.get(leaf).iterator().next();
                // Remove the edge
                adj.get(neighbor).remove(leaf);
                // If neighbor becomes a leaf, add it to the queue
                if (adj.get(neighbor).size() == 1) {
                    leaves.offer(neighbor);
                }
            }
        }

        // Remaining nodes are centroids -> roots of MHTs
        result.addAll(leaves);
        return result;
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        MinimumHeightTrees solution = new MinimumHeightTrees();

        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};

        List<Integer> mhtRoots = solution.findMinHeightTrees(n, edges);
        System.out.println("Minimum Height Trees roots: " + mhtRoots);  // Expected: [1]
    }
}

