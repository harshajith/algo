package leetcode.jan;


import java.util.Arrays;

/**
 * 322. Coin Change
 * Medium
 *
 * 5836
 *
 * 175
 *
 * Add to List
 *
 * Share
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 * Example 4:
 *
 * Input: coins = [1], amount = 1
 * Output: 1
 * Example 5:
 *
 * Input: coins = [1], amount = 2
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {

    public static void main(String[] args){
        CoinChange coinChange = new CoinChange();
        int[] coins = new int[]{1,2,5};
        System.out.println(coinChange.changeCoins( 9,coins));
    }

    /**
     * Runtime :
     * Time complexity: O(n * m) ~ O(n2)
     * Space complexity: O(n)
     * @param val
     * @param coins
     * @return
     */
    public int changeCoins(int val, int[] coins){
        int[] dp = new int[val+1]; // hold the minimum number of coins required to make the amount
        Arrays.fill(dp, val+1);

        dp[0] = 0;
        for(int i=1; i<=val; i++){
            for(int j=0; j<coins.length; j++){
                if(coins[j] <= i){
                    int rem = i - coins[j];
                    dp[i] = Math.min(dp[i], 1 + dp[rem]);
                }
            }
        }
        if(dp[val] > val) return -1;
        return dp[val];
    }
}
