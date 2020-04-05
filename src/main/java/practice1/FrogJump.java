package practice1;

import java.util.*;

/**
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 *  *
 *  * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 *  *
 *  * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
 *  *
 *  * Note:
 *
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 231.
 * The first stone's position is always 0.
 * Example 1:
 *
 * [0,1,3,5,6,8,12,17]
 *
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 *
 * Return true. The frog can jump to the last stone by jumping
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
 * 2 units to the 4th stone, then 3 units to the 6th stone,
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 * Example 2:
 *
 * [0,1,2,3,4,8,9,11]
 *
 * Return false. There is no way to jump to the last stone as
 * the gap between the 5th and 6th stone is too large.
 */
public class FrogJump {

    public static void main(String[] args){
        int[] input = new int[]{0,1,2,3,4,8,9,11};
        System.out.println(canCross(input));

    }

    public static boolean canCross(int[] input){

        Set<Integer> positions = new HashSet<>();
        for(Integer a: input){
            positions.add(a);
        }

        Stack<Integer> path = new Stack<>();

        Stack<Integer> jumps = new Stack<>();
        Stack<Integer> stoneLocation = new Stack<>();
        int lastStone = input[input.length-1];
        jumps.push(0);
        stoneLocation.push(0);

        while(!stoneLocation.isEmpty()){
            int location = stoneLocation.pop();
            int lastJump = jumps.pop();
            if(location == lastStone){
                return true;
            }else {
                for(int i=lastJump-1; i<=lastJump+1; i++){
                    Integer nextJumpLocation = Integer.valueOf(location + i);
                    if(nextJumpLocation<0 || nextJumpLocation == 0 || location == nextJumpLocation) continue;
                    if(positions.contains(nextJumpLocation)){
                        stoneLocation.push(nextJumpLocation);
                        jumps.push(i);
                    }
                }
            }
        }

        return false;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfsSearch(graph, 0, res, path);

        return res;
    }

    private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfsSearch(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }
}
