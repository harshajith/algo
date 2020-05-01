package leetcode.april;

/**
 * Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {

    //==================== =====================================

    public int maxSubArraySolution1(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        int max = 0;
        for(int i=0; i<nums.length; i++){
            // First case
            if(i==0 && nums[i] <= 0){
                max = nums[i];
                nums[i] = 0;
                continue;
            }else if(i==0 && nums[i] > 0) {
                max = nums[i];
                continue;
            }


            // Consequent case
            if(nums[i-1] + nums[i] <= 0){
                max = Math.max(max, nums[i-1] + nums[i]);
                nums[i] = 0;
            }else {
                nums[i] = nums[i-1] + nums[i];
                max = Math.max(max, nums[i]);
            }
        }
        return max;
    }


    //=========================================================================

    public int maxSubArraySolution2(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                max = Math.max(max, sum(nums, i, j));
            }
        }
        return max;

    }

    /**
     * Memorization is catered
     * @param nums
     * @param i
     * @param j
     * @return
     */
    private int sum(int[] nums, int i, int j) {
        int[][] mem = new int[nums.length][nums.length];
        if(mem[i][j] != 0){
            return mem[i][j];
        }else {
            int sum = nums[i];
            while(j < i){
                sum += nums[j];
                j++;
            }
            mem[i][j] = sum;
            return mem[i][j];
        }
    }


    public static void main(String[] args){
        MaximumSubarray m = new MaximumSubarray();
        int[] a = new int[]{1, 2};
        System.out.println(m.maxSubArraySolution1(a));
    }
}
