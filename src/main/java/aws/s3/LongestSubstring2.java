package aws.s3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *  * Example 1:
 *  *
 *  * Input: "abcabcbb"
 *  * Output: 3
 *  * Explanation: The answer is "abc", with the length of 3.
 *  * Example 2:
 *  *
 *  * Input: "bbbbb"
 *  * Output: 1
 *  * Explanation: The answer is "b", with the length of 1.
 *  * Example 3:
 *  *
 *  * Input: "pwwkew"
 *  * Output: 3
 *  * Explanation: The answer is "wke", with the length of 3.
 *  *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *  *
 */
public class LongestSubstring2 {



    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            Integer index = map.get(c);

            if(map.containsKey(c) && map.get(c) >= start){
                start = map.get(c) + 1;
            }

            map.put(c, i);

            max = Math.max(max, i-start+1);
        }

        return max;
    }

    public  static void main(String[] args){
        LongestSubstring2 longestSubstring = new LongestSubstring2();
        int length = longestSubstring.lengthOfLongestSubstring(
                "pwwkewxyvf");
        System.out.println(length);
    }
}
