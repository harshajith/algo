package leetcode0;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 Example:

 Input: [2,3,1,1,4]
 Output: 2
 Explanation: The minimum number of jumps to reach the last index is 2.
 Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Note:

 You can assume that you can always reach the last index.

 Accepted
 194,935
 Submissions
 674,912
 */
public class JumpGame2 {

    public static void main(String[] args){
        int[] a = new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        JumpGame2 jumpGame2 = new JumpGame2();
        System.out.println(jumpGame2.minimumJumpsToLastStone(a));

    }


    public int minimumJumpsToLastStone(int[] input){

        Map<Integer, Integer> nodeJumpMap = new HashMap<>();
        int[] minJumps = new int[input.length];
        for(int i=0; i<input.length; i++) minJumps[i] = Integer.MAX_VALUE;

        minJumps[0] = 0;
        int lastPosition = input.length-1;
        Queue<Integer> positions = new LinkedList<>();

        positions.add(0);

        while(!positions.isEmpty()) {
            int position = positions.poll();
            if(position != lastPosition){
                int jumpLength = input[position];
                for (int i = 1; i <= jumpLength; i++) {
                    int nextPosition = position + i;
                    if(nextPosition < input.length){
                        if(minJumps[nextPosition] > minJumps[position] + 1){
                            minJumps[nextPosition] = minJumps[position] + 1;
                        }
                        positions.add(nextPosition);
                    }
                }
            }

        }
        return minJumps[lastPosition];
    }




}
