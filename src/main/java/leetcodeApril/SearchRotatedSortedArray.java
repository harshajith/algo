package leetcodeApril;

/**
 * Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchRotatedSortedArray {

    /**
     * Total complexity O(log n) + O(log n) => O (log n)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums.length < 1) return -1;

        int left = 0;
        int right = nums.length-1;
        // find the pivot point

        while(left < right){ // O(log n)
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        int start = left; // pivot point
        left = 0;
        right = nums.length - 1;

        if(nums[start] <= target && nums[right] >= target){
            left = start;
        }else {
            right = start - 1;
        }

        while(left <= right){ // O(log n)
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Binary search O (log n)
     * @param nums
     * @param target
     * @param start
     * @param end
     * @return
     */
    private int search(int[] nums, int target, int start, int end){
        int mid = start + (end-start)/2;
        if(start >= end) return -1;

        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] > target){
            return search(nums, target, start, mid-1);
        }else {
            return search(nums, target, mid+1, end);
        }
    }
}
