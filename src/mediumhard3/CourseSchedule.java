// https://leetcode.com/problems/course-schedule/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list representation of the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // In-degree array to track number of prerequisites for each course
        int[] inDegree = new int[numCourses];

        // Build graph and update in-degree
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int dependency = pre[1];
            adj.get(dependency).add(course);
            inDegree[course]++;
        }

        // Queue to process courses with zero prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int completed = 0;

        // BFS to process courses
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completed++;

            for (int next : adj.get(current)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If all courses are completed, return true
        return completed == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule solver = new CourseSchedule();

        int numCourses1 = 2;
        int[][] prerequisites1 = { {1, 0} };
        System.out.println("Example 1: " + solver.canFinish(numCourses1, prerequisites1));
        // Output: true

        int numCourses2 = 2;
        int[][] prerequisites2 = { {1, 0}, {0, 1} };
        System.out.println("Example 2: " + solver.canFinish(numCourses2, prerequisites2));
        // Output: false

        int numCourses3 = 4;
        int[][] prerequisites3 = { {1, 0}, {2, 1}, {3, 2} };
        System.out.println("Example 3: " + solver.canFinish(numCourses3, prerequisites3));
        // Output: true
    }
}
