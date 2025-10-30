// https://leetcode.com/problems/task-scheduler/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;

import java.util.*;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int idleSlots = (maxFreq - 1) * n;

        for (int i = 24; i >= 0 && idleSlots > 0; i--) {
            idleSlots -= Math.min(freq[i], maxFreq - 1); //2
        }

        idleSlots = Math.max(0, idleSlots);
        return tasks.length + idleSlots;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        int result = leastInterval(tasks, n);
        System.out.println("Minimum intervals required: " + result);
        // Expected output: 8
    }
}

