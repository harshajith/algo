package leetcode.april;

import java.util.HashMap;

/**
 * Contiguous Array
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 *
 */
public class ContiguousArray {


    /**
     * Brute force method -- (O(n2)
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        if(nums.length > 50000) throw new RuntimeException();
        int maxLength = 0;
        for(int i=0; i<nums.length;i++){
            int zeros = 0;
            int ones = 0;
            int subMax = 0;
            for(int j=i; j<nums.length; j++){
                if(nums[j] == 0){
                    zeros++;
                }else {
                    ones++;
                }
                if(zeros == ones){
                    subMax = Math.max(subMax, (j - i) +1);
                }
            }
            maxLength = Math.max(maxLength, subMax);
        }
        return maxLength;
    }


    public int findMaxLength1(int[] nums) {
        if(nums.length > 50000) throw new RuntimeException();

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) {
                count = count - 1;
            }else {
                count = count + 1;
            }
            if(map.containsKey(count)){ // if same number is found in the map before, there is a potential solution between this two.
                maxLength = Math.max(maxLength, i - map.get(count));
            }else {
                map.put(count, i);
            }
        }
        return maxLength;
    }
}
