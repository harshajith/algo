package leetcode;

/**
 *
 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"
 */
public class LongestPelindrome {

    public String longestPalindrome(String s) {
        int length = s.length();

        boolean[][] table = new boolean[length][length];

        int start = 0;
        int maxLength = 1;
        // fill up the table
        for(int i=0; i<length; i++){ // if the length is one
            table[i][i] = true;
        }

        for(int i=0; i<length-1; i++){ // if the length is two
            if(s.charAt(i) == s.charAt(i+1)){
                table[i][i+1] = true;
                maxLength = 2;
                start = i;
            }
        }

        for(int k=3; k<=length; ++k){ // if the length is two onwards
            for(int i=0; i<length - k + 1; ++i){
                int j = k+i-1;

                if(table[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    table[i][j] = true;
                    if(maxLength < k){
                        maxLength = k;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args){
        LongestPelindrome lp = new LongestPelindrome();
        String lps = lp.longestPalindrome("cbbd");
        System.out.println(lps);
    }

}
