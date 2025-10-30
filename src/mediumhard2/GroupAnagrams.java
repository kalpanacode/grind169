// https://leetcode.com/problems/group-anagrams/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard2;

import java.util.*;

public class GroupAnagrams {
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Build a unique key for each anagram group based on character counts
            StringBuilder key = new StringBuilder();
            for (int val : count) {
                key.append('#').append(val);
            }

            String keyStr = key.toString();
            map.computeIfAbsent(keyStr, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);

        System.out.println("Input: " + Arrays.toString(strs));
        System.out.println("Grouped Anagrams:");
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
