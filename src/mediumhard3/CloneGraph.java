// https://leetcode.com/problems/clone-graph/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;

import java.util.*;

//Definition for a Node.
class Node {
 public int val;
 public List<Node> neighbors;

 public Node() {
     val = 0;
     neighbors = new ArrayList<>();
 }

 public Node(int _val) {
     val = _val;
     neighbors = new ArrayList<>();
 }

 public Node(int _val, ArrayList<Node> _neighbors) {
     val = _val;
     neighbors = _neighbors;
 }
}

public class CloneGraph {

 private Map<Node, Node> visited = new HashMap<>();

 public Node cloneGraph(Node node) {
     if (node == null) {
         return null;
     }
     if (visited.containsKey(node)) {
         return visited.get(node);
     }

     // Clone node and store in visited map
     Node cloneNode = new Node(node.val);
     visited.put(node, cloneNode);

     // Clone neighbors recursively
     for (Node neighbor : node.neighbors) {
         cloneNode.neighbors.add(cloneGraph(neighbor));
     }

     return cloneNode;
 }

 // Helper method for printing graph for verification
 public static void printGraph(Node node) {
     Set<Integer> visited = new HashSet<>();
     Queue<Node> queue = new LinkedList<>();
     queue.offer(node);
     visited.add(node.val);

     while (!queue.isEmpty()) {
         Node curr = queue.poll();
         System.out.print("Node " + curr.val + " neighbors: ");
         for (Node neighbor : curr.neighbors) {
             System.out.print(neighbor.val + " ");
             if (!visited.contains(neighbor.val)) {
                 visited.add(neighbor.val);
                 queue.offer(neighbor);
             }
         }
         System.out.println();
     }
 }

 public static void main(String[] args) {
     // Sample graph:
     // 1 -- 2
     // |    |
     // 4 -- 3
     Node node1 = new Node(1);
     Node node2 = new Node(2);
     Node node3 = new Node(3);
     Node node4 = new Node(4);

     node1.neighbors.add(node2);
     node1.neighbors.add(node4);
     node2.neighbors.add(node1);
     node2.neighbors.add(node3);
     node3.neighbors.add(node2);
     node3.neighbors.add(node4);
     node4.neighbors.add(node1);
     node4.neighbors.add(node3);

     CloneGraph solution = new CloneGraph();
     Node clonedGraph = solution.cloneGraph(node1);

     System.out.println("Original graph:");
     printGraph(node1);

     System.out.println("\nCloned graph:");
     printGraph(clonedGraph);
 }
}
