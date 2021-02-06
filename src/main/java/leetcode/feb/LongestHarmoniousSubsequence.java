package leetcode.feb;
/**
 * Longest Harmonious Subsequence
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 *
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 *
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [1,1,1,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 */
public class LongestHarmoniousSubsequence {

    /**
     * BruteForce method.. O(n2)
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {

        if(nums.length < 1) return 0;
        int lhs = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            int num1 = nums[i];
            int count = 1; // start with the first element.

            int decCount = 1;
            int incCount = 1;
            boolean foundValidDiff = false;
            boolean foundIncreasingPattern = false;
            boolean foundDecreasingPattern = false;
            for(int j=i+1; j<nums.length; j++){
                int num2 = nums[j];
                if(Math.abs(num1 - num2) == 1){ // difference has to be 1 between elements
                    if(foundIncreasingPattern){ // only see if num2 >= num1
                        if(num2 >= num1) incCount++;
                    }else if(foundDecreasingPattern){
                        if(num2 <= num1) decCount ++;
                    }
                    if(num1 < num2 && !foundIncreasingPattern){ // increasing value branch
                        foundIncreasingPattern = true;
                        incCount ++;
                    }else if(num1 > num2 && !foundDecreasingPattern) { // decreasing branch
                        foundDecreasingPattern = true;
                        decCount++;
                    }
                    foundValidDiff = true;
                }else if(num1 == num2){
                    count++;
                }
            }
            if(!foundValidDiff) {
                count = 0;
            }else {
                count = Math.max(incCount, decCount);
            }
            lhs = Math.max(lhs, count);
        }
        return lhs;
    }
}
