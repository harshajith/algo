package leetcode.feb;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 242. Valid Anagram
 * Easy
 *
 * 2297
 *
 * 158
 *
 * Add to List
 *
 * Share
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * Accepted
 * 748,476
 * Submissions
 * 1,279,794
 */
public class ValidAnagram {

    public static void main(String[] args){
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for(char c: s.toCharArray()){
            a1[c-'a']++;
        }
        for(char c: t.toCharArray()){
            a1[c-'a']--;
            if(a1[c-'a'] < 0) return false;
        }

        return true;
    }

    /**
     * More memory consumption
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        for(char c: s.toCharArray()){ // count the frequency of each char and record in a map. O(n)
            mapS.put(c, mapS.getOrDefault(c, 0)+1);
        }

        Map<Character, Integer> mapT = new HashMap<>();
        for(char a: t.toCharArray()){ // O(n)
            mapT.put(a, mapT.getOrDefault(a, 0) + 1);
        }

        if(mapS.size() != mapT.size()) return false;

        for(char k: mapS.keySet()){ // O(n)
            if(!mapS.get(k).equals(mapT.get(k))) return false;
        }

        return true;
    }
}
