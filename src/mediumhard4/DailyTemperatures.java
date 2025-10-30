// https://leetcode.com/problems/daily-temperatures/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.*;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices of days

        // Iterate through temperatures
        for (int i = 0; i < n; i++) {
            // Pop indices with temperatures less than current temperature
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex; // days to wait for warmer temp
            }
            stack.push(i);
        }

        // Remaining indices in stack have no warmer days in future; default 0 in result
        return result;
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] answer = solution.dailyTemperatures(temperatures);

        System.out.println(Arrays.toString(answer)); // Expected: [1, 1, 4, 2, 1, 1, 0, 0]
    }
}

