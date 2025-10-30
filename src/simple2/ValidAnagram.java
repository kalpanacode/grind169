// https://leetcode.com/problems/valid-anagram/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();

        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Is anagram? " + solution.isAnagram(s1, t1));  // Output: true

        String s2 = "rat";
        String t2 = "car";
        System.out.println("Is anagram? " + solution.isAnagram(s2, t2));  // Output: false
    }
}
