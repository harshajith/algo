package com.harsha.cs.sort;

import java.util.Arrays;

/**
 * Quicksort algorithm
 */
public class QuickSort {


    /**
     * Recursive algorithm to partition array into two halves based on the pivot
     * left subarray is less than the pivot value and right sub array is greater than the pivot.
     * Pivot is in the correct position of the array
     * @param a
     * @param begin
     * @param end
     */
    public void quickSort(int[] a, int begin, int end){
        if(begin < end){
            int partitionIndex = partition(a, begin, end);
            quickSort(a,  begin, partitionIndex-1);
            quickSort(a, partitionIndex+1, end);
        }
    }

    /**
     * Find all the elements which is less than the pivot and add to array
     * Swap the pivot with correct position and return the index of the position where pivot eventually fits.
     * @param a
     * @param begin
     * @param end
     * @return
     */
    private int partition(int[] a, int begin, int end) {
        int pivot = a[end]; // consider end element as the pivot value

        for(int j = begin; j < end ; j++){
            if(a[j] <= pivot){
                swap(a, begin++, j); // move begin index untill all elements lower than pivot is at the left.
            }
        }
        swap(a, begin, end);
        return begin;
    }

    private void swap(int[] a, int beginIndx, int endIndex){
        int temp = a[beginIndx];
        a[beginIndx] = a[endIndex];
        a[endIndex] = temp;
    }


    public static void main(String[] args){
        int[] a = new int[5];
        a[0] = 4;
        a[1] = 43;
        a[2] = 3;
        a[3] = 2;
        a[4] = 9;

        QuickSort q = new QuickSort();
        q.quickSort(a, 0, a.length-1);

        System.out.println(Arrays.toString(a));

    }

}
