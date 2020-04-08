package leetcode0;

import java.util.HashMap;

/**
 * 76. Minimum Window Substring
 * Hard
 *
 * 2912
 *
 * 208
 *
 * Favorite
 *
 * Share
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * Accepted
 * 286,667
 * Submissions
 * 890,181
 */
public class MinimumWindowSubstring {


    public static void main(String[] args){
        String s = "ADOBECODEBANCABC";
        String t =  "ABC";
        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        String res = sol.minWindow(s, t);
        System.out.println(res);

    }






    public String minWindow(String s, String t) {

        HashMap<Character, Integer> goal = new HashMap<>();
        int goalSize = t.length();
        int minLen = Integer.MAX_VALUE;
        String result = "";

        //target dictionary
        for(int k=0; k<t.length(); k++){
            goal.put(t.charAt(k), goal.getOrDefault(t.charAt(k), 0)+1);
        }

        int i=0; // start
        int total=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int j=0; j<s.length(); j++){
            char c = s.charAt(j);
            if(!goal.containsKey(c)){
                continue;
            }

            //if c is a target character in the goal, and count is < goal, increase the total
            int count = map.getOrDefault(c, 0);
            if(count<goal.get(c)){
                total++;
            }

            map.put(c, count+1);

            //when total reaches the goal, trim from left until no more chars can be trimmed.
            if(total==goalSize){
                char currentStartChar = s.charAt(i);
                while(!goal.containsKey(currentStartChar) || map.get(currentStartChar)>goal.get(currentStartChar)){
                    if(goal.containsKey(currentStartChar) && map.get(currentStartChar)>goal.get(currentStartChar)){
                        map.put(currentStartChar, map.get(currentStartChar)-1);
                    }

                    i++;
                }

                if(minLen>j-i+1){
                    minLen = j-i+1;
                    result = s.substring(i, j+1);
                }
            }
        }

        return result;
    }
}
