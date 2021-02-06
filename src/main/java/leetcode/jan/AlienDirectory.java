package leetcode.jan;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 953. Verifying an Alien Dictionary
 * Easy
 * Add to List
 *
 * Share
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */
public class AlienDirectory {

    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for(int i=0; i<order.length(); i++){
            char c = order.charAt(i);
            index[c - 'a'] = i;
        }
        search: for(int k=0; k<words.length-1; k++){
            String word1 = words[k];
            String word2 = words[k+1];
            String minLengthWord = findMinLengthWord(word1, word2);
            for(int i=0; i<minLengthWord.length(); i++){
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(i);
                if(c1 != c2){
                    if(index[c1-'a'] > index[c2-'a']) {
                        return false;
                    }
                    continue search;
                }
            }
            if(word1.length() > word2.length()) return false;
        }

        return true;
    }

    private String findMinLengthWord(String word1, String word2) {
        int minLength = Math.min(word1.length(), word2.length());
        String result = minLength == word1.length() ? word1 : word2;
        return result;
    }
}
