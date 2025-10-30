// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard5;

import java.util.*;

public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int windowLength = p.length();
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            if (i >= windowLength) {
                sCount[s.charAt(i - windowLength) - 'a']--;
            }

            if (Arrays.equals(pCount, sCount)) {
                result.add(i - windowLength + 1);
            }
        }
        return result;
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        FindAllAnagramsInString solution = new FindAllAnagramsInString();

        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagramIndices = solution.findAnagrams(s, p);
        System.out.println("Anagram start indices: " + anagramIndices);  // Expected: [0, 6]
    }
}
