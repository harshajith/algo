package leetcode0;


import java.util.*;

/**
 * You have some sticks with positive integer lengths.
 *
 * You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.
 *
 * Return the minimum cost of connecting all the given sticks into one stick in this way.
 *
 *
 *
 * Example 1:
 *
 * Input: sticks = [2,4,3]
 * Output: 14
 * Example 2:
 *
 * Input: sticks = [1,8,3,5]
 * Output: 30
 *
 *
 * Constraints:
 *
 * 1 <= sticks.length <= 10^4
 * 1 <= sticks[i] <= 10^4
 */
public class ConnectSticks {



    public int connectSticks(int[] sticks) {

        Queue<Integer> queue = new PriorityQueue<>();
        for(int i: sticks) queue.add(i);

        int total = 0;
        while(queue.size() > 1){
            total += queue.poll() + queue.poll();
            queue.add(total);
        }
        return total;
    }

    public static void main(String[] args){
        int[] input = new int[]{1,2,5,6};
        ConnectSticks connectSticks = new ConnectSticks();
        int minCost = connectSticks.connectSticks(input);
        System.out.println(minCost);
    }
}
