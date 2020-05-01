package leetcodeApril;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Last Stone Weight
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 *
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *
 *
 * Note:
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        if(stones.length < 1 || stones.length > 30) throw new RuntimeException();
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comparator);
        for(int i: stones){
            if(i < 1 || i > 1000) throw new RuntimeException();
            priorityQueue.add(i);
        }
        int lastStoneWeight = 0;
        while(!priorityQueue.isEmpty()){
            int x = priorityQueue.poll();
            int y  = 0;
            if(priorityQueue.isEmpty()){
                lastStoneWeight = x;
                break;
            }else {
                y = priorityQueue.poll();
            }

            if(x - y > 0) priorityQueue.add(x-y);
        }

        return lastStoneWeight;
    }

}
