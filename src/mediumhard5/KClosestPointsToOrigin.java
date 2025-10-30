// https://leetcode.com/problems/k-closest-points-to-origin/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard5;

import java.util.*;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(distance(b), distance(a))
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove the farthest point if size exceeds k
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll();
        }
        return result;
    }

    private double distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        KClosestPointsToOrigin solution = new KClosestPointsToOrigin();

        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;

        int[][] closest = solution.kClosest(points, k);
        System.out.print("K closest points to origin: ");
        for (int[] p : closest) {
            System.out.print(Arrays.toString(p) + " ");
        }
        // Expected output: [-2, 2]
    }
}
