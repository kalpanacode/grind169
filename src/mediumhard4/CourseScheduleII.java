// https://leetcode.com/problems/course-schedule-ii/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Step 1: Build adjacency list
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        // Step 2: Initialize queue with all courses that have no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        // Step 3: Perform topological sort
        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;
            for (int next : graph.get(curr)) {
                inDegree[next]--;
                if (inDegree[next] == 0)
                    queue.offer(next);
            }
        }

        // If not all courses processed, cycle exists → return empty array
        return (index == numCourses) ? order : new int[0];
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        CourseScheduleII cs = new CourseScheduleII();

        int numCourses1 = 2;
        int[][] prerequisites1 = { {1, 0} };
        System.out.println("Example 1 Output: " + Arrays.toString(cs.findOrder(numCourses1, prerequisites1)));

        int numCourses2 = 4;
        int[][] prerequisites2 = { {1,0}, {2,0}, {3,1}, {3,2} };
        System.out.println("Example 2 Output: " + Arrays.toString(cs.findOrder(numCourses2, prerequisites2)));

        int numCourses3 = 2;
        int[][] prerequisites3 = { {1,0}, {0,1} };
        System.out.println("Example 3 Output (cycle case): " + Arrays.toString(cs.findOrder(numCourses3, prerequisites3)));
    }
}
