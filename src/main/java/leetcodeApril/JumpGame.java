package leetcodeApril;


import java.util.HashSet;
import java.util.Stack;

/**
 * Jump Game
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {


    public boolean canJump1(int[] nums) {
        int lastIndex = nums.length-1;
        for(int i=nums.length-1; i>=0; i--){
            if(i+nums[i] >= lastIndex){
                lastIndex = i;
            }
        }
        return lastIndex == 0;

    }


    /**
     * DFS, takes too long for large inputs
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        HashSet<Integer> visited = new HashSet<>();
        if(nums == null || nums.length < 1) return false;

        int lastIndex = nums.length-1;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        visited.add(0);

        while(!stack.isEmpty()){
            int index = stack.pop();
            if(index == lastIndex) return true;

            int maxJumps = nums[index];
            if(maxJumps > 0){
                for(int i=1; i<=maxJumps; i++){
                    int nextIndex = index + i;
                    if(!visited.contains(nextIndex) && nextIndex <= lastIndex){
                        stack.add(nextIndex);
                    }
                }
            }

        }
        return false;
    }

}
