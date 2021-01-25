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
        System.out.println(ac.arrangeCoins(14));
    }

}
