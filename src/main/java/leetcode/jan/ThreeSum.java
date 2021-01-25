package leetcode.jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * Medium
 *
 * 9192
 *
 * 961
 *
 * Add to List
 *
 * Share
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * TODO
 */
public class ThreeSum {

    public static void main(String[] args){
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>>  result = threeSum.threeSum(nums);
        for(List<Integer> triplet: result){
            System.out.println(triplet.toString());
        }
    }
    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i < nums.length; i++){
           if(nums[i] <= 0){
               if(i == 0 ){
                   findTwoSumResult(nums, result, i);
               }else {
                   if(nums[i] != nums[i-1]){
                       findTwoSumResult(nums, result, i);
                   }
               }

           }
        }
        return result;
    }

    private void findTwoSumResult(int[] nums, List<List<Integer>> result, int i) {
        List<Integer> twoSum = findTwoSum(nums, i + 1, nums.length - 1, nums[i] == 0 ? 0 : -nums[i]);
        if (!twoSum.isEmpty()) {
            List<Integer> triplet = new ArrayList<>();
            triplet.add(nums[i]);
            triplet.addAll(twoSum);
            result.add(triplet);
        }
    }

    private List<Integer> findTwoSum(int[] nums, int l, int h, int target){
        List<Integer> twoSum = new ArrayList<>();
        while(l < h){
            if(nums[l] + nums[h] < target){
                l++;
            }else if(nums[l] + nums[h] > target){
                h--;
            }else {
                twoSum.add(nums[l]);
                twoSum.add(nums[h]);
                return twoSum;
            }
        }
        return twoSum;
    }
}
