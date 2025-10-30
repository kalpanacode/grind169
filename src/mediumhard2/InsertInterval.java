// https://leetcode.com/problems/insert-interval/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard2;

import java.util.*;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals ending before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // return result.toArray(new int[result.size()][]);
        int[][] arr = new int[result.size()][];
        result.toArray(arr);
        return arr;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] updatedIntervals = insert(intervals, newInterval);

        System.out.println("Intervals after insertion:");
        for (int[] interval : updatedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
