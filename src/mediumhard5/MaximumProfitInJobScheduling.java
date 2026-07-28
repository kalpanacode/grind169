// https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/?envType=problem-list-v2&envId=rabvlt31
// https://www.youtube.com/watch?v=3kU7VYcmffU

package mediumhard5;

import java.util.*;
import java.util.Arrays;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling {
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);

        for (int[] job : jobs) {
            int currentProfit = job[2] + dp.floorEntry(job[0]).getValue();

            if (currentProfit > dp.lastEntry().getValue()) {
                dp.put(job[1], currentProfit);
            }
        }

        return dp.lastEntry().getValue();
    }

    public static void main(String[] args) {
        MaximumProfitInJobScheduling solution = new MaximumProfitInJobScheduling();

        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};

        int result = solution.jobScheduling(startTime, endTime, profit);
        System.out.println("Maximum profit: " + result); // Expected: 120
    }
}
