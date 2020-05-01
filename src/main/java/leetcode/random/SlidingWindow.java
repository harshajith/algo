package leetcode.random;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 */
public class SlidingWindow {



    public int[] maxSlidingWindow(int[] nums, int k) {

        int start = 0;
        int current = Integer.MIN_VALUE;
        int[] result = new int[nums.length -2];

        for(int i=0; i<nums.length-k+1; i++){
            int c = Integer.MIN_VALUE;
            for(int j=i; j<i+k; j++){
                if(nums[j] > c){
                    c = nums[j];
                }
            }
            result[i] = c;
        }

        return result;
    }

    public static void main(String[] args){
        SlidingWindow window = new SlidingWindow();
        int[] a = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = window.maxSlidingWindow(a, 3);
        for(int x: res){
            System.out.println(x);
        }
    }
}
