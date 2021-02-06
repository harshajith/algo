package leetcode.jan;


import java.util.Arrays;

/**
 * Packaging optimally
 * assume you have box sizes of 3, 5, 7. If somebody get 34 items what is the minimum number of boxes required
 */
public class AmazonPackingProblem {

    public int calculateMinimumBoxesRequired(int[] sizes, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i=1; i<=amount; i++){
            for(int j=0; j<sizes.length; j++){
                if(i >= sizes[j]){
                    int remain = amount = sizes[j];
                    dp[i] = Math.min(dp[i], 1 + dp[remain]);
                }
            }
        }

        if(dp[amount] > amount) return -1;
        return dp[amount];
    }
}
