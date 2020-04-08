package leetcode0;


/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.
 *
 * Given the encoded message containing digits and the character '*', return the total number of ways to decode it.
 *
 * Also, since the answer may be very large, you should return the output mod 109 + 7.
 *
 * Example 1:
 * Input: "*"
 * Output: 9
 * Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 * Example 2:
 * Input: "1*"
 * Output: 9 + 9 = 18
 */
public class DecodeWays2 {


    public int solution(String s){

        int[] dp = new int[s.length() + 1];
        int[] vector = new int[]{1,2,3,4,5,6,7,8,9};

        dp[0] = 1;

        if(s.charAt(0) == '0'){
            dp[1] = 0;
        }else if(s.charAt(0) == '*'){
            dp[1] = 9;
        }else {
            dp[1] = 1;
        }

        for(int i=2; i<=s.length(); i++){
            String firstChar = s.substring(i-1, i);
            if(firstChar.equals("*")){
                dp[i] += 9;
                dp[i] += dp[i-1];
            }else {
                int digitOne = Integer.valueOf(firstChar);
                if(digitOne >= 1){
                    dp[i] += dp[i-1];
                }
            }

            String firstTwoChar = s.substring(i-2, i);
            if(firstTwoChar.charAt(0) == '*' && firstTwoChar.charAt(1) != '*'){
                for(int j=0; j<2; j++){
                    int twoCharsVal = Integer.valueOf(String.valueOf(vector[j])+firstTwoChar.charAt(1));

                    if(twoCharsVal >= 10 && twoCharsVal <= 26){
                        dp[i] += 1;
                    }
                }
                dp[i] += dp[i-2];
            }else if(firstTwoChar.charAt(0) != '*' && firstTwoChar.charAt(1) == '*'){
                for(int j=0; j<9; j++){
                    Integer twoChars = Integer.valueOf(firstTwoChar.charAt(0) + String.valueOf(vector[j]));
                    if(twoChars >= 10 && twoChars <= 26){
                        dp[i] += 1;
                    }
                }
                dp[i] += dp[i-2];
            }else if(firstTwoChar.charAt(0) == '*' && firstTwoChar.charAt(1) == '*'){
                for(int j=0; j<2; j++){
                    for(int k=0; k<9; k++){
                        Integer twoChars = Integer.valueOf(vector[j] + "" + vector[k]);
                        if(twoChars >= 10 && twoChars <= 26){
                            dp[i] += 1;
                        }
                    }
                }
                dp[i] += dp[i-2];
            }else {
                Integer twoChars = Integer.valueOf(firstTwoChar);
                if(twoChars <= 26){
                    dp[i] += dp[i-2];
                }
            }
        }

        return dp[s.length()];
    }


    public static void main(String[] args){
        String input = "10";
        DecodeWays2 decodeWays2 = new DecodeWays2();
        int ways = decodeWays2.solution(input);
        System.out.println(ways);
    }


}
