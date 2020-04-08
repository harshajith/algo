package leetcode;

/**
 * /**
 *  * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *  *
 *  * Example 1:
 *  *
 *  * Input: coins = [1, 2, 5], amount = 11
 *  * Output: 3
 *  * Explanation: 11 = 5 + 5 + 1
 *  * Example 2:
 *  *
 *  * Input: coins = [2], amount = 3
 *  * Output: -1
 *  * Note:
 *  * You may assume that you have an infinite number of each kind of coin.
 *  *
 *  * Accepted
 *
 *  */
public class CoinChangeDP {

    private static final int INF = 987654321;

    public int coinChange(int[] coins, int amount) {

        if (coins == null) throw new IllegalArgumentException("Coins array is null");
        if (coins.length == 0) throw new IllegalArgumentException("No coin values :/");

        final int N = coins.length;
        // Initialize table and set first row to be infinity
        int[][] DP = new int[N + 1][amount + 1];
        java.util.Arrays.fill(DP[0], INF);
        DP[1][0] = 0;

        // Iterate through all the coins
        for (int i = 1; i <= N; i++) {

            int coinValue = coins[i - 1];
            for (int j = 1; j <= amount; j++) {

                // Consider not selecting this coin
                DP[i][j] = DP[i - 1][j];

                // Try selecting this coin if it's better
                if (j - coinValue >= 0 && DP[i][j - coinValue] + 1 < DP[i][j])
                    DP[i][j] = DP[i][j - coinValue] + 1;
            }
        }

        // The amount we wanted to make cannot be made :/
        if (DP[N][amount] == INF) return -1;

        // Return the minimum number of coins needed
        return DP[N][amount];

    }

    public static void main(String[] args){
        CoinChangeDP coinChange = new CoinChangeDP();
        int[] a = new int[]{1,5,2};
        int res = coinChange.coinChange(a, 11);
        System.out.println(res);
    }



}
