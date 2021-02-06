package leetcode.jan;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1539. Kth Missing Positive Number
 * Easy
 *
 * 737
 *
 * 30
 *
 * Add to List
 *
 * Share
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 *
 * Find the kth positive integer that is missing from this array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 * Example 2:
 *
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * arr[i] < arr[j] for 1 <= i < j <= arr.length
 */
public class FindKthMissingElement {

    // O(n) time and O(1) space.
    public int findKthPositive(int[] arr, int k) {
        if(k < arr[0]) return k;

        k -= arr[0] -1; // deduct missing items before starting the array elements.
        for(int i=0; i<arr.length-1; i++){
            int missingItems  = arr[i+1] - arr[i] -1;
            if(k <= missingItems){
                return arr[i] + k;
            }
            k -= missingItems;
        }

        return arr[arr.length-1] + k;
    }

    public static void main(String[] args){
        int[] arr = new int[]{2,3,4,7,11};
        FindKthMissingElement findKthMissingElement = new FindKthMissingElement();
        System.out.println(findKthMissingElement.findKthPositive(arr, 5));
    }
}
