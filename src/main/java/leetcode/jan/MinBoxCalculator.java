package leetcode.jan;

import java.util.Arrays;

/**
 *  In a shop there are boxes of different sizes, 1, 3, 5, 9. A person needs to get 33 items.
 *  What is the minimum number of boxes required.
 */
public class MinBoxCalculator {

    public static void main(String[] args){
        MinBoxCalculator minBoxCalculator = new MinBoxCalculator();
        int[] sizes = new int[]{1,3,5,8};
        System.out.println(minBoxCalculator.calculateMinBoxesRequired(sizes, 65));
    }


    /**
     * Calculate minimum number of boxes needed to fill the amount.
     * @param sizes
     * @param amount
     * @return
     */
    public int calculateMinBoxesRequired(int[] sizes, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            for(int j=0; j<sizes.length; j++){
                if(sizes[j] <= i){
                    dp[i] = Math.min(dp[i], 1 + dp[i-sizes[j]]);
                }
            }
        }

        if(dp[amount] > amount) return -1; // this amount cannot be formed with the given coins
        return dp[amount];
    }

}
