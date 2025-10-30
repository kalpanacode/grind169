// https://leetcode.com/problems/non-overlapping-intervals/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard5;
import java.util.*;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort intervals by their end time (greedy strategy)
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // If current interval starts before previous end, need to remove one
            if (intervals[i][0] < prevEnd) {
                count++;
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }

    // Example for testing
    public static void main(String[] args) {
        NonOverlappingIntervals solution = new NonOverlappingIntervals();

        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int toRemove = solution.eraseOverlapIntervals(intervals);

        System.out.println("Minimum intervals to remove: " + toRemove);  // Expected: 1
    }
}
