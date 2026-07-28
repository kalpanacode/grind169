// https://leetcode.com/problems/palindrome-pairs/description/?envType=problem-list-v2&envId=rabvlt31
// https://www.youtube.com/watch?v=ewNE1UbjmJ8

//https://www.youtube.com/watch?v=-vdScGc8ebI
// Three cases to be covered:
//   abc cba ---> sometimes one pair, some time tow pair
 
//   Abcba  "" ---> place left or right two pair

//   S1 part1 (reverse of s2). S1 part2 (Palindrome). , S2   ===> s1,s2 in solution
//   S1 part1 (palindrome). S1 part2 (reverse of S2). , S2   ===> S2,s1 in solution


 List<List<Integer>> result = new ArrayList<>();
    Map<String,Integer> map = new HashMap<>();
    public List<List<Integer>> palindromePairs(String[] words) {
        if(words == null || words.length == 0){
            return result;
        }
        
        String[]reverse = new String[words.length];
    
        
        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
            reverse[i] = new StringBuilder(words[i]).reverse().toString();
         }
        
        
        
        if(map.containsKey("")){
            for(int i=0;i<words.length;i++){
                if(i != map.get("") && isPalindrome(words[i],0,words[i].length()-1)){
                    result.add(Arrays.asList(map.get(""),i));
                    result.add(Arrays.asList(i,map.get("")));
                }
            }
        }
        
        //reflection
        
        for(int i=0;i<words.length;i++){
          
            if(map.containsKey(reverse[i])){
                Integer idx = map.get(reverse[i]);
                if(idx != null && idx != i){
                result.add(Arrays.asList(i,idx));
                }
            }
        }
        
        for(int i=0;i<words.length;i++){
            String currentWord = words[i];
            for(int cut=1;cut<currentWord.length();cut++){
                String leftCut = currentWord.substring(0,cut);
                String rightCut = currentWord.substring(cut);
                if(isPalindrome(leftCut,0,leftCut.length()-1)){
                    String r = new StringBuilder(rightCut).reverse().toString();
                    if(map.containsKey(r)){
                        result.add(Arrays.asList(map.get(r),i));
                    }
                }
                if(isPalindrome(rightCut,0,rightCut.length()-1)){
                     String r = new StringBuilder(leftCut).reverse().toString();
                    if(map.containsKey(r)){
                        result.add(Arrays.asList(i,map.get(r)));
                    }
                }
            }
        }
        
        return result;
        
    }
    
    
    public boolean isPalindrome(String word,int start,int end){
        while(start < end){
            if(word.charAt(start++) != word.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}


//Trie based solution which works for new testcases too

 class TrieNode{
    TrieNode []children;
    int id;
    List<Integer>pos;
    TrieNode(){
        children=new TrieNode[26];
        pos=new ArrayList<>();
        id=-1;
    }
}
class Solution {
    TrieNode root;
    List<List<Integer>>result;
    Solution(){
        root=new TrieNode();
        result=new ArrayList<>();
    }
    public boolean isPalindrome(String word,int start,int end){
        while(start<end){
            if(word.charAt(start++)!=word.charAt(end--)){
                return false;
            }
            
        }
        return true;
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        
        for(int i=0;i<words.length;i++){
            insertIntoTrie(words[i],i);
        }
         for(int i=0;i<words.length;i++){
            searchInTrie(words[i],i);
        }
        return result;
    }
    
    public void insertIntoTrie(String word,int id){
        TrieNode pCrawl=root;
        for(int i=word.length()-1;i>=0;i--){
            int index=word.charAt(i)-'a';
            
            if(pCrawl.children[index]==null){
                pCrawl.children[index]=new TrieNode();
            }
            if(isPalindrome(word,0,i)){
             pCrawl.pos.add(id);
                
            }
             pCrawl=pCrawl.children[index];
            
        }
        pCrawl.id=id;
        pCrawl.pos.add(id);
    }
    public void searchInTrie(String word,int id){
        TrieNode pCrawl=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(pCrawl.id>=0&&pCrawl.id!=id&&isPalindrome(word,i,word.length()-1)){
                List<Integer>res=new ArrayList<>();
                res.add(id);
                res.add(pCrawl.id);
                result.add(res);
            }
            if(pCrawl.children[index]==null)
                return;
                pCrawl=pCrawl.children[index];
        }
        for(int i:pCrawl.pos){
            if(i==id)
                continue;
            List<Integer>res=new ArrayList<>();
            res.add(id);
            res.add(i);
            result.add(res);
        }
    }






//******************************************************************

package mediumhard5;

import java.util.*;

public class PalindromePairs {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index = -1; // index of word ending here, -1 if none
        List<Integer> palindromeSuffixIndices = new ArrayList<>();
    }

    private TrieNode root = new TrieNode();

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        // Build a Trie of reversed words
        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }

        // Search pairs for each word
        for (int i = 0; i < words.length; i++) {
            search(words, i, result);
        }

        return result;
    }

    private void insert(String word, int index) {
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            // If suffix word[0..i] is palindrome, record index here
            if (isPalindrome(word, 0, i)) {
                node.palindromeSuffixIndices.add(index);
            }

            if (node.children[c] == null) {
                node.children[c] = new TrieNode();
            }
            node = node.children[c];
        }
        node.index = index;
        node.palindromeSuffixIndices.add(index); // whole word is palindrome suffix for itself
    }

    private void search(String[] words, int i, List<List<Integer>> result) {
        TrieNode node = root;
        String word = words[i];

        for (int j = 0; j < word.length(); j++) {
            // If this node is the end of a word and the remaining substring is palindrome, record pair
            if (node.index >= 0 && node.index != i && isPalindrome(word, j, word.length() - 1)) {
                result.add(Arrays.asList(i, node.index));
            }

            node = node.children[word.charAt(j) - 'a'];
            if (node == null) return;
        }

        // Check the palindromeSuffixIndices from this node
        for (int j : node.palindromeSuffixIndices) {
            if (i != j) {
                result.add(Arrays.asList(i, j));
            }
        }
    }

    private boolean isPalindrome(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        PalindromePairs solution = new PalindromePairs();

        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> pairs = solution.palindromePairs(words);

        System.out.println("Palindrome pairs: " + pairs);
        // Expected output: [[0,1],[1,0],[3,2],[2,4]]
    }
}
