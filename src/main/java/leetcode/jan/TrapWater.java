package leetcode.jan;


/**
 * 42. Trapping Rain Water
 * Hard
 *
 * 9624
 *
 * 147
 *
 * Add to List
 *
 * Share
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 * Accepted
 * 655,910
 * Submissions
 * 1,290,653
 */
public class TrapWater {

    public int trap(int[] height) {
        if(height == null || height.length < 0) return 0;
        int length = height.length;
        int[] maxRightArray = new int[length];
        int currentMax = height[length-1];
        for(int i=height.length-1; i>=0; i--){
            if(height[i] > currentMax){
                currentMax = height[i];
            }
            maxRightArray[i] = currentMax;
        }

        int counter = 0;
        int maxLeft = height[0];
        for(int i=1; i<length-1; i++){
            int water = Math.min(maxLeft, maxRightArray[i]) - height[i];
            if(water > 0){
                counter += water;
            }
            if(height[i] > maxLeft){
                maxLeft = height[i];
            }
        }
        return counter;
    }

    public static void main(String[] args){
        TrapWater trapWater = new TrapWater();
        int[] height = new int[]{4,2,0,3,2,5};
        System.out.println(trapWater.trap(height));
    }
}
