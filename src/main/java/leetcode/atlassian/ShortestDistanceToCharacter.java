package leetcode.atlassian;

import java.util.Arrays;

/**
 * Shortest Distance to a Character
 * Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the shortest distance from s[i] to the character c in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "loveleetcode", c = "e"
 * Output: [3,2,1,0,1,0,0,1,2,2,1,0]
 * Example 2:
 *
 * Input: s = "aaab", c = "b"
 * Output: [3,2,1,0]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s[i] and c are lowercase English letters.
 * c occurs at least once in s.
 */
public class ShortestDistanceToCharacter {

    /**
     * Time complexity is O(n)
     * Space complexity  is O(n)
     * @param s
     * @param c
     * @return
     */
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];        Arrays.fill(result, s.length()+1);
        char[] arr = s.toCharArray();
        int lastFoundLocation = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == c){
                result[i] = 0;
                int k = i-1;
                while(k > lastFoundLocation){ // when you found a char, it backtracks until lastFound location.
                    if(result[k] > i-k){
                        result[k] = i-k;
                        k--;
                    }else {
                        break;
                    }
                }
                lastFoundLocation = i;
            }else {
                if(lastFoundLocation != -1){
                    result[i] = i-lastFoundLocation;
                }
            }
        }
        return result;
    }
}
