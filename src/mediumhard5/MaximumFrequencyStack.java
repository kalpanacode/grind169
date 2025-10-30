// https://leetcode.com/problems/maximum-frequency-stack/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard5;

import java.util.*;

public class MaximumFrequencyStack {

    private Map<Integer, Integer> freqMap; // frequency of elements
    private Map<Integer, Stack<Integer>> groupStack; // map frequency to stack of elements
    private int maxFreq;

    public MaximumFrequencyStack() {
        freqMap = new HashMap<>();
        groupStack = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);

        maxFreq = Math.max(maxFreq, freq);

        groupStack.computeIfAbsent(freq, x -> new Stack<>()).push(val);
    }

    public int pop() {
        Stack<Integer> stack = groupStack.get(maxFreq);
        int val = stack.pop();

        freqMap.put(val, freqMap.get(val) - 1);

        if (stack.isEmpty()) {
            groupStack.remove(maxFreq);
            maxFreq--;
        }

        return val;
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        MaximumFrequencyStack freqStack = new MaximumFrequencyStack();

        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);

        System.out.println(freqStack.pop()); // 5
        System.out.println(freqStack.pop()); // 7
        System.out.println(freqStack.pop()); // 5
        System.out.println(freqStack.pop()); // 4
    }
}
