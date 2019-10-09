package aws.s3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Accepted
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] sortedCoins = mergeSort(coins, coins.length);
        int count = 0;

        for(int i=sortedCoins.length-1; i>=0; --i){

            int coinVal = sortedCoins[i]; // highest coin first
            if(amount < coinVal){
                continue;
            }else {
                int remainder = amount%coinVal;
                if(remainder == 0){
                    count += amount/coinVal;
                    break;
                }else {
                    count += amount/coinVal;
                    amount = remainder;
                }
            }
        }
        return count;
    }


    public static void main(String[] args){
        CoinChange coinChange = new CoinChange();
        int[] a = new int[]{1,5,2};
        int res = coinChange.coinChange(a, 11);
        System.out.println(res);
    }


    /**
     * Divide and Concour
     * @param a
     * @return
     */
    public int[] mergeSort(int[] a, int length){

        if(a.length < 2){
            return a;
        }

        int mid = length/2;
        int[] left = new int[mid];
        int[] right = new int[length-mid];

        for(int i=0; i<mid; i++){
            left[i] = a[i];
        }

        for(int i=mid; i<length; i++){
            right[i-mid] = a[i];
        }

        mergeSort(left, mid);
        mergeSort(right, length-mid);

        merge(a, left, right, mid, length-mid);

        return a;
    }

    private void merge(int[] a, int[] left, int[] right, int l, int r) {
        int i=0; int j=0; int k=0;
        while(i<l && j<r){
            if(left[i] < right[j]){
                a[k++] = left[i++];
            }else {
                a[k++] = right[j++];
            }
        }

        while(i<l){
            a[k++] = left[i++];
        }
        while(j<r){
            a[k++] = right[j++];
        }
    }
}
