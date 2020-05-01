package leetcode.random;

/**
 * Longest Common Subsequence
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * If there is no common subsequence, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 */
public class LongestCommonSubsequence {

    int m = 0;
    int n= 0;



    public int method1(String text1, String text2) {
        if(text1.length() < 1 || text2.length() < 1) return 0;
        char text1LastChar = text1.charAt(text1.length()-1);
        char text2LastChar = text2.charAt(text2.length()-1);

        if(text1LastChar == text2LastChar){
            return 1 + method1(text1.substring(0, text1.length()-1), text2.substring(0, text2.length()-1));
        }else {
            return Math.max(method1(text1, text2.substring(0, text2.length()-1)),
                    method1(text2, text1.substring(0, text1.length()-1)));
        }
    }

    public int LCS(String text1, String text2){
        int m = text1.length();
        int n = text2.length();

        int[][] DP = new int[m+1][n+1];

        int currentRow  = 1;
        int currentCol = 1;

        while(currentRow <= m){
            currentCol = 1;
            while(currentCol <= n){
                char text1FirstChar = text1.charAt(currentRow-1);
                char text2FirstChar = text2.charAt(currentCol-1);
                if(text1FirstChar == text2FirstChar){
                    DP[currentRow][currentCol] = DP[currentRow-1][currentCol-1] + 1;
                }else {
                    DP[currentRow][currentCol] = Math.max(DP[currentRow-1][currentCol], DP[currentRow][currentCol-1]);
                }
                currentCol++;
            }
            currentRow++;
        }
        return DP[m][n];
    }

}
