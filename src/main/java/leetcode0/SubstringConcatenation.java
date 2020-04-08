package leetcode0;


import java.util.*;

/**
 * 30. Substring with Concatenation of All Words
 * Hard
 *
 * 646
 *
 * 1027
 *
 * Favorite
 *
 * Share
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 *
 *
 * Example 1:
 *
 * Input:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 *
 * Input:
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * Output: []
 *
 * "barfoofoobarthefoobarman"
 * ["bar","foo","the"]
 *
 *
 *
 "lingmindraboofooowingdingbarrwingmonkeypoundcake"
 ["fooo","barr","wing","ding","wing"]

 [13]
 *
 * output: [6,9,12]
 */
public class SubstringConcatenation {

    public static void main(String[] args){
        SubstringConcatenation solution = new SubstringConcatenation();
        String s = "barfoothefoobarman";
        String[] w = new String[]{"foo","bar"};
        List<Integer> res = solution.findSubstring(s, w);
        if(!res.isEmpty()){
            for(Integer i: res){
                System.out.println(i);
            }
        }else {
            System.out.println("empty");
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0) return res;
        int N = words[0].length();
        int totalLength = N * words.length;
        if(s.length() < totalLength) return res;
        if(s == null || s.isEmpty() || s.length() < N) return res;

        List<String> wordList = Arrays.asList(words);

        int i = 0;
        while( i<=s.length() - N){
            String s1 = s.substring(i, i+N);
            if(wordList.contains(s1)){
                List<String> list = new ArrayList<>(wordList);
                boolean match = helper(s.substring(i), list, N);
                if(match == true){
                    res.add(i);
                    i = i + 1;
                }else {
                    i = i + 1;
                }
            }else {
                i = i+1;
            }
        }
        return res;
    }

    boolean helper(String s, List<String> wordList, int N){
        if(wordList.isEmpty()) return true;

        if(s == null || s.length() == 0 || (s.length() < N)  && !wordList.isEmpty()){
            return false;
        }

        String x = s.substring(0, N);
        if(wordList.contains(x)){
            wordList.remove(x);
            return helper(s.substring(N), wordList, N);
        }
        return false;
    }

}
