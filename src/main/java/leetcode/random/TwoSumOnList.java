package leetcode.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value. Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible. Return a list of ids of selected elements. If no pair is possible, return an empty list.
 *
 * Example 1:
 *
 * Input:
 * a = [[1, 2], [2, 4], [3, 6]]
 * b = [[1, 2]]
 * target = 7
 *
 * Output: [[2, 1]]
 *
 * Explanation:
 * There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
 * Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
 */
public class TwoSumOnList {

    public List<List<Integer>> findSum(List<List<Integer>> a, List<List<Integer>> b, int total){
        Map<Integer, Integer> aMap = new HashMap<>();
        Map<Integer, Integer> bMap = new HashMap<>();

        List<List<Integer>> result = new ArrayList<>();

        for(List<Integer> l : a){
            aMap.put(l.get(1), l.get(0));
        }
        for(List<Integer> l : b){
            bMap.put(l.get(1), l.get(0));
        }

        for(Integer aVal: aMap.keySet()){
            for(Integer bval: bMap.keySet()){
                int x = aVal + bval;
                if(x <= total) {
                    List<Integer> index = new ArrayList<>();
                    index.add(aMap.get(aVal));
                    index.add(bMap.get(bval));
                    result.add(index);
                }
            }
        }

        return result;
    }

}
