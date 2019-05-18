package com.harsha.cs.indeed;

import java.util.*;

/**
    1   2    4
     \ /    / \
      3    5   8
       \ /   \  \
       6      7   10

 */

// FindNodesWithZeroAndOneParent()
// [1, 2, 4] Individuals with zero parents
// [5, 7, 8, 10] Individuals with exactly one parent

public class ParentChild {

    public static void main(String[] args){
        int[][] parentChildPairs = new int[][]{
                {1,3, 4}, {2,3,5}, {3,6}, {5,6}, {5,7}, {4,5}, {4,8}, {8,10}
        };
        getIndividualsWithZeroParents(parentChildPairs);
        getIndividualsWithExactlyOneParent(parentChildPairs);
    }

    public static Set<Integer> getIndividualsWithZeroParents(int[][] input){
        Set<Integer> parents = new HashSet<>();
        Set<Integer> children = new HashSet<>();

        for(int r=0; r<input.length;r++){
            parents.add(input[r][0]);
            children.add(input[r][1]);
        }

        parents.removeAll(children);
        System.out.println(parents);
        return parents;
    }

    public static Set<Integer> getIndividualsWithExactlyOneParent(int[][] input){
        Set<Integer> result = new HashSet<>();
        Map<Integer, Integer> parentCountMap = new HashMap<>();

        for(int r=0; r<input.length;r++){
            int child = input[r][1];
            parentCountMap.put(child, parentCountMap.get(child) != null ? parentCountMap.get(child)  + 1 : 1);
        }

        for(Integer child: parentCountMap.keySet()){
            if(parentCountMap.get(child).equals(1)){
                result.add(child);
            }
        }
        System.out.println(result);
        return result;
    }

}
