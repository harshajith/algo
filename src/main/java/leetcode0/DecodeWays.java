package leetcode0;

import java.util.Map;


/**
 * Decodeways using dynamic programming
 */
public class DecodeWays {

    private static Map<Integer, Character> map;

    public static void main(String[] args){
        DecodeWays decodeWays = new DecodeWays();

        int numWays = decodeWays.helper("5616");
        System.out.println(numWays);
    }



    private int helper(String s){
        int[] dp = new int[s.length()+1]; // number of ways to decode of string of given length

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i=2; i<= s.length(); i++){
            int firstDigit = Integer.valueOf(s.substring(i-1, i));
            int twoDigit = Integer.valueOf(s.substring(i-2, i));

            if(firstDigit >= 1){
                dp[i] += dp[i-1];
            }

            if(twoDigit >= 10 && twoDigit <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }


}
