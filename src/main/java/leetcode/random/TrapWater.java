package leetcode.random;

/**
 *
 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

 Example:

 Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6
 */
public class TrapWater {
    class Solution {
        public int trap(int[] height) {

            int totalWater = 0;

            int maxSeen = 0;
            int[] maxRightHeight = new int[height.length];
            int maxSeenLeft = 0;

            // Get the max hight to the right for each bar
            for(int i=height.length-1; i>=0; i--){
                if(height[i] > maxSeen){
                    maxSeen = height[i];
                    maxRightHeight[i] = maxSeen;
                }else {
                    maxRightHeight[i] = maxSeen;
                }
            }

            for(int i=0; i<height.length; i++){
                totalWater += Math.max(Math.min(maxSeenLeft, maxRightHeight[i]) - height[i],0);
                if(height[i] > maxSeenLeft){
                    maxSeenLeft = height[i];
                }
            }

            return totalWater;
        }

    }
}
