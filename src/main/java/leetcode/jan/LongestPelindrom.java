package leetcode.jan;


/**
 * 5. Longest Palindromic Substring
 * Medium
 *
 * 9469
 *
 * 634
 *
 * Add to List
 *
 * Share
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters (lower-case and/or upper-case),
 * Accepted
 * 1,183,598
 * Submissions
 * 3,896,850
 */
public class LongestPelindrom {
    public String longestPalindrome(String s) {

        if(s.length() < 2) return s;

        int start = 0;
        int end = 0;
        int currentMax = Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++){
            int l1 = findLongestPalindrome(s, i, i);
            int l2 = findLongestPalindrome(s, i, i+1);
            int len = Math.max(l1, l2);
            if(len > end - start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end+1);

    }

    public int findLongestPalindrome(String s, int l, int r){
        while(l >= 0 && r < s.length()){
            if(s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }else {
                break;
            }
        }
        return (r - l -1);
    }
}
