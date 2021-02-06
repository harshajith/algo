package leetcode.jan;

/**
 * Arranging Coins
 *
 * Solution
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 *
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example 1:
 *
 * n = 5
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 *
 * n = 8
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * Because the 4th row is incomplete, we return 3.
 */
public class ArrangeCoins {

    public int arrangeCoins1(int n) {
        int steps = 0;
        while(n >= steps+1){
            n = n - ++steps;
        }
        return steps;
    }


    public int arrangeCoins2(int n) {
        if(n < 1) return 0;
        return countSteps(n, 1);
    }

    /**
     *
     * @param n
     * @param steps
     * @return
     */
    private int countSteps(int n, int steps) {
        if(n < steps){
            return steps-1;
        }
        return countSteps(n-steps, steps+1);
    }


    public int arrangeCoins(int n) {

        int row = 1;
        if(n < 1) return 0;

        return fillRow(n, row);
    }

    public int fillRow(int n, int rowNum){
        if(n < rowNum){
            return rowNum - 1;
        }else {
            return fillRow(n-rowNum, rowNum+1);
        }
    }
    public static void main(String[] args){
        ArrangeCoins ac = new ArrangeCoins();
        System.out.println(ac.arrangeCoins2(14));
    }

}
