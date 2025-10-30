// https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard5;

import java.util.*;

public class MaximumProfitInJobScheduling {

    private static class Job implements Comparable<Job> {
        int start, end, profit;

        Job(int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }

        public int compareTo(Job other) {
            return this.end - other.end;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs);

        // dp[i] stores max profit until ith job (jobs sorted by end time)
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int includeProfit = jobs[i].profit;

            // Find the last job that doesn't conflict with job i using binary search
            int l = binarySearch(jobs, i);
            if (l != -1) {
                includeProfit += dp[l];
            }

            dp[i] = Math.max(includeProfit, dp[i - 1]);
        }

        return dp[n - 1];
    }

    // Binary search to find the rightmost job that ends <= start of job[i]
    private int binarySearch(Job[] jobs, int index) {
        int low = 0, high = index - 1;
        int target = jobs[index].start;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid].end <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        MaximumProfitInJobScheduling solution = new MaximumProfitInJobScheduling();
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};

        int maxProfit = solution.jobScheduling(startTime, endTime, profit);
        System.out.println("Maximum profit: " + maxProfit);  // Expected: 120
    }
}

