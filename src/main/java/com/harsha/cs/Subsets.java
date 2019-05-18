package com.harsha.cs;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Harsha.H
 */
public class Subsets {

    private static Set uniqueIds = new HashSet();

    public void generateUniqueIds(int[] givenArray){
        int[] subset = new int[givenArray.length];
        helper(givenArray, subset, 0);
    }

    /**
     * Get all the subsets for the given array.
     * The algorithm goes like, if you pick or not pick the current item, how does it evolve.
     * @param givenArray
     * @param subset
     * @param i
     */
    private void helper(final int[] givenArray, int[] subset, int i) {
        if(i == givenArray.length) {
            addToSet(subset);
        } else {
            subset[i] = 0;
            helper(givenArray, subset, i+1);
            subset[i] = givenArray[i];
            helper(givenArray, subset, i+1);
        }

    }

    /**
     * Remove dups from the string.
     * @param subset
     */
    private void addToSet(int[] subset) {
        String str = Arrays.stream(subset).filter(x -> x != 0).mapToObj(a -> ((Integer)a).toString()).collect(Collectors.joining(","));
        uniqueIds.add(str);
    }


    public static void main(String[] args){
        Subsets subsets = new Subsets();
        int[] arr = {1,2,3};


        int m = 3;
        int[] newArray = Arrays.stream(arr).flatMap(a -> IntStream.iterate(a, j -> j).limit(m)).toArray();
        System.out.println(Arrays.toString(newArray)); // Create exploded array with elements of m times.

        subsets.generateUniqueIds(newArray);

        uniqueIds.stream().sorted(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(((String)o1).length() < ((String)o2).length()) return -1;
                else if(((String)o1).length() > ((String)o2).length()) return 1;
                else return 0;
            }
        }).forEach(System.out::println);
    }

}
