package leetcode.feb;


/**
 * 300. Longest Increasing Subsequence
 * Medium
 *
 * 6411
 *
 * 149
 *
 * Add to List
 *
 * Share
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int res = 1;
        for(int i=0; i<nums.length-1; i++){
            int currentLength = 1;
            int currentMax = nums[i];
            for(int j=i+1; j<nums.length; j++){
                if(currentMax < nums[j]){
                    currentLength++;
                    currentMax = nums[j];
                }
            }
            res = Math.max(res, currentLength);
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,1,0,3,2,3};
        LongestIncreasingSubsequence s = new LongestIncreasingSubsequence();
        System.out.println(s.lengthOfLIS(nums));
    }
}
