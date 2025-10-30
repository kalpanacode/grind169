// https://leetcode.com/problems/ransom-note/description/?envType=problem-list-v2&envId=rabvlt31
package simple2;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];

        for (char c : magazine.toCharArray()) {
            counts[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--counts[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        RansomNote solution = new RansomNote();

        String ransomNote1 = "a";
        String magazine1 = "b";
        System.out.println("Can construct ransom note? " + solution.canConstruct(ransomNote1, magazine1));  // Output: false

        String ransomNote2 = "aa";
        String magazine2 = "aab";
        System.out.println("Can construct ransom note? " + solution.canConstruct(ransomNote2, magazine2));  // Output: true
    }
}
