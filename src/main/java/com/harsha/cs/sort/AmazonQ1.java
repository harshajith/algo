package com.harsha.cs.sort;

import java.util.HashSet;
import java.util.Set;

/**
 * Let’s say you have two input arrays with sorted elements. Find the union.

 a[] = {2, 10, 14, 19, 51, 71}
 b[] = {2, 9, 19, 40, 51}

 Union = {2, 9, 10, 14, 19, 40, 51}

 */
public class AmazonQ1 {

    private static Set<Integer> uniqueSet = new HashSet<>();

    /**
     * Complexity O(n)
     * @param a
     * @param b
     * @return
     */
    public static void union(int[] a, int[] b){
        int i = 0;
        int j= 0;
        int k = 0;
        while(i < a.length && j < b.length){
            if(a[i] == b[i]){
                uniqueSet.add(a[i++]); // O(1)
                j++;
            }else {
                uniqueSet.add(a[i++]);
                uniqueSet.add(b[j++]);
            }
        }

        while(i < a.length){
            uniqueSet.add(a[i++]);
        }

        while(j < b.length){
            uniqueSet.add(b[j++]);
        }
    }

    public static void main(String[] args){
        int a[] = {2, 10, 14, 19, 51, 71};
        int b[] = {2, 9, 19, 40, 51};

        union(a, b);
        uniqueSet.forEach(System.out::println);
    }
}
